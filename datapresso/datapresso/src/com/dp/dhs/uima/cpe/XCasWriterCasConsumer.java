/**************************************************************************/
/*  Licensed Materials - Property of IBM                                  */
/*  (C) Copyright IBM Corporation 2003, 2004.                             */
/*  All rights reserved.                                                  */		
/*                                                                        */
/* US Government Users Restricted Rights - Use, duplication or            */
/* disclosure restricted by GSA ADP Schedule Contract with                */
/* IBM Corporation.                                                       */
/**************************************************************************/
/*  Permission Notice                                                     */
/*                                                                        */
/*  Permission is granted to copy, use, modify, and merge this sample     */
/*  software into your applications and to permit others to do any of the */
/*  foregoing. You may further distribute this software for               */
/*  commercial purposes only as part of your application that adds        */
/*  significant value and function beyond that provided by these          */
/*  samples.                                                              */
/*  You must include this permission statement and retain the copyright   */
/*  notice in all copies and modified versions of this software.          */
/*                                                                        */
/**************************************************************************/
/*                                                                        */
/*  DISCLAIMER OF WARRANTIES                                              */
/*                                                                        */
/*  The sample software is provided to you by IBM to assist you in        */
/*  developing your applications. THIS SOFTWARE IS PROVIDED AS-IS,        */
/*  WITHOUT WARRANTY OF ANY KIND. IBM SHALL NOT BE LIABLE FOR ANY         */
/*  DAMAGES ARISING OUT OF YOUR USE OR THE USE BY ANY THIRD PARTY OF      */
/*  OF THE SAMPLE SOFTWARE EVEN IF IT HAS BEEN ADVISED OF THE POSSIBILITY */
/*  OF SUCH DAMAGES. IN ADDITION, IBM SHALL NOT BE LIABLE FOR ANY THIRD   */
/*  PARTY CLAIMS AGAINST YOU.                                             */
/*                                                                        */
/**************************************************************************/
package com.dp.dhs.uima.cpe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.xml.sax.SAXException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XCASSerializer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.XMLSerializer;

/**
 * A simple CAS consumer that generates XCAS (XML representation of the CAS) files
 * in the filesystem.
 * <p> 
 * This CAS Consumer takes one parameters: 
 * <ul>
 *   <li><code>OutputDirectory</code> - path to directory into which output 
 *       files will be written</li>
 * </ul> 
 * 
 * 
 */
public class XCasWriterCasConsumer extends CasConsumer_ImplBase 
{
  /**
   * Name of configuration parameter that must be set to the path of
   * a directory into which the output files will be written.
   */
  public static final String PARAM_OUTPUTDIR = "OutputDirectory";
   
	private File mOutputDir;
  private int mDocNum;
 	
   
   public void initialize()
     throws ResourceInitializationException
   {
   	 mDocNum = 0;
     mOutputDir = new File(((String)getConfigParameterValue(PARAM_OUTPUTDIR)).trim());
     if (!mOutputDir.exists())
     {
       mOutputDir.mkdirs();
     }
   }


	/** Processes the CasContainer which was populated by the TextAnalysisEngines.
	 * <br> In this case, the CAS is converted to XML and written into the 
	 * output file .
	 * 
	 * @param aCAS CasContainer which has been populated  by the TAEs
	 * 
	 * @throws ResourceProcessException if there is an error in processing the 
	 * 	Resource
	 * 
	 * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
	 */
	public void processCas(CAS aCAS) throws ResourceProcessException 
  {
		JCas jcas;
    try
    {
      jcas = aCAS.getJCas();
    } 
    catch (CASException e)
    {
    	throw new ResourceProcessException(e);
    }	
		
    // retreive the filename of the input file from the CAS 
    FSIterator it = jcas.getJFSIndexRepository().getAnnotationIndex(SourceDocumentInformation.type).iterator();
    File outFile = null;
    if (it.hasNext())
    {
			SourceDocumentInformation fileLoc = (SourceDocumentInformation)it.next();
			File inFile;
      try
      {
        inFile = new File(new URL(fileLoc.getUri()).getPath());
				outFile = new File(mOutputDir, inFile.getName());
      } 
      catch (MalformedURLException e1)
      {
      	//invalid URL, use default processing below
      }
    }
    if (outFile == null)
    {
    	outFile = new File(mOutputDir, "doc"+ (mDocNum++) + ".xcas" );
    }  	// serialize XCAS and write to output file
		try
    {
      writeXCas(jcas.getCas(), outFile);
		} 
    catch (IOException e) 
    {
			throw new ResourceProcessException(e);
		} 
		catch (SAXException e)
    {
			throw new ResourceProcessException(e);
    }
	}
  
  /**
   * Serialize a CAS to a file in XCAS format
   * 
   * @param aCas CAS to serialize
   * @param name output file
   * 
   * @throws IOException if an I/O failure occurs
   * @throws SAXException if an error occurs generating the XML text
   */
	private void writeXCas(CAS aCas, File name)
	  throws IOException, SAXException 
	{
		FileOutputStream out = null;
		
		try
	  {
			out = new FileOutputStream(name);	  	
			XCASSerializer ser = new XCASSerializer(aCas.getTypeSystem());
			XMLSerializer xmlSer = new XMLSerializer(out, false);
			ser.serialize(aCas, xmlSer.getContentHandler());
	  }
	  finally
	  {
	  	if (out != null)
	  	{
	  		out.close();		
	  	}
	  }
	}

}
