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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.HashMap; 
import java.util.HashSet;

import com.dp.dhs.uima.type.SourceDocInfo;

import org.apache.uima.analysis_engine.ResultSpecification;
import org.apache.uima.analysis_engine.annotator.AnnotatorConfigurationException;
import org.apache.uima.analysis_engine.annotator.AnnotatorContext;
import org.apache.uima.analysis_engine.annotator.AnnotatorContextException;
import org.apache.uima.analysis_engine.annotator.AnnotatorInitializationException;
import org.apache.uima.analysis_engine.annotator.AnnotatorProcessException;
import org.apache.uima.analysis_engine.annotator.Annotator_ImplBase;
import org.apache.uima.analysis_engine.annotator.TextAnnotator;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.FSTypeConstraint;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.CAS;
import org.apache.uima.util.Level;


/**
 * Annotator that find substrings of the input document that match
 * regular expressions.
 * <p>
 * There are two ways to specify the regular expressions - via configuration
 * parameters or via an external resource file.
 * <p>
 * This annotator takes the following optional configuration parameters:
 * <ul>
 * <li><code>Patterns</code> - array of Strings indicating regular expressions 
 *     to match.  The pattern language is described at
 *     <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/util/regex/Pattern.html"> 
 *     http://java.sun.com/j2se/1.4.2/docs/api/java/util/regex/Pattern.html</a>)
 * </li>
 * <li><code>TypeNames</code> - array of Strings indicating names of Types to 
 *     be created from the patterns.
 * </li>
 * <li><code>ContainingAnnotationTypes</code> - an array of input annotation
 *     types.  This annotator will only produce new annotations that are
 *     contained within existing annotaions of these types.  
 *     (This is optional.)
 * </li>
 * <li><code>AnnotateEntireContainedAnnotation</code> - When the ContainingAnnoationTypes 
 * parameter is specified, a value of true for this parameter will cause the entire 
 * containing annotation to be used as the span of the new annotation, rather than just 
 * the span of the regular expression match.  This can be used to "classify" previously created 
 * annotations according to whether or not they contain text matching a regular expression.
 * </li>
 * </ul>
 * <p>
 * The indices of the <code>Patterns</code> and <code>TypeNames</code> arrays 
 * correspond, so that a substring that matches <code>Patterns[i]</code> will 
 * result in an annotation of type <code>TypeNames[i]</code>.  If
 * <code>PatternFiles</code> is specified instead, ,matches on all patterns in 
 * the file <code>PatternFiles[i]</code> will result in annotations of type
 * <code>TypeNames[i]</code>.
 * <p>
 * It is also possible to provide an external resource file that declares
 * the annotation type names and the regular expressions to match.  The
 * annotator will look for this file under the resource key "PatternFile".
 * The file format is as follows:
 * <ul>
 *   <li>Lines starting with # or whitepsace are ignored</li>
 *   <li>Lines starting with % indicate an annotation type</li>
 *   <li>All other lines are regular expressions, using the same syntax
 *       described for the <code>Patterns</code> configuration parameter.</li>
 * </ul>
 * If a regular expression is matched, it will be annotated with the last 
 * annotation type declared (the nearest preceding line starting with %). 
 *   
 * 
 */
public class EdgarRegExAnnotator extends Annotator_ImplBase implements TextAnnotator
{    
  public static final String MESSAGE_DIGEST =
     "com.dp.edgar.service.EdgarRegExAnnotator_Messages";
  
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
      String[] patternStrings = (String[])
         getContext().getConfigParameterValue("Patterns");
      String[] typeNames =(String[])
         getContext().getConfigParameterValue("TypeNames");
      mContainingAnnotationTypeNames = (String[])
          getContext().getConfigParameterValue("ContainingAnnotationTypes");
      if (mContainingAnnotationTypeNames != null &&
          mContainingAnnotationTypeNames.length > 0)
      {
        mAnnotateEntireContainingAnnotation = (Boolean)
          getContext().getConfigParameterValue("AnnotateEntireContainingAnnotation");
      }
      else
      {
      	mAnnotateEntireContainingAnnotation = Boolean.FALSE;    
      }
                    
      //create an ArrayList of type names and an ArrayList of pattern arrays,
      //where the indexes of the two lists corespond so that the patterns
      //at patternArray[i] correspond to the annotation type at
      //mTypeNames[i].
      mTypeNames = new ArrayList();
      ArrayList patternArray = new ArrayList();
      mTypeMap = new HashMap();
      
      if (patternStrings != null)
      {
        if (typeNames == null || typeNames.length != patternStrings.length)
        {
          //throw exception - error message in external message digest
          throw new AnnotatorConfigurationException(
            MESSAGE_DIGEST, "type_pattern_array_length_mismatch",
            new Object[0]);
        }
        mTypeNames.addAll(Arrays.asList(typeNames));                  

        for (int i = 0; i < patternStrings.length; i++)
        {
          patternArray.add(new String[]{patternStrings[i]});
        }        
      }
      
      //if PatternFile resource exists, parse it and add to patternArray
      InputStream in = getContext().getResourceAsStream("PatternFile");
      if (in != null)
      {
        try
        {
          ArrayList patternsForCurrentType = new ArrayList();
          boolean foundFirstType = false;
          //get buffered reader
          BufferedReader reader = 
            new BufferedReader(new InputStreamReader(in));
          
          //read lines from file          
          String line = reader.readLine();
          String currentType = null;
          while (line != null)
          {
            if (!line.startsWith("#") && line.length() > 0 &&
                !Character.isWhitespace(line.charAt(0)))
            {
              //line is not a comment
              if (line.startsWith("%")) //annotation type name
              {
              	currentType = line.substring(1);
              	mNumberOfTypes += 1;
              }
              else if(line.startsWith("@"))//annotation feature name
              {
              	//add the type-feature mapping using the full feature name
              	mTypeMap.put(currentType + ":" + line.substring(1),currentType);
                //add pattern array for previous type (if any) to list
                if (foundFirstType)
                {
                  String[] pats = new String[patternsForCurrentType.size()];
                  patternsForCurrentType.toArray(pats);
                  patternArray.add(pats);
                  patternsForCurrentType.clear();
                }
                //add new type name to mTypeNames list
                mTypeNames.add(currentType + ":" + line.substring(1));
                foundFirstType = true;
              }
              else //treat as regular expression
              {
                patternsForCurrentType.add(line);
              }       
            }
            line = reader.readLine();
          }
          //add last group of pattersn to patternArray
          String[] pats = new String[patternsForCurrentType.size()];
          patternsForCurrentType.toArray(pats);
          patternArray.add(pats);
        }  
        finally
        {
          if (in != null)
          {
            in.close();
          }
        }                           
      }
            
      //make sure there is at least one pattern
      if (patternArray.isEmpty())
      {
        throw new AnnotatorConfigurationException(
          AnnotatorConfigurationException.ONE_PARAM_REQUIRED,
          new Object[]{"Patterns, Pattern File"});
      }
            
      //compile regular expression patterns
      mPatterns = new Pattern[patternArray.size()][];
	      for (int i = 0; i < patternArray.size(); i++)
	      {
	        String[] pats = (String[])patternArray.get(i);
	        mPatterns[i] = new Pattern[pats.length];
	        for(int j = 0; j < mPatterns[i].length; j++)
	        {
	          try
	          {          
	            mPatterns[i][j] = Pattern.compile(pats[j]);
	            //make sure no pattern matches the empty string - as this
	            //would lead to infinite loops during processing
	            if (mPatterns[i][j].matcher("").matches())
	            {
	              throw new AnnotatorConfigurationException(
	                  MESSAGE_DIGEST,"regex_matches_empty_string",
	                  new Object[]{pats[j]});             
	            }
	          }
	          catch(PatternSyntaxException e)
	          {
	            throw new AnnotatorConfigurationException(
	              MESSAGE_DIGEST,"regex_syntax_error",
	              new Object[]{pats[j]}, e);  
	          }
	        }
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
  } 

  /**
   * Acquires references to CAS Type and Feature objects that are later used
   * during the {@link #process(CAS,ResultSpecification)} method.
   * 
   * @see org.apache.uima.analysis_engine.annotator.TextAnnotator#typeSystemInit()
   */
  public void typeSystemInit(TypeSystem aTypeSystem)
    throws AnnotatorInitializationException
  {
    //get references to annotation types we will create
    mCASTypes = new HashMap();
    Type t = null;
    mCASFeatures = new Feature[mTypeNames.size()];
    Collection c = mTypeMap.values();
    HashSet hs = new HashSet(c);
    if (mNumberOfTypes != hs.size())
	{
    	//TODO: need to throw an exception here
    	System.out.println("Something wrong in getting the number of types!");
	}
    //for (int i = 0; i < mNumberOfTypes; i++)
    int i = 0;
    int j = 0;
  
    for (Iterator it= hs.iterator();it.hasNext();i++,j=0)
    {
      //need to get the real type via the Type-Feature map	
      //String curTypeName = (String)mTypeMap.get(mTypeNames.get(i));
      String curTypeName = (String)it.next();
      t = aTypeSystem.getType(curTypeName);
      mCASTypes.put(curTypeName,t);
      if ( t == null)
      {
        throw new AnnotatorInitializationException(
        AnnotatorInitializationException.TYPE_NOT_FOUND,
        new Object[]{this.getClass().getName(), curTypeName});
      }    
      //now try to get features
      /*
      for (Iterator it1 = mCASTypes[i].getAppropriateFeatures().iterator(); it1.hasNext();j++)
      {
	      String curFeatureName = (String)mTypeNames.get(i);
	      mCASFeatures[j] = (Feature)(it.next());
	      if (mCASFeatures[j] == null)
	      {
	        throw new AnnotatorInitializationException(
	        AnnotatorInitializationException.FEATURE_NOT_FOUND,
	        new Object[]{this.getClass().getName(), curFeatureName});
	      }
       }*/
    }
    for (j=0; j< mTypeNames.size();j++)
    {
	      String currFeatureName = (String)mTypeNames.get(j);
	      String currTypeName = (String)mTypeMap.get(currFeatureName);
	      //String fullFeatureName = curTypeName + ":" + curFeatureName;
	      //feature's fullname is typeName:featureName
	      mCASFeatures[j] = (Feature)aTypeSystem.getFeatureByFullName(currFeatureName);
	      if (mCASFeatures[j] == null)
	      {
	        throw new AnnotatorInitializationException(
	        AnnotatorInitializationException.FEATURE_NOT_FOUND,
	        new Object[]{this.getClass().getName(), currFeatureName});
	      }
     }
    
    //get references to Containing Annotation Types
    if (mContainingAnnotationTypeNames == null)
    {
      mContainingAnnotationTypes = null;
    }
    else
    {
      mContainingAnnotationTypes = 
          new Type[mContainingAnnotationTypeNames.length];
      for ( i = 0; i < mContainingAnnotationTypes.length; i++)
      {
        mContainingAnnotationTypes[i] =
          aTypeSystem.getType(mContainingAnnotationTypeNames[i]);
        if (mContainingAnnotationTypes[i] == null)
        {
          throw new AnnotatorInitializationException(
            AnnotatorInitializationException.TYPE_NOT_FOUND,
            new Object[]{getClass().getName(),
                         mContainingAnnotationTypeNames[i]});
        }
      }
    }        
  }
  
  
  /**
   * Invokes this annotator's analysis logic.  This annotator uses the
   * java regular expression package to find annotations using the regular
   * expressions defined by its configuration parameters.
   * 
   * @param aTCAS the CAS to process
   * @param aResultSpec  A list of outputs that this annotator should produce.
   * 
   * @throws AnnotatorProcessException  if a failure occurs during processing.     
   * 
   * @see org.apache.uima.analysis_engine.annotator.TextAnnotator#process(CAS, ResultSpecification)
   */
  public void process(CAS aTCAS, ResultSpecification aResultSpec) 
    throws AnnotatorProcessException
  {
    try
    {
        String docText = aTCAS.getDocumentText();
		/*SourceDocInfo srcDocInfo = null;
		// Get the DocumentAnnotation from the CAS
		if (jCas.getJFSIndexRepository().getAnnotationIndex(SourceDocInfo.type).iterator().hasNext())
		{
			 srcDocInfo = (SourceDocInfo)jCas.getJFSIndexRepository().getAnnotationIndex(SourceDocInfo.type).iterator().next();
		}*/
 	
      String value = null; //hold the value found
      //Determine which regions of the document we are going to annotate
      int[] rangesToAnnotate = getRangesToAnnotate(aTCAS);
      FeatureStructure fs = null;
      String prevType = null;
      String currType = null;
      int typeAnnotStart = 0;
      int typeAnnotEnd = 0;
      
      //We treat the rangesToAnnotate array as a list of (start,end) offset 
      //pairs.  Iterate through all of these pairs.
      for (int i = 0; i < rangesToAnnotate.length; i += 2)
      {
        int startPos = rangesToAnnotate[i];
        int endPos = rangesToAnnotate[i+1];
        //get the substring of text to be annotated
        String subText = docText.substring(startPos,endPos);       

        //iterate over all annotation features for which we have patterns
        for (int j = 0; j < mCASFeatures.length; j++)
        {
          //see if the ResultSpec contains this feature
          //05/31/09 C.Ding added language code since Apache-UIMA will default the language to x-unspecified if a 
          //valid language code is not provided
        	if (aResultSpec.containsFeature(mCASFeatures[j].getName(),"en-us"))
          {
          	
          	//try to match each pattern that we have for this annotation type
            for (int k = 0; k < mPatterns[j].length; k++)
            {
              int pos = 0;
              int annotStart=0, annotEnd=0;              
              Matcher matcher = mPatterns[j][k].matcher(subText);
              while (pos < subText.length() && matcher.find(pos))
              {
                value = matcher.group(1).trim();
                
              	getContext().getLogger().log(Level.FINER,
                  "RegEx match found: [" + matcher.group() + "]");
                //match found; extract locations of start and end of match
                //(or of entire containing annotation, if that option is on)

                if (mAnnotateEntireContainingAnnotation.booleanValue())
                {
                	annotStart = startPos;
                	annotEnd = endPos;
                }
                else
                {
                	annotStart = startPos + matcher.start(); 
                	annotEnd = startPos + matcher.end();
                }
                pos = annotEnd - startPos;                
      
                //create Annotation in CAS
                currType = (String)mTypeMap.get(mCASFeatures[j].getName());
                if (currType.equals(prevType))
                {
                	//do nothing
              		typeAnnotEnd = annotEnd; //end of the type
                }
                else
                {
                	//so first time a null fs will not be added
                	if (fs != null)
                	{
                		typeAnnotEnd = annotEnd; //end of the type
                		Type aType = (Type)mCASTypes.get(currType);
                		fs.setIntValue(aType.getFeatureByBaseName("begin"),typeAnnotStart);
    	                fs.setIntValue(aType.getFeatureByBaseName("end"),typeAnnotEnd);
                		aTCAS.getIndexRepository().addFS(fs);       
    	                //pos = annotEnd - startPos;
                	}
                	typeAnnotStart = annotStart; //start of the type               	
                	fs = aTCAS.createAnnotation((Type)mCASTypes.get(currType),
	                  annotStart, annotEnd);
                	prevType = currType;
	                //set feature values
                }
                fs.setStringValue((Feature)mCASFeatures[j],value);
                //pos = annotEnd - startPos;
              }  
            }//end k  
          }//end if  
        }//end j
        //add the last feature structure
        if (fs != null)
    	{
    		Type aType = (Type)mCASTypes.get(currType);
    		fs.setIntValue(aType.getFeatureByBaseName("begin"),typeAnnotStart);
            fs.setIntValue(aType.getFeatureByBaseName("end"),typeAnnotEnd);
            aTCAS.getIndexRepository().addFS(fs);       
            //pos = annotEnd - startPos;
    	}
       
      }  
    }
    catch(Exception e)
    {
      throw new AnnotatorProcessException(e);
    }
  }
  

  /**
   * Utility method that determines which subranges of the document text
   * should be annotated by this annotator.  This is done as follows:
   * <ul>
   * <li>If <code>mContainingAnnotationTypes</code> is <code>null</code>, the
   * entire document is eligible for annotation.</li>
   * <li>If <code>mContainingAnnotationTypes</code> is not <code>null</code>, 
   * then each of its elements is expected to be an Annotation Type name.  
   * The CAS is queried for existing annotations of any of these Types,
   * and the only subranges of the document eligible for annotation are
   * those subranges contained within such annotations.</li>
   * </ul>
   * 
   * @param aTCAS CAS currently being processed
   * 
   * @return an array of integers indicating the document subranges eligible
   *    for annotation.  Begin and end positions of the subranges are stored in
   *    successive elements of the array.  For example, elements 0 and 1 are
   *    the start and end of the first subrange; elements 2 and 3 are the
   *    start and end of the second subrange, and so on.
   */
  protected int[] getRangesToAnnotate(CAS aTCAS)
    throws CASException
  {
    if (mContainingAnnotationTypes == null ||
        mContainingAnnotationTypes.length == 0)
    {
      //ContainingAnnotationTypes is not set - the whole document is eligible
      return new int[]{0, aTCAS.getDocumentText().length()};
    }
    else
    {
      //get iterator over all annotations in the CAS
      FSIterator iterator = aTCAS.getAnnotationIndex().iterator();

      //filter the iterator so that only instances of Types in the 
      //mContainingAnnotationTypes array are returned
      FSTypeConstraint constraint =
        aTCAS.getConstraintFactory().createTypeConstraint();
      for (int i = 0; i < mContainingAnnotationTypes.length; i++)
      {
        constraint.add(mContainingAnnotationTypes[i]);       
      }
      iterator = aTCAS.createFilteredIterator(iterator, constraint);
      
      //iterate over annotations and add them to an ArrayList
      List annotationList = new ArrayList();
      while (iterator.isValid())
      {
        annotationList.add(iterator.get());
        iterator.moveToNext();
      }
      
      //For each Annotation in the list, add its start and end 
      //positions to the result array.
      int numRanges = annotationList.size();
      int[] result = new int[numRanges * 2];
      for (int j = 0; j < numRanges; j++)
      {
        AnnotationFS curFS = (AnnotationFS)annotationList.get(j);
        result[j*2] = curFS.getBegin();
        result[j*2 + 1] = curFS.getEnd();
      }  
      return result;
    }  
  }
  
  
  /**
   * The regular expression Patterns to be matched.
   */
  private Pattern[][] mPatterns;
  
  /**
   * The names of the CAS types that this annotator produces from the patterns 
   * in {@link #mPatterns}.
   */
  private ArrayList mTypeNames;
  
  /**
   * The names of the CAS types within which this annotator will search for
   * new annotations.  This may be null, indicating that the entire document
   * will be searched.
   */
  private String[] mContainingAnnotationTypeNames;

  /**
   * The CAS types contains mapping between type Name and type Object
   */
  private HashMap mCASTypes;
  
  /**
   * The CAS features corresponding to a type 
   */
  private Feature[] mCASFeatures;


  /**
   * The CAS types corresponding to {@link #mContainingAnnotationTypeNames}.
   */
  private Type[] mContainingAnnotationTypes;

	/**
	 * Whether to annotate the entire span of the containing annotation when a match is found.
	 */
  private Boolean mAnnotateEntireContainingAnnotation;
  
  /**
   * The hashmap that saves the feature-type mapping
   */
  private HashMap mTypeMap;
  
  /**
   * The number of different Types
   */
  private int mNumberOfTypes = 0;
  
}
