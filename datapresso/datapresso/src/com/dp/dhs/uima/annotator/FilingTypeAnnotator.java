package com.dp.dhs.uima.annotator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dp.dhs.model.Constants;
import com.dp.dhs.uima.type.SourceDocInfo;

import org.apache.uima.analysis_engine.ResultSpecification;
import org.apache.uima.analysis_engine.annotator.AnnotatorProcessException;
import org.apache.uima.analysis_engine.annotator.JTextAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.DocumentAnnotation;

public class FilingTypeAnnotator extends JTextAnnotator_ImplBase {

	//default to DEF-14 A document
	private int filingType = Constants.FILING_TYPE_NOTFOUND;
	private int docType = Constants.DOCUMENT_TYPE_TEXT;
	
	public void process(JCas jCas, ResultSpecification resultSpecification)
			throws AnnotatorProcessException 
	{
		SourceDocInfo srcDocInfo = null;
		// Get the DocumentAnnotation from the CAS
		if (jCas.getJFSIndexRepository().getAnnotationIndex(SourceDocInfo.type).iterator().hasNext())
		{
			 srcDocInfo = (SourceDocInfo)jCas.getJFSIndexRepository().getAnnotationIndex(SourceDocInfo.type).iterator().next();
		}
		else
		{
			DocumentAnnotation docInfo = (DocumentAnnotation) jCas.getDocumentAnnotationFs();
		    srcDocInfo = new SourceDocInfo(jCas);
		}
		String docText = jCas.getDocumentText();
		filingType = getFilingType(docText);
		docType = getDocType (docText);
		srcDocInfo.setFilingType(filingType);
		srcDocInfo.setDocumentType(docType);
		srcDocInfo.addToIndexes();
	}

	//return the document type
	//TODO: currently only supports html and text, need to support .xml etc in the future
	public int getDocType(String docText)
	{
		if (docText.toLowerCase().indexOf("<html>") > 0)
			return Constants.DOCUMENT_TYPE_HTML;
		else
			return Constants.DOCUMENT_TYPE_TEXT;
	}
	
    //return the filing type
	public int getFilingType(String docText) 
	{
        
        Pattern p;
        Matcher m;
        //Hardcoding the form types into a HASH.
        //TODO: This should be stored the configuration parameters in the long run
	     HashMap docTypes = new HashMap(50);
	     docTypes.put(Constants.FILING_TYPE_DEF14A, new Integer(Constants.FILING_TYPE_DEF14A_ID));
	     docTypes.put(Constants.FILING_TYPE_10K, new Integer(Constants.FILING_TYPE_10K_ID));
	     docTypes.put(Constants.FILING_TYPE_NPX, new Integer(Constants.FILING_TYPE_NPX_ID));
	     
            // Regular Expression that matches the form type.
            p = Pattern.compile("CONFORMED SUBMISSION TYPE:\\s+(.*)$",
            Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);
            m = p.matcher(docText);
            if ( m.find()) 
            {
                // Found the form type
                String key = m.group(1);
                if (docTypes.containsKey(key)) 
                    return ((Integer) docTypes.get(key)).intValue();
                else 
                    // document Type was found in document but is not supported by the system.
                    return Constants.FILING_TYPE_INVALID;
            }
        // Pattern match for form type failed.
        return Constants.FILING_TYPE_NOTFOUND ;
    }

	 	
}
