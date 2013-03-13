
/* First created by JCasGen Tue Aug 26 10:18:00 EDT 2008 */
package com.dp.dhs.uima.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.DocumentAnnotation_Type;

/** Stores detailed information about the original source document from which the current CAS was initialized. All information (like size) refers to the source document and not to the document in the CAS which may be converted and filtered by a CAS Initializer. For example this information will be written to the Semantic Search index so that the original document contents can be retrieved by queries.
 * Updated by JCasGen Sat Jun 20 14:34:58 EDT 2009
 * @generated */
public class SourceDocInfo_Type extends DocumentAnnotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SourceDocInfo_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SourceDocInfo_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SourceDocInfo(addr, SourceDocInfo_Type.this);
  			   SourceDocInfo_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SourceDocInfo(addr, SourceDocInfo_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = SourceDocInfo.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.dp.edgar.uima.type.SourceDocInfo");
 
  /** @generated */
  final Feature casFeat_uri;
  /** @generated */
  final int     casFeatCode_uri;
  /** @generated */ 
  public String getUri(int addr) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uri);
  }
  /** @generated */    
  public void setUri(int addr, String v) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setStringValue(addr, casFeatCode_uri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_offsetInSource;
  /** @generated */
  final int     casFeatCode_offsetInSource;
  /** @generated */ 
  public int getOffsetInSource(int addr) {
        if (featOkTst && casFeat_offsetInSource == null)
      jcas.throwFeatMissing("offsetInSource", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getIntValue(addr, casFeatCode_offsetInSource);
  }
  /** @generated */    
  public void setOffsetInSource(int addr, int v) {
        if (featOkTst && casFeat_offsetInSource == null)
      jcas.throwFeatMissing("offsetInSource", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setIntValue(addr, casFeatCode_offsetInSource, v);}
    
  
 
  /** @generated */
  final Feature casFeat_documentSize;
  /** @generated */
  final int     casFeatCode_documentSize;
  /** @generated */ 
  public int getDocumentSize(int addr) {
        if (featOkTst && casFeat_documentSize == null)
      jcas.throwFeatMissing("documentSize", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getIntValue(addr, casFeatCode_documentSize);
  }
  /** @generated */    
  public void setDocumentSize(int addr, int v) {
        if (featOkTst && casFeat_documentSize == null)
      jcas.throwFeatMissing("documentSize", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setIntValue(addr, casFeatCode_documentSize, v);}
    
  
 
  /** @generated */
  final Feature casFeat_filingType;
  /** @generated */
  final int     casFeatCode_filingType;
  /** @generated */ 
  public int getFilingType(int addr) {
        if (featOkTst && casFeat_filingType == null)
      jcas.throwFeatMissing("filingType", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getIntValue(addr, casFeatCode_filingType);
  }
  /** @generated */    
  public void setFilingType(int addr, int v) {
        if (featOkTst && casFeat_filingType == null)
      jcas.throwFeatMissing("filingType", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setIntValue(addr, casFeatCode_filingType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_documentType;
  /** @generated */
  final int     casFeatCode_documentType;
  /** @generated */ 
  public int getDocumentType(int addr) {
        if (featOkTst && casFeat_documentType == null)
      jcas.throwFeatMissing("documentType", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getIntValue(addr, casFeatCode_documentType);
  }
  /** @generated */    
  public void setDocumentType(int addr, int v) {
        if (featOkTst && casFeat_documentType == null)
      jcas.throwFeatMissing("documentType", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setIntValue(addr, casFeatCode_documentType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timeStamp;
  /** @generated */
  final int     casFeatCode_timeStamp;
  /** @generated */ 
  public String getTimeStamp(int addr) {
        if (featOkTst && casFeat_timeStamp == null)
      jcas.throwFeatMissing("timeStamp", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timeStamp);
  }
  /** @generated */    
  public void setTimeStamp(int addr, String v) {
        if (featOkTst && casFeat_timeStamp == null)
      jcas.throwFeatMissing("timeStamp", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setStringValue(addr, casFeatCode_timeStamp, v);}
    
  
 
  /** @generated */
  final Feature casFeat_fileName;
  /** @generated */
  final int     casFeatCode_fileName;
  /** @generated */ 
  public String getFileName(int addr) {
        if (featOkTst && casFeat_fileName == null)
      jcas.throwFeatMissing("fileName", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getStringValue(addr, casFeatCode_fileName);
  }
  /** @generated */    
  public void setFileName(int addr, String v) {
        if (featOkTst && casFeat_fileName == null)
      jcas.throwFeatMissing("fileName", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setStringValue(addr, casFeatCode_fileName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sentenceCount;
  /** @generated */
  final int     casFeatCode_sentenceCount;
  /** @generated */ 
  public int getSentenceCount(int addr) {
        if (featOkTst && casFeat_sentenceCount == null)
      jcas.throwFeatMissing("sentenceCount", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sentenceCount);
  }
  /** @generated */    
  public void setSentenceCount(int addr, int v) {
        if (featOkTst && casFeat_sentenceCount == null)
      jcas.throwFeatMissing("sentenceCount", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setIntValue(addr, casFeatCode_sentenceCount, v);}
    
  
 
  /** @generated */
  final Feature casFeat_tokenCount;
  /** @generated */
  final int     casFeatCode_tokenCount;
  /** @generated */ 
  public int getTokenCount(int addr) {
        if (featOkTst && casFeat_tokenCount == null)
      jcas.throwFeatMissing("tokenCount", "com.dp.edgar.uima.type.SourceDocInfo");
    return ll_cas.ll_getIntValue(addr, casFeatCode_tokenCount);
  }
  /** @generated */    
  public void setTokenCount(int addr, int v) {
        if (featOkTst && casFeat_tokenCount == null)
      jcas.throwFeatMissing("tokenCount", "com.dp.edgar.uima.type.SourceDocInfo");
    ll_cas.ll_setIntValue(addr, casFeatCode_tokenCount, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SourceDocInfo_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_uri = jcas.getRequiredFeatureDE(casType, "uri", "uima.cas.String", featOkTst);
    casFeatCode_uri  = (null == casFeat_uri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uri).getCode();

 
    casFeat_offsetInSource = jcas.getRequiredFeatureDE(casType, "offsetInSource", "uima.cas.Integer", featOkTst);
    casFeatCode_offsetInSource  = (null == casFeat_offsetInSource) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_offsetInSource).getCode();

 
    casFeat_documentSize = jcas.getRequiredFeatureDE(casType, "documentSize", "uima.cas.Integer", featOkTst);
    casFeatCode_documentSize  = (null == casFeat_documentSize) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_documentSize).getCode();

 
    casFeat_filingType = jcas.getRequiredFeatureDE(casType, "filingType", "uima.cas.Integer", featOkTst);
    casFeatCode_filingType  = (null == casFeat_filingType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_filingType).getCode();

 
    casFeat_documentType = jcas.getRequiredFeatureDE(casType, "documentType", "uima.cas.Integer", featOkTst);
    casFeatCode_documentType  = (null == casFeat_documentType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_documentType).getCode();

 
    casFeat_timeStamp = jcas.getRequiredFeatureDE(casType, "timeStamp", "uima.cas.String", featOkTst);
    casFeatCode_timeStamp  = (null == casFeat_timeStamp) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timeStamp).getCode();

 
    casFeat_fileName = jcas.getRequiredFeatureDE(casType, "fileName", "uima.cas.String", featOkTst);
    casFeatCode_fileName  = (null == casFeat_fileName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_fileName).getCode();

 
    casFeat_sentenceCount = jcas.getRequiredFeatureDE(casType, "sentenceCount", "uima.cas.Integer", featOkTst);
    casFeatCode_sentenceCount  = (null == casFeat_sentenceCount) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceCount).getCode();

 
    casFeat_tokenCount = jcas.getRequiredFeatureDE(casType, "tokenCount", "uima.cas.Integer", featOkTst);
    casFeatCode_tokenCount  = (null == casFeat_tokenCount) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenCount).getCode();

  }
}



    