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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import com.dp.dhs.uima.type.SourceDocInfo;

/**
 * A simple collection reader that reads documents from a directory 
 * in the filesystem.  It can be configured with the following parameters:
 * <ul>
 *   <li><code>InputDirectory</code> - path to directory containing files</li>
 *   <li><code>Encoding</code> (optional) - character encoding of the input 
 *      files</li>
 *   <li><code>Language</code> (optional) - language of the input documents</li>
 * </ul> 
 * 
 * 
 */
public class FileSystemCollectionReader extends CollectionReader_ImplBase
{
  /**
   * Name of configuration parameter that must be set to the path of
   * a directory containing input files.
   */
  public static final String PARAM_INPUTDIR = "InputDirectory";

  /**
   * Name of configuration parameter that contains the character encoding used
   * by the input files.  If not specified, the default system encoding will
   * be used.
   */
  public static final String PARAM_ENCODING = "Encoding";

  /**
   * Name of optional configuration parameter that contains the language of
   * the documents in the input directory.  If specified this information will
   * be added to the CAS.
   */
  public static final String PARAM_LANGUAGE = "Language";
    
  private ArrayList mFiles;
  private String mEncoding;
  private String mLanguage;
  private int mCurrentIndex;

  /**
   * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
   */
  public void initialize() throws ResourceInitializationException
  {
    File directory = new File((String)getConfigParameterValue(PARAM_INPUTDIR));
    mEncoding = (String)getConfigParameterValue(PARAM_ENCODING);
    mLanguage = (String)getConfigParameterValue(PARAM_LANGUAGE);
    mCurrentIndex = 0;

		//if input directory does not exist or is not a directory, throw exception
		if (!directory.exists() || !directory.isDirectory())
		{
			throw new ResourceInitializationException(
				ResourceConfigurationException.DIRECTORY_NOT_FOUND,
				new Object[]{PARAM_INPUTDIR, this.getMetaData().getName(), directory.getPath()});
		}
		
    //get list of files (not subdirectories) in the specified directory
    mFiles = new ArrayList();
    File[] files = directory.listFiles();
    for (int i = 0; i < files.length; i++)
    {
      if (!files[i].isDirectory())
      {
        mFiles.add(files[i]);  
      }
    }
  }

  /**
   * @see org.apache.uima.collection.CollectionReader#hasNext()
   */
  public boolean hasNext()
  {
    return mCurrentIndex < mFiles.size();
  }

  /**
   * @see org.apache.uima.collection.CollectionReader#getNext(org.apache.uima.cas.CAS)
   */
  public void getNext(CAS aCAS) throws IOException, CollectionException
  {
  	JCas jcas;
  	try
    {
      jcas = aCAS.getJCas();
    } 
    catch (CASException e)
    {
      throw new CollectionException(e);
    }
  	
  	//open input stream to file
    File file = (File)mFiles.get(mCurrentIndex++);
		FileInputStream fis = new FileInputStream(file);
    try
    { 		
			//if there's a CAS Initializer, call it	
			if (getCasInitializer() != null)
			{
				getCasInitializer().initializeCas(fis, aCAS);	
			}
			else  //No CAS Initiliazer, so read file and set document text ourselves
			{				
				byte[] contents = new byte[(int)file.length() ];
				fis.read( contents );   
				String text;
				if (mEncoding != null)
				{   
					text = new String(contents, mEncoding);
				}
				else
				{ 
					text = new String(contents); 
				}
				//put document in CAS (assume CAS)
				jcas.setDocumentText(text);
			}
    }		
		finally
		{
			if (fis != null)
				fis.close();
		}  
   
     
    //Also store location of source document in CAS.  This information is critical
    //if CAS Consumers will need to know where the original document contents are located.
    //For example, the Semantic Search CAS Indexer writes this information into the
    //search index that it creates, which allows applications that use the search index to
    //locate the documents that satisfy their semantic queries.   
    SourceDocInfo srcDocInfo = new SourceDocInfo(jcas);
    srcDocInfo.setUri(file.getAbsoluteFile().toURL().toString());
    srcDocInfo.setOffsetInSource(0);
    srcDocInfo.setDocumentSize((int)file.length());
    srcDocInfo.setBegin(0);
    srcDocInfo.setEnd((int)file.length() - 1);
    srcDocInfo.setFileName(file.getName());
    srcDocInfo.addToIndexes();
    //set language if it was explicitly specified as a configuration parameter
    if (mLanguage != null)
    {
      //((DocumentAnnotation)jcas.getDocumentAnnotationFs()).setLanguage(mLanguage);
    	srcDocInfo.setLanguage(mLanguage);
    }
    
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#close()
   */
  public void close() throws IOException
  {
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#getProgress()
   */
  public Progress[] getProgress()
  {
    return new Progress[]{
       new ProgressImpl(mCurrentIndex,mFiles.size(),Progress.ENTITIES)};
  }

  /**
   * Gets the total number of documents that will be returned by this
   * collection reader.  This is not part of the general collection reader
   * interface.
   * 
   * @return the number of documents in the collection
   */
  public int getNumberOfDocuments()
  {
    return mFiles.size();
  }


}
