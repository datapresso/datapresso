package com.dp.dhs.uima.annotator;

//requires Java 1.5 due to the UUID class below

import java.util.Iterator;

import org.apache.uima.analysis_engine.ResultSpecification;
import org.apache.uima.analysis_engine.annotator.AnnotatorConfigurationException;
import org.apache.uima.analysis_engine.annotator.AnnotatorContext;
import org.apache.uima.analysis_engine.annotator.AnnotatorContextException;
import org.apache.uima.analysis_engine.annotator.AnnotatorInitializationException;
import org.apache.uima.analysis_engine.annotator.AnnotatorProcessException;
import org.apache.uima.analysis_engine.annotator.JTextAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.jcas.JFSIndexRepository;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;

import java.io.*;
import java.net.URISyntaxException;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.UUID;

import org.jdom.*;

import com.dp.dhs.model.Constants;
import com.dp.dhs.model.EdgarProcessorConfig;
import com.dp.dhs.model.TableData;
import com.dp.dhs.uima.type.Company;
import com.dp.dhs.uima.type.Compensation;
import com.dp.dhs.uima.type.Person;
import com.dp.dhs.uima.type.SummaryCompensationTable;

/**
 * Example annotator that detects meetings from the co-occurrence of a
 * RoomNumber, a Date, and two Times (start and end), within a specified
 * "window" size.
 * 
 * 
 */
public class CompTableRowAnnotator extends JTextAnnotator_ImplBase
{

	// /////////////////////////////////////
	// attributes

	private String tableText;
    

	private String dataStartTag;

	private Element tableConfig;
	
	//TODO: use CIK number for now and may need to use an artificial ID instead CIK later on
	private String companyId; 
	
	private EdgarProcessorConfig appConfig = null;

	private ArrayList dataRows;

	// Current position in docText
	private int cursor = 0;

	private Pattern p;

	private Matcher m;
	

	  public static final String PARAMS_EDGAR_CONFIG_HOME = "edgar.config.home";
	  public static final String PARAMS_EDGAR_CONFIG_FILE = "edgar.config.file";
	  
	 
	  
	  /**
	   * Performs any startup tasks required by this annotator.  This implementation
	   * reads the configuration parmaeters and compiles the regular expressions.
	   * 
	   * @see org.apache.uima.analysis_engine.annotator.TextAnnotator#initialize(CAS,AnnotatorContext)
	   */
	  public void initialize(AnnotatorContext aContext)
	    throws AnnotatorConfigurationException, AnnotatorInitializationException
	  {
	    super.initialize(aContext);
	    try
		{
		   //Retrieve configuration parameters
	       String configFile = (String) aContext.getConfigParameterValue(PARAMS_EDGAR_CONFIG_FILE);
	       String configHome =(String) aContext.getConfigParameterValue(PARAMS_EDGAR_CONFIG_HOME);
 		   dataStartTag = ((String) aContext.getConfigParameterValue("DataStartTag"));
		   appConfig = new EdgarProcessorConfig(configHome,configFile);
           Iterator it = appConfig.getTableConfig();
           while (it.hasNext()) {
               tableConfig = (Element)it.next();
           }

		}
	    catch(AnnotatorContextException e)
	    {
	      throw new AnnotatorInitializationException(e);  
	    }
	    catch(IOException e)
	    {
	      throw new AnnotatorInitializationException(e);  
	    }
	    catch(URISyntaxException e)
		{
	    	throw new AnnotatorInitializationException(e);
		}
		catch(JDOMException e)
		{
			throw new AnnotatorInitializationException(e);
		}
	  } 
	


	/**
	 * @see org.apache.uima.analysis_engine.annotator.JTextAnnotator#process(org.apache.uima.jcas.JCas,
	 *      org.apache.uima.analysis_engine.ResultSpecification)
	 */
	public void process(JCas aJCas, ResultSpecification aResultSpec)
			throws AnnotatorProcessException
	{
	    int typeAnnotStart = 0;
	    int typeAnnotEnd = 0;
	    int typePersonStart = 0;
	    int typePersonEnd = 0 ;
	    String lastName = null;
	    String middleName = null;
	    String firstName = null;
	    int personId = 0;
		try
		{

			// get annotation indexes
			JFSIndexRepository indexes = aJCas.getJFSIndexRepository();
			
			// get Company annotations
			FSIndex companyIndex = indexes.getAnnotationIndex(Company.type);
			FSIterator companyIter = companyIndex.iterator();
			Company company = null;
			//companyIter.moveToFirst();
			if (companyIter.hasNext())
			{	
				company = (Company) companyIter.next();
				companyId = company.getCik(); // use CIK
			}
			else
				throw new AnnotatorContextException(Constants.EDGAR_MESSAGE_CATALOG, "company_not_found_error", null);
			
			//get Compensation annotations
			FSIndex compTableIndex = indexes.getAnnotationIndex(SummaryCompensationTable.type);
			FSIterator compTableIter = compTableIndex.iterator();
			SummaryCompensationTable compTable = null;
			if (compTableIter.hasNext())
				compTable = (SummaryCompensationTable) compTableIter.next();
			else
				throw new AnnotatorContextException(Constants.EDGAR_MESSAGE_CATALOG, "summary_commpensation_table_not_found_error",null);
			
			// get the summary compensation table string
			tableText = compTable.getTableText();
			
			
			// start processing
			ArrayList columns = getColumns();
			ArrayList rows = getRows();
			dataRows = new ArrayList();
			Iterator rowIter = rows.iterator();
			int patternFlags = Pattern.CASE_INSENSITIVE;
			int rowIndex = -1;
			//loop through each table row
			while (rowIter.hasNext())
			{
				rowIndex++;
				String line = (String) rowIter.next();
				cursor = 0;
				float result = 0;
				TableData bestGuess = new TableData();
				ArrayList row = new ArrayList();
				Iterator columnIter = columns.iterator();
				int columnIndex = 0;
				
				while (columnIter.hasNext())
				{
					TableData data = (TableData) columnIter.next();

					Element columnCfg = data.getColumnCfg();
					boolean multiword = data.isMultiword();
					//\S = [^\s] not a space
					p = Pattern.compile("(\\S+)", patternFlags);
					m = p.matcher(line);
					//loop through all the non-empty items from cursor to check if it belongs to
					//a predefined column
					while (m.find(cursor))
					{
						cursor = m.start(1);
						String word = m.group(1);
						//next Column is defined in getColumn
						if (data.nextColumn != null)
						{
							if (cursor >= data.nextColumn.getPosition())
							{
								//06/09/07 C.Ding overlap is not used yet. so 
								//the following is always executed
								if (data.hasOverlap() == false)
								{
									if (data.toString() == null)
									{
										data.setDefault(); //no default value has been specified yet in table.xml
									}
									break;
								}
							}
						}
						//do the real information extraction based on threshold 
						//a) the information item is recognized 						
						if (data.isValid(line, cursor))
						{
							if (multiword)
							{
								data.appendValue(line, cursor);
								cursor = m.end();
							} else
							{
								data.setValue(line, cursor);
								cursor = m.end();
								break;
							}
						} else
						//b) the information is not recognized based on threshold	
						{
							//result is the cumulative weights (compared against previous value)
							if (data.getResult() > result)
							{
								result = data.getResult();
								bestGuess = data;
							}
							//if this is the last column
							if (!columnIter.hasNext())
							{
								/*
								 * This data is not recognized by any of the
								 * column objects. We will now move to the next
								 * piece of data.
								 */
								//even though the threadhold hasn't been reached, as long as some partial match occurs, we
								//can stil treat the best guess as the data
								if (result > 0)
								{
									data = bestGuess;
									if (data.isMultiword())
									{
										data.appendValue(line, cursor);
									} else
									{
										data.setValue(line, cursor);
									}
									cursor = m.end(1);
									break;
								} 
								//this item is not recognized by any column through any of the 4 methods
								//in this case choose the first item as the data
								//TODO: need to confirm
								else
								{
									cursor = m.end(1);
									columnIter = columns.iterator();
									data = (TableData) columnIter.next();
								}
							}
							//TODO: the following else is unnecessary since the loop will automatically
							//terminate when there is no more column to check upon, will remove later on
							else
							{

								break;
							}
						}
					}
					row.add(data);
				}
				//refine the data items based on the actually text row
				ArrayList new_columns = new ArrayList();
				columnIter = columns.iterator();
				boolean missingPrimaryKey = false;
				boolean newTuple = false;
				while (columnIter.hasNext())
				{
					TableData td = (TableData) columnIter.next();
					Element columnCfg = td.getColumnCfg();
					int position = td.getPosition();

					// Check if column is required but has no value
					if (td.isPrimaryKey() && td.toString() == null)
					{
						missingPrimaryKey = true;
					}

					// Not the last row
					if (rowIndex < (rows.size() - 1))
					{
						//currently only the first column (person name) field is set to Nonrepeating = true
						//other columns are false by default
						//this attribute is configured in the table.xml
						if (td.isNonrepeating())
						{
							if (td.isValid((String) rows.get(rowIndex + 1), 0))
							{
								newTuple = true;
							}
						}
					}
					if (newTuple)
					{
						new_columns.add(new TableData(columnCfg, appConfig,
								position));
					} else if (!(td.isMultiline() || td.isNonrepeating()))
					{
						//TODO: ? what is the difference between multiline and nonrepeating?
						new_columns.add(new TableData(columnCfg, appConfig,
								position));
					} else
					{
						new_columns.add(td);
					}
				}
				if (!missingPrimaryKey)
				{
					dataRows.add(row);
				}
				//06/09/07 C.Ding added the following else to signal if a data item
				//is discarded because of missing PrimaryKey value
				else
				{
	              	getContext().getLogger().log(Level.WARNING,
	                        "This row is discarded because of missing primary key" + row.toString());
				}
				//create new columns if needed (used the data rows instead of header row to amend the data)
				columns = new_columns;
				//link the new columns together
				for (int i = 0; i < columns.size(); i++)
				{
					if ((i + 1) < columns.size())
					{
						TableData td = (TableData) columns.get(i);
						td.nextColumn = (TableData) columns.get(i + 1);
					}
				}

			}//end of row iteration
			
			//Translate the tabledata information into type/features
			//TODO: should use dataRows instead of data
			ArrayList data = dataRows;
            
            //Fill out the feature values
            rowIter = data.iterator();
            String prevName = null;
            while( rowIter.hasNext() ) 
            {
	
	            ArrayList row = (ArrayList)rowIter.next();
	            Iterator columnIter = row.iterator();
	            Compensation annot =  new Compensation(aJCas, typeAnnotStart, typeAnnotEnd);
	            Person pAnnot = new Person(aJCas, typePersonStart, typePersonEnd);
	            
	            while ( columnIter.hasNext() ) 
	            {
	                TableData td = (TableData)columnIter.next();
	                if(td.getDbName().equals("name"))
	                {
	                	annot.setName(td.toString());
	                	typeAnnotStart = td.getPosition(); 
	                	//only create annotations if it is a new person
	                	if (!td.toString().trim().equals(prevName))
	                	{
		                	typePersonStart = typeAnnotStart;
		                  	typePersonEnd = td.getPosition();
		                	//TODO: 06/28/09 C.Ding this ID generation should be enhanced later on. For now this ID
		                	//is not a primary key in the DB and the data can be cleaned up in the database level later on
		                	//the goal here is to generate a pseudo-unique ID for our research purpose
		                	personId = UUID.randomUUID().hashCode();
		                	//match first name , middle name and last name
		                	String[] arName = td.toString().trim().split("\\s");
		                	firstName = arName[0];
			               	if (arName.length == 3 ) //with middle name
		                	{
			               		middleName = arName[1];
			               		lastName = arName[2];
		                	}
			               	else if (arName.length == 2) //no middle name
			               	{
			               		lastName = arName[1];
			               	}
			               	else //names cannot be parsed correctly
			               	{
				              	getContext().getLogger().log(Level.WARNING,
				                        "This name cannot be parsed correctly- " + td.toString());
			               		
			               	}
		                	pAnnot.setFirstname(firstName);
		                	pAnnot.setLastname(lastName);
		                	pAnnot.setMiddlename(middleName);
		                	pAnnot.setCompanyid(companyId);
		                	pAnnot.setId(personId);
		    	            pAnnot.setBegin(typePersonStart);
		    	            pAnnot.setEnd(typePersonEnd);
		                	pAnnot.addToIndexes();
	                	}
	                	prevName = td.toString().trim();
	                }
	                else if(td.getDbName().equals("position"))
	                {
	                	annot.setPosition(td.toString());

	                }
	                else if(td.getDbName().equals("year"))
	                {
	                	if (td.toString() == null)
	                		annot.setYear(1900);
	                	else
	                		annot.setYear(Integer.parseInt(td.toString()));
	                }
	                else if(td.getDbName().equals("salary"))
	                {
	                	if (td.toString() == null)
	                		annot.setSalary(0);
	                	else
	                		annot.setSalary(Float.parseFloat(td.toString()));
	                }
	                else if(td.getDbName().equals("bonus"))
	                {
	                	if (td.toString() == null)
	                		annot.setBonus(0);
	                	else
	                		annot.setBonus(Float.parseFloat(td.toString()));
	                }
	                else if(td.getDbName().equals("options"))
	                {
	                	if (td.toString() == null)
	                		annot.setOptions(0);
	                	else
	                		annot.setOptions(Float.parseFloat(td.toString()));
	                }
	                else if(td.getDbName().equals("all"))
	                {
	                	if (td.toString() == null)
	                		annot.setAll(0);
	                	else
	                		annot.setAll(Float.parseFloat(td.toString()));
	                	typeAnnotEnd = td.getPosition();
	                }
	            }
		        //revise the begin/end feature since we just figured out the correct values
	            annot.setCompanyid(companyId);
	            annot.setPersonid(personId);
	            annot.setBegin(typeAnnotStart);
		        annot.setEnd(typeAnnotEnd);
	            annot.addToIndexes();       
            }
		} 
		//catch (JDOMException je)
		//{
		//	AnnotatorProcessException ape = new AnnotatorProcessException(je);
		//	throw ape;
		//} 
		catch (IOException ie)
		{
			throw new AnnotatorProcessException(ie);

		}
	    catch(NullPointerException npe)
	    {
	    	throw new AnnotatorProcessException(npe);  
	    }
	    
	    catch(AnnotatorContextException ace)
	    {
	    	throw new AnnotatorProcessException(ace);
	    }
		
	}

	/**
	 *  get predefined table columns from the config file and create the columns list based
	 *  on what columns are available via column headings of each document
	 */
	private ArrayList getColumns() throws IOException
	{

		ArrayList columns = new ArrayList();

		/* Parse the header section of the table */
		int patternFlags = Pattern.MULTILINE + Pattern.CASE_INSENSITIVE;

		/* Find the end of the header section of the table */
		p = Pattern.compile(dataStartTag, patternFlags);
		m = p.matcher(tableText);
		if (m.find())
		{
			cursor = m.end();
		} else
		{
			throw new IOException("Table data start tag not found");
		}
		String tableHeader = new String(tableText).substring(0, cursor);
		cursor = 0;

		/* Get possible columns from table configuration object */
		List tableColumns = tableConfig.getChild("Columns").getChildren();

		/*
		 * Iterate over each possible column and check current document to see
		 * if column exists. If it does, create a TableData object for it.
		 */
		Iterator it = tableColumns.iterator();

		int lastPosition = 0;
		while (it.hasNext())
		{
			Element columnConfig = (Element) it.next();

			String header = columnConfig.getAttributeValue("name");
			//TODO: seems "^*" + header is good enough
			String regex = "(^).*(" + header + ")";
			p = Pattern.compile(regex, patternFlags);
			m = p.matcher(tableHeader);

			if (m.find())
			{
				/*
				 * Found a matching column in the document so create a TableData
				 * object for it.
				 */
				//position is pretty much the length span of the text being evaluated
				int position = m.start(2) - m.start(1);
				TableData td = new TableData(columnConfig, appConfig, position);
				columns.add(td);
			}
		}
		//Make sure the columns are sorted from left to right (year, salary, bonus etc)
		Collections.sort(columns);

		/*
		 * We now link the columns together. This will be useful when we need to
		 * know information about the next column. 
		 * This is useful for the "shallow parser" for some of the columns
		 */
		for (int i = 0; i < columns.size(); i++)
		{
			if ((i + 1) < columns.size())
			{
				TableData td = (TableData) columns.get(i);
				td.nextColumn = (TableData) columns.get(i + 1);
			}
		}
		return columns;
	}

	private ArrayList getRows() throws IOException
	{

		ArrayList rows = new ArrayList();

		/* Parse the header section of the table */
		int patternFlags = Pattern.MULTILINE + Pattern.CASE_INSENSITIVE;

		/* Find the end of the header section of the table */
		p = Pattern.compile(dataStartTag, patternFlags);
		m = p.matcher(tableText);
		if (m.find())
		{
			cursor = m.end();
			p = Pattern.compile("$", patternFlags);
			m = p.matcher(tableText);
			m.find(cursor);
			cursor = m.end();
		} else
		{
			throw new IOException("Table data start tag not found");
		}
		String tableData = new String(tableText).substring(cursor);
		cursor = 0;

		String regex = "(^).*($)";
		p = Pattern.compile(regex, patternFlags);
		m = p.matcher(tableData);

		while (m.find())
		{
			String line = tableData.substring(m.start(1), m.start(2));
			if ((line.matches("^\\s*$")) || (line.length() == 0))
			{
				// Don't add blank lines
			} else
			{
				line = preProcess(line);
				rows.add(line);
			}
		}
		return rows;
	}

	public ArrayList getData()
	{

		return dataRows;

	}

	private String preProcess(String line)
	{

		if (tableConfig.getChild("Preprocess") != null)
		{
			Iterator it = tableConfig.getChild("Preprocess").getChildren(
					"Replace").iterator();

			while (it.hasNext())
			{
				Element r = (Element) it.next();
				String findPattern = r.getAttributeValue("pattern");
				String replacePattern = r.getAttributeValue("with");
				line = line.replaceAll(findPattern, replacePattern);
			}

		}
		return line;
	}
	
//	The following two methods are directly from CAS References 
//	Get a type object corresponding to a name.
//	If it doesn't exist, throw an exception.
	private Type initType(String typeName, TypeSystem ts) throws AnnotatorInitializationException 
	{
		Type type = ts.getType(typeName);
		if (type == null) 
		{
		throw new AnnotatorInitializationException(
		AnnotatorInitializationException.TYPE_NOT_FOUND,
		new Object[] { this.getClass().getName(), typeName });
		}
	return type;
	}

//	Get a feature object from a name and a type object.
//	If it doesn't exist, throw an exception.
	private Feature initFeature(String featName, Type type) throws AnnotatorInitializationException 
	{
		Feature feat = type.getFeatureByBaseName(featName);
		if (feat == null) {
		throw new AnnotatorInitializationException(
		AnnotatorInitializationException.FEATURE_NOT_FOUND,
		new Object[] { this.getClass().getName(), featName });
		}
		return feat;
	}

}
