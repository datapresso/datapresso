/*
 Adapted from the Apache UIMA sample DB consumer
 http://svn.apache.org/viewvc/incubator/uima/uimaj/trunk/uimaj-examples/src/main/java/org/apache/uima/examples/cpe/PersonTitleDBWriterCasConsumer.java?view=co
 */

package com.dp.dhs.uima.cpe;

import java.io.File;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import com.dp.dhs.model.Constants;
import com.dp.dhs.model.EdgarProcessorConfig;
import com.dp.dhs.model.TableData;
import com.dp.dhs.uima.type.Company;
import com.dp.dhs.uima.type.Compensation;
import com.dp.dhs.uima.type.Person;
import com.dp.dhs.uima.type.SourceDocInfo;
import com.dp.dhs.uima.type.SummaryCompensationTable;


/**
 * A simple CAS consumer that creates a Derby (Cloudscape) database in the file system. You can
 * obtain this database from http://incubator.apache.org/derby/ *
 * <p>
 * This CAS Consumer takes one parameters:
 * <ul>
 * <li><code>OutputDirectory</code> - path to directory which is the "System" directory for the
 * derby DB. </li>
 * </ul>
 * 
 * It deletes all the databases at the system location (!!!), Creates a new database (takes the most
 * time - order of 10+ seconds) creates a table in the database to hold instances of the PersonTitle
 * annotation Adds entries for each PersonTitle annotation in each CAS to the database
 * 
 * To use - add derby.jar to the classpath when you start the CPE GUI - run the CPE Gui and select
 * the Name Recognizer and Person Title Annotator aggregate. - a good sample collection reader is
 * the FileSystemCollectionReader, and - a good sample data is the <UIMA_HOME>/examples/data
 * 
 * The processing is set up to handle multiple CASes. The end is indicated by using the
 * CollectionProcessComplete call.
 * 
 * Batching of updates to the database is done. The batch size is set to 50. The larger size takes
 * more Java heap space, but perhaps runs more efficiently.
 * 
 * The Table is populated with a slightly denormalized form of the data: the URI of the document is
 * included with every record.
 * 
 * 
 */
public class EdgarDBWriterCasConsumer extends CasConsumer_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * Derby Database will be written.
   */
  public static final String PARAM_DB_DRIVER = "driver";
  public static final String PARAM_DB_URL = "url";
  public static final String PARAM_DB_USER = "user";
  public static final String PARAM_DB_PASS = "password";

  public static final int MAX_URI_LENGTH = 80;
  public static final int MAX_TITLE_LENGTH = 20;        
  public static final int DB_LOAD_BATCH_SIZE = 50;
  private int batchCounter = DB_LOAD_BATCH_SIZE;
  
  public static String driver = null;
  public static String url = null;
  public static String user = null;
  public static String pass = null;

  private boolean firstCall = true;
  private static boolean firstEverCall = true;
  private PreparedStatement stmt;
  private Connection con;
  private long startTime;

  public void initialize() throws ResourceInitializationException {
    startTime = System.currentTimeMillis();
    System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " initialize() called");
    driver = (String) getConfigParameterValue(PARAM_DB_DRIVER);  
    url = (String) getConfigParameterValue(PARAM_DB_URL);
    user = (String) getConfigParameterValue(PARAM_DB_USER);
    pass = (String) getConfigParameterValue(PARAM_DB_PASS);   
    
    //load db driver
    if (firstEverCall) 
    {
      firstEverCall = false;
      System.out.println("Time: "
                      + (System.currentTimeMillis() - startTime)
                      + " DB Writer: Doing first process call ever (even during re-runs) initialization");
      try 
      {
        Class.forName(driver).newInstance();
        System.out.println("Time: " + (System.currentTimeMillis() - startTime)
                + " DB Writer: Loaded PostGreSQL DB driver OK");
      } catch (ClassNotFoundException e) {
        System.err.println("No driver found for postgresql - check class path.");
      } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }  

    //connect to the db
    con = connectDB(url, user,pass);    
    System.out.println("Time: " + (System.currentTimeMillis() - startTime));
    

          //clean up current tables
          try 
          {
            Statement sqlStmt = con.createStatement();
            sqlStmt.execute("delete from company");
            sqlStmt.execute("delete from compensation");
            sqlStmt.execute("delete from person");    
            sqlStmt.close(); // free resources associated with this
            con.setAutoCommit(false); // need this for batch updating
          } catch (SQLException sqle) 
          {
              System.err.println("SQL Error: " + sqle.getErrorCode() + " "
                      + sqle);
          }
          System.out.println("Time: " + (System.currentTimeMillis() - startTime)
                  + " DB Writer: First Time Initiailization: emptied the CERS tables.");

  
  }

  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS is assumed to contain annotations of type PersonTitle, created with the
   * PersonTitleAnnotator. These Annotations are stored in a database table called PersonTitle.
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException 
  {
    System.out.println("Time: " + (System.currentTimeMillis() - startTime)
            + " DB Writer: ProcessCas called");
    JCas jcas;
    try 
    {
      jcas = aCAS.getJCas();
    } 
    catch (CASException e) 
    {
      throw new ResourceProcessException(e);
    }
      // get the singleton instance of the SourceDocumentInformation
      SourceDocInfo sdi = (SourceDocInfo) 
              jcas.getAnnotationIndex(SourceDocInfo.type).iterator().next();

      System.out.println("Time: " + (System.currentTimeMillis() - startTime)
              + " DB Writer: Processing doc: '" + sdi.getUri() + "'");

      // store data from UIMA feature structures into relational database
      store (jcas);
  }


  //helper method to connect to the database
  public static Connection connectDB(String url, String user, String pass) 
  {
      try {
          Connection connection = DriverManager.getConnection(url, user, pass);
          return(connection);
      }
      catch(SQLException sqle) {
          System.err.println("Error connecting: " + sqle);
          return(null);
      }
  }
  

  public void collectionProcessComplete(ProcessTrace arg0) throws ResourceProcessException,
          IOException 
 {
    firstCall = true;

    try {
      
	  /* 07/03/09 C.Ding since we executeBatch/commit after process each feature structure in the Store() method
	   * we do not need to executeBatch/commit here
	   * However if we redesign the consumer later on and only persist one feature structure per consumer, it will prbably
	   * be a better pattern to executeBatch/commit here.
	   *   	if (batchCounter < DB_LOAD_BATCH_SIZE) 
	      {
	        System.out.println("Time: " + (System.currentTimeMillis() - startTime)
	                + " DB Writer: Batch writing updates - processComplete call");
	        stmt.executeBatch();
	        con.commit();
	        batchCounter = DB_LOAD_BATCH_SIZE;
	      }
	  */	
      stmt.close();
      con.close();
      System.out.println("Time: " + (System.currentTimeMillis() - startTime)
              + " DB Writer: Sucessfully closed the connection - done.");

    } catch (SQLException e) {
      System.err.println("Unexpected SQL exception");
      e.printStackTrace();
    }
  }

  //generic database store method
  public void store(JCas jCas) throws ResourceProcessException
  {
      try 
      {
          //store Company Info
          stmt = con.prepareStatement("insert into company values (?, ?, ?, ?, ?, ?, ?, ?)");
    	  for (FSIterator iter = jCas.getAnnotationIndex(Company.type).iterator(); 
               iter.hasNext();)
          {
            Company c = (Company)iter.next();
            System.out.println(truncate(c.getCoveredText(), MAX_TITLE_LENGTH));
            stmt.setLong(1, Long.parseLong(c.getCik()));
            stmt.setString(2, c.getName());
            stmt.setString(3, c.getStreet());
            stmt.setString(4, c.getCity());
            stmt.setString(5, c.getState());
            stmt.setString(6, c.getZip());
            stmt.setString(7,c.getCountry());
            stmt.setString(8,c.getCik());
            stmt.addBatch();
            batchCounter--;
            if (batchCounter <= 0) 
            	execute("company");
          }
          //execute the batch if there are some leftovers 
    	  if (batchCounter < DB_LOAD_BATCH_SIZE)
    		  execute("company");


          //store Person Info
          stmt = con.prepareStatement("insert into person values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");            
      	  for (FSIterator iter = jCas.getAnnotationIndex(Person.type).iterator(); 
                 iter.hasNext();)
            {
              Person p = (Person)iter.next();
              System.out.println(truncate(p.getCoveredText(), MAX_TITLE_LENGTH));
              stmt.setLong(1, p.getId());
              stmt.setString(2, p.getFirstname());
              stmt.setString(3, p.getMiddlename());
              stmt.setString(4, p.getLastname());
              stmt.setInt(5, p.getAge());
              stmt.setString(6,p.getGender());
              //TODO: employment history needs to be filled out later
              stmt.setString(7,null);
              stmt.setString(8,p.getEducation());
              //TODO: certificate needs to be filled out later
              stmt.setArray(9, null);
              stmt.setLong(10,Long.parseLong(p.getCompanyid()));
              stmt.addBatch();
              batchCounter--;
              if (batchCounter <= 0) 
              	execute("person");
            }
            //execute the batch if there are some leftovers 
      	  if (batchCounter < DB_LOAD_BATCH_SIZE)
      		  execute("person");

            
          //store Compensation Info
          stmt = con.prepareStatement("insert into compensation values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");              
      	  for (FSIterator iter = jCas.getAnnotationIndex(Compensation.type).iterator(); 
                 iter.hasNext();)
            {
              Compensation cp = (Compensation)iter.next();
              stmt.setLong(1, Long.parseLong(cp.getCompanyid()));
              stmt.setString(2, cp.getName());
              stmt.setString(3, cp.getPosition());
              stmt.setFloat(4, cp.getSalary());
              stmt.setFloat(5, cp.getBonus());
              stmt.setFloat(6, cp.getOther());
              stmt.setFloat(7, cp.getOptions());
              stmt.setFloat(8,cp.getAll());
              stmt.setLong(9,cp.getPersonid());
              stmt.setInt(10, cp.getYear());
              stmt.addBatch();
              batchCounter--;
              if (batchCounter <= 0) 
              	execute("compensation");
            }
            //execute the batch if there are some leftovers 
      	  if (batchCounter < DB_LOAD_BATCH_SIZE)
      		  execute("compensation");
          
      }
      catch(SQLException sqle) {
          if (sqle.getErrorCode() != 1062) {
              System.err.println("SQL Error: " + sqle.getErrorCode() + " "
              + sqle);
          }
      }
  }
  

  //helper method to execute/commit
  private void execute(String fs) throws ResourceProcessException
  {
      try
      {
		  stmt.executeBatch();
	      // NOTE TO USERS: Although we "commit" here, you may want
	      // to delay committing until batchProcessComplete - or some
	      // other logical point - to keep the DB in a more consistent
	      // state (not partially updated).
	      con.commit();
          System.out.println("Time: " + (System.currentTimeMillis() - startTime)
                  + " DB Writer: Batch writing updates- " + fs + "- process call");
	     
	      batchCounter = DB_LOAD_BATCH_SIZE;
      }
      catch(SQLException sqle) //if not BatchUpdateException
	  {
  	    //do some special loggings if it is a BatchUpdateException
    	if (sqle instanceof BatchUpdateException)
    	{
	    	System.err.println("Contents of BatchUpdateException:");
		    System.err.println(" Update counts: ");
		    int [] updateCounts = ((BatchUpdateException)sqle).getUpdateCounts();             
		    for (int i = 0; i < updateCounts.length; i++) {
		      System.err.println("  Statement " + i + ":" + updateCounts[i]);
		    }
		    System.err.println(" Message: " + sqle.getMessage());     
		    System.err.println(" SQLSTATE: " + sqle.getSQLState());
		    System.err.println(" Error code: " + sqle.getErrorCode());
		    SQLException ex = sqle.getNextException();                 
		    while (ex != null) {                                      
		      System.err.println("SQL exception:");
		      System.err.println(" Message: " + ex.getMessage());
		      System.err.println(" SQLSTATE: " + ex.getSQLState());
		      System.err.println(" Error code: " + ex.getErrorCode());
		      ex = ex.getNextException();
		    }
    	}    
		//Try to rollback      
    	try {
	            // NOTE TO USERS: depending on your error recover logic, you'll
	            // probably want to do both a rollback and a clearBatch if an
	            // exception occurs.
	            con.rollback();
	          } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	          }
	          try {
	            stmt.clearBatch();
	          } catch (SQLException e2) {
	            // TODO Auto-generated catch block
	            e2.printStackTrace();
	          }
	          throw new ResourceProcessException(sqle);
	        }
  }
  
  private String truncate(String s, int length) 
  {
	    if (s.length() <= length)
	      return s;
	    return s.substring(0, length);
  }
}
