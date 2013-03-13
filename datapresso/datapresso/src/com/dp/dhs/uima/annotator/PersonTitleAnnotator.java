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
package com.dp.dhs.uima.annotator;

import java.util.Arrays;

import org.apache.uima.analysis_engine.ResultSpecification;
import org.apache.uima.analysis_engine.annotator.AnnotatorConfigurationException;
import org.apache.uima.analysis_engine.annotator.AnnotatorContext;
import org.apache.uima.analysis_engine.annotator.AnnotatorContextException;
import org.apache.uima.analysis_engine.annotator.AnnotatorInitializationException;
import org.apache.uima.analysis_engine.annotator.AnnotatorProcessException;
import org.apache.uima.analysis_engine.annotator.Annotator_ImplBase;
import org.apache.uima.analysis_engine.annotator.TextAnnotator;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.CAS;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;

/**
 * An example annotator that discovers Person Titles in text and classifies them
 * into three categories - Civilian (e.g. Mr.,Ms.), Military (e.g. Lt. Col.) , 
 * and Government (e.g. Gov., Sen.).  The titles are detected using simple
 * string matching.  The strings that are matched are determined by the
 * <code>CivilianTitles</code>, <code>MilitaryTitles</code>, and
 * <code>GovernmentTitles</code> configuration parameters.
 * <p>
 * If the <code>ContainingAnnotationType</code> parameter is specified, this
 * annotator will only look for titles within existing annotations of that type.
 * This feature can be used, for example, to only match person titles within
 * existing Person Name annotations, discovered by some annotator that has
 * run previously.
 * 
 * 
 */
public class PersonTitleAnnotator extends Annotator_ImplBase 
    implements TextAnnotator
{
  /**
   * The Type of Annotation that we will be creating when we find a match.
   */
  private Type mPersonTitleType;

  /**
   * The Annotation Type within which we will search for Person Titles 
   * (optional).
   */
  private Type mContainingType;

  /**
   * The Feature representing the kind of PersonTitle - civilian,
   * military, or government.
   */
  private Feature mPersonTitleKindFeature;
  

  /**
   * The list of civilian titles, read from the CivilianTitles
   * configuration parameter.
   */
  private String[] mCivilianTitles;
  

  /**
   * The list of military titles, read from the MilitaryTitles
   * configuration parameter.
   */
  private String[] mMilitaryTitles;
  

  /**
   * The list of government titles, read from the GovernmentTitles
   * configuration parameter.
   */
  private String[] mGovernmentTitles;

  /**
   * The list of company titles, read from the CompanyTitles
   * configuration parameter.
   */
  private String[] mCompanyTitles;
  
  
  /**
   * Performs initialization logic.  This implementation just reads values
   * for the configuration parameters.
   * 
   * @see org.apache.uima.analysis_engine.annotator.BaseAnnotator#initialize(AnnotatorContext)
   */
  public void initialize(AnnotatorContext aContext)
    throws AnnotatorConfigurationException, AnnotatorInitializationException
  {
    super.initialize(aContext);
    
    try
    {
      //read configuration parameter values
      mCivilianTitles = (String[])
        getContext().getConfigParameterValue("CivilianTitles");
      mMilitaryTitles = (String[])
        getContext().getConfigParameterValue("MilitaryTitles");
      mGovernmentTitles = (String[])
        getContext().getConfigParameterValue("GovernmentTitles");
      
      mCompanyTitles = (String[])
      getContext().getConfigParameterValue("CompanyTitles");
      
        
      //write log messages
      Logger logger = getContext().getLogger();
      logger.log(Level.CONFIG,"PersonTitleAnnotator initialized");
      logger.log(Level.CONFIG,"CivilianTitles = " + Arrays.asList(mCivilianTitles));      
      logger.log(Level.CONFIG,"MilitaryTitles = " + Arrays.asList(mMilitaryTitles));      
      logger.log(Level.CONFIG,"GovernmentTitles = " + Arrays.asList(mGovernmentTitles));   
      logger.log(Level.CONFIG,"CompanyTitles = " + Arrays.asList(mCompanyTitles));    
    }
    catch(AnnotatorContextException e)
    {
      throw new AnnotatorInitializationException(e);    
    }    
  }
  
  /**
   * Called whenever the CAS type system changes.  Acquires references to
   * Types and Features.
   * 
   * @see org.apache.uima.analysis_engine.annotator.BaseAnnotator#typeSystemInit(TypeSystem)
   */
  public void typeSystemInit(TypeSystem aTypeSystem)
    throws AnnotatorConfigurationException, AnnotatorInitializationException
  {
    try
    {
      //Get a reference to the "PersonTitle" Type
      mPersonTitleType = aTypeSystem.getType("com.dp.edgar.uima.type.PersonTitle");
      if (mPersonTitleType == null)
      {
        throw new AnnotatorInitializationException(
          AnnotatorInitializationException.TYPE_NOT_FOUND,
          new Object[]{getClass().getName(), "com.dp.edgar.uima.type.PersonTitle"});
      }    
    
      // Get a reference to the "Kind" Feature
      mPersonTitleKindFeature =  mPersonTitleType.getFeatureByBaseName("Kind");
      if (mPersonTitleKindFeature == null)
      {
        throw new AnnotatorInitializationException(
          AnnotatorInitializationException.FEATURE_NOT_FOUND,
          new Object[]{getClass().getName(), "com.dp.edgar.uima.type.PersonTitle:Kind"});
      }    

      //Get the value for the "ContainingType" parameter if there is one
      String containingTypeName = (String)
        getContext().getConfigParameterValue("ContainingAnnotationType");
      if (containingTypeName != null)
      {
        mContainingType = aTypeSystem.getType(containingTypeName);
        if (mContainingType == null)
        {
          throw new AnnotatorInitializationException(
            AnnotatorInitializationException.TYPE_NOT_FOUND,
            new Object[]{getClass().getName(), containingTypeName});
        }            
      }
    }
    catch(AnnotatorContextException e)
    {
      throw new AnnotatorInitializationException(e);     
    }
  }

  /**
   * Annotates a document.  This annotator searches for person titles using
   * simple string matching.
   * 
   * @param aTCAS CAS containing document text and previously discovered
   *    annotations, and to which new annotations are to be written.
   * @param aResultSpec  A list of output types and features that this annotator
   *    should produce.
   * 
   * @see org.apache.uima.analysis_engine.annotator.TextAnnotator#process(CAS, ResultSpecification)
   */
  public void process(CAS aTCAS, ResultSpecification aResultSpec)
    throws AnnotatorProcessException
  {
    try
    {      
      //If the ResultSpec doesn't include the PersonTitle type, we have
      //nothing to do.
      if (!aResultSpec.containsType("com.dp.edgar.uima.type.PersonTitle"))
      {
         return;
      }
          
      if (mContainingType == null)
      {
        //Search the whole document for PersonTitle annotations
        String text = aTCAS.getDocumentText();
        annotateRange(aTCAS, text, 0, aResultSpec);
      }
      else
      {
        //Search only within annotations of type mContainingType

        // Get an iterator over the annotations of type mContainingType.
        FSIterator it = aTCAS.getAnnotationIndex(mContainingType).iterator();
        // Loop over the iterator.
        while (it.isValid()) 
        {
          // Get the next annotation from the iterator
          AnnotationFS annot = (AnnotationFS) it.get();
          // Get text covered by this annotation
          String coveredText = annot.getCoveredText();
          // Get begin position of this annotation
          int annotBegin = annot.getBegin();
          //search for matches within this
          annotateRange(aTCAS, coveredText, annotBegin, aResultSpec);        
          // Advance the iterator.
          it.moveToNext();
        }
      }  
    }
    catch(Exception e)
    {
      throw new AnnotatorProcessException(e);
    }
  }  


  /**
   * A utility method that searches a part of the document for Person Titles.
   * 
   * @param aTCAS the CAS in which to create new annotations
   * @param aText the substring of the document text within which to search
   * @param aBeginPos the position of this substring relative to the start
   *   of the document
   * @param aResultSpec the ResultSpecification, indicating what annotation
   *   types and features we're supposed to produce
   */
  protected void annotateRange(CAS aTCAS, String aText, int aBeginPos, 
    ResultSpecification aResultSpec)
    throws AnnotatorContextException
  {    
    //Search for each of the three types of titles
    annotateRange(aTCAS, aText, aBeginPos, aResultSpec, "Civilian", mCivilianTitles);
    annotateRange(aTCAS, aText, aBeginPos, aResultSpec, "Military", mMilitaryTitles);
    annotateRange(aTCAS, aText, aBeginPos, aResultSpec, "Government", mGovernmentTitles);
    annotateRange(aTCAS, aText, aBeginPos, aResultSpec, "Company", mCompanyTitles);    
  }
  
  /**
   * A utility method that searches a part of the document for a specific
   * kind of Person Title.
   * 
   * @param aTCAS the CAS in which to create new annotations
   * @param aText the substring of the document text within which to search
   * @param aBeginPos the position of this substring relative to the start
   *   of the document
   * @param aResultSpec the ResultSpecification, indicating what annotation
   *   types and features we're supposed to produce
   * @param aTitleType the type of title to look for.  This becomes the value
   *   of the <code>Kind</code> feature.
   * @param aTitles the exact strings to look for in the document
   *
   */
  protected void annotateRange(CAS aTCAS, String aText, int aBeginPos, 
    ResultSpecification aResultSpec, String aTitleType, String[] aTitles)
    throws AnnotatorContextException
  {
    // Loop over the matchStrings.
    for (int i = 0; i < aTitles.length; i++) 
    {
      //logger.log("Looking for string: " + matchStrings[i]);
      // Find a first match, if it exists.
      int start = aText.indexOf(aTitles[i]);
      // Keep going while there are matches in the text.
      while (start >= 0) {
        // Set the end position (start + length of string).
        int end = start + aTitles[i].length();
        //Compute absolute position of annotation in document
        int absStart = aBeginPos + start;
        int absEnd = aBeginPos + end;
        // Write log message
        getContext().getLogger().log(Level.FINER,
            "Found \"" + aTitles[i] + "\" at (" + absStart + "," + absEnd + ")");
        // Create a new annotation for the most recently discovered match.
        createAnnotation(aTCAS, absStart, absEnd, aTitleType, aResultSpec);
        // Look for the next match, starting after the previous match.
        start = aText.indexOf(aTitles[i], end);
      }
    }
  }
  

  /**
   * Creates an PersonTitle annotation in the CAS.
   * 
   * @param aTCAS the CAS in which to create the annotation
   * @param aBeginPos the begin position of the annotation relative to the start
   *   of the document
   * @param aEndPos the end position of the annotation relative to the start
   *   of the document.  (Note that, as in the Java string functions, the
   *   end position is one past the last character in the annotation, so
   *   that (end - begin) = length.
   * @param aResultSpec the ResultSpecification, indicating what annotation
   *   types and features we're supposed to produce
   * @param aTitleType the type of person title.  This becomes the value
   *   of the <code>Kind</code> feature.
   */
  protected void createAnnotation(CAS aTCAS, int aBeginPos, int aEndPos, 
     String aTitleType,
     ResultSpecification aResultSpec)
  {
    AnnotationFS title = aTCAS.createAnnotation(mPersonTitleType, 
        aBeginPos, aEndPos);
    //Set the "kind" feature if it's part of the ResultSpec
    if (aResultSpec.containsFeature("com.dp.edgar.uima.type.PersonTitle:Kind"))
    {            
      title.setStringValue(mPersonTitleKindFeature,aTitleType);  
    }   
    // Add the annotation to the index.
    aTCAS.getIndexRepository().addFS(title);
  }
  


}
