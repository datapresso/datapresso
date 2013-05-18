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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.uima.UIMAFramework;
import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionProcessingEngine;
import org.apache.uima.collection.EntityProcessStatus;
import org.apache.uima.collection.StatusCallbackListener;
import org.apache.uima.collection.metadata.CpeDescription;
import org.apache.uima.util.XMLInputSource;

/**
 * Main Class that runs a Collection Processing Engine (CPE).  This class 
 * reads a CPE Descriptor as a command-line argument and instantiates the CPE.  It also 
 * registers a callback listener with the CPE, which will print progress and statistics to System.out.
 * 
 * 
 */
public class EdgarProcessor extends Thread
{
  /**
   * The CPE instance.
   */
  private CollectionProcessingEngine mCPE;

  /**
   * Start time of the processing - used to compute elapsed time.
   */
  private long mStartTime;

  /** 
   * Constructor for the class. 
   * @param args command line arguments into the program - see class
   *    description
   */
  public EdgarProcessor(String args[]) throws Exception
  {
    mStartTime = System.currentTimeMillis();

    //check command line args      	
    if (args.length < 1)
    {
      printUsageMessage();
      System.exit(1);
    }

    //parse CPE descriptor
    System.out.println("Parsing CPE Descriptor");
    CpeDescription cpeDesc = UIMAFramework.getXMLParser().parseCpeDescription(
        new XMLInputSource(args[0]));
    //instantiate CPE
    System.out.println("Instantiating CPE");
    mCPE = UIMAFramework.produceCollectionProcessingEngine(cpeDesc);

    //Create and register a Status Callback Listener
    mCPE.addStatusCallbackListener(new StatusCallbackListenerImpl());

    //Start Processing
    System.out.println("Running CPE");
    mCPE.process();
    
    //Allow user to abort by pressing Enter
    System.out.println("To abort processing, type \"abort\" and press enter.");
    while(true)
    {
      String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
      if ("abort".equals(line) && mCPE.isProcessing())
      {
        System.out.println("Aborting...");
        mCPE.stop();
        break;
      }
    }
  }

  /**
   * 
   */
  private static void printUsageMessage()
  {
    System.out.println(" Arguments to the program are as follows : \n"
        + "args[0] : path to CPE descriptor file");
  }

  /**
   * main class.
   * @param args Command line arguments - see class description
   */
  public static void main(String[] args) throws Exception
  {
    new EdgarProcessor(args);
  }

  /**
   * Callback Listener.  Receives event notifications from CPE.
   * 
   * 
   */
  class StatusCallbackListenerImpl implements StatusCallbackListener
  {
    int entityCount = 0;

    long size = 0;

    /** 
     * Called when the initialization is completed.
     * @see com.ibm.uima.collection.processing.StatusCallbackListener#initializationComplete()
     **/
    public void initializationComplete()
    {
      System.out.println("CPM Initialization Complete");
    }

    /**
     * Called when the batchProcessing is completed. 
     * @see com.ibm.uima.collection.processing.StatusCallbackListener#batchProcessComplete()
     * 
     **/
    public void batchProcessComplete()
    {
      System.out.print("Completed " + entityCount + " documents");
      if (size > 0)
      {
        System.out.print("; " + size + " characters");
      }
      System.out.println();
      long elapsedTime = System.currentTimeMillis() - mStartTime;
      System.out.println("Time Elapsed : " + elapsedTime + " ms ");
    }

    /** 
     * Called when the collection processing is completed.
     * @see com.ibm.uima.collection.processing.StatusCallbackListener#collectionProcessComplete()
     **/
    public void collectionProcessComplete()
    {
      System.out.print("Completed " + entityCount + " documents");
      if (size > 0)
      {
        System.out.print("; " + size + " characters");
      }
      System.out.println();
      long elapsedTime = System.currentTimeMillis() - mStartTime;
      System.out.println("Time Elapsed : " + elapsedTime + " ms ");
      System.out.println("\n\n ------------------ PERFORMANCE REPORT ------------------\n");
      System.out.println(mCPE.getPerformanceReport().toString());
      //stop the JVM.  Otherwise main thread will still be blocked waiting for
      //user to press Enter.
      System.exit(1);
    }

    /** 
     * Called when the CPM is paused.
     * @see com.ibm.uima.collection.processing.StatusCallbackListener#paused()
     **/
    public void paused()
    {
      System.out.println("Paused");
    }

    /** 
     * Called when the CPM is resumed after a pause.
     * @see com.ibm.uima.collection.processing.StatusCallbackListener#resumed()
     **/
    public void resumed()
    {
      System.out.println("Resumed");
    }

    /**
     * Called when the CPM is stopped abruptly due to errors.
     * @see com.ibm.uima.collection.processing.StatusCallbackListener#aborted()
     **/
    public void aborted()
    {
      System.out.println("Aborted");
      //stop the JVM.  Otherwise main thread will still be blocked waiting for
      //user to press Enter.
      System.exit(1);      
    }

    /**
     * Called when the processing of a Document is completed. 
     * <br>The process status can be looked at and corresponding 
     * actions taken.
     * 
     * @param aCas CAS corresponding to the completed processing
     * @param aStatus EntityProcessStatus that holds the status of all 
     * 	the events for aEntity
     */
    public void entityProcessComplete(CAS aCas, EntityProcessStatus aStatus)
    {
      if (aStatus.isException())
      {
        List exceptions = aStatus.getExceptions();
        for (int i = 0; i < exceptions.size(); i++)
        {
          ((Throwable) exceptions.get(i)).printStackTrace();
        }
        return;
      }
      entityCount++;
      String docText = aCas.getCurrentView().getDocumentText();
      if (docText != null)
      {
        size += docText.length();
      }
    }
  }

}

