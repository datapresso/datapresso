

/* First created by JCasGen Tue Aug 26 10:18:00 EDT 2008 */
package com.dp.dhs.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.DocumentAnnotation;


/** Stores detailed information about the original source document from which the current CAS was initialized. All information (like size) refers to the source document and not to the document in the CAS which may be converted and filtered by a CAS Initializer. For example this information will be written to the Semantic Search index so that the original document contents can be retrieved by queries.
 * Updated by JCasGen Sat Jun 20 14:34:58 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/SummaryCompensationTable_TAE.xml
 * @generated */
public class SourceDocInfo extends DocumentAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(SourceDocInfo.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected SourceDocInfo() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SourceDocInfo(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SourceDocInfo(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SourceDocInfo(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: uri

  /** getter for uri - gets URI of document. (For example, file:///MyDirectory/myFile.txt for a simple file or http://www.research.ibm.com/UIMA/relatedprojects.htm for content from a web source.)
   * @generated */
  public String getUri() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_uri);}
    
  /** setter for uri - sets URI of document. (For example, file:///MyDirectory/myFile.txt for a simple file or http://www.research.ibm.com/UIMA/relatedprojects.htm for content from a web source.) 
   * @generated */
  public void setUri(String v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setStringValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_uri, v);}    
   
    
  //*--------------*
  //* Feature: offsetInSource

  /** getter for offsetInSource - gets Byte offset of the start of document content within original source file or other input source. Only used if the CAS document was retrieved from an source where one physical source file contained several conceptual documents. Zero otherwise.
   * @generated */
  public int getOffsetInSource() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_offsetInSource == null)
      jcasType.jcas.throwFeatMissing("offsetInSource", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_offsetInSource);}
    
  /** setter for offsetInSource - sets Byte offset of the start of document content within original source file or other input source. Only used if the CAS document was retrieved from an source where one physical source file contained several conceptual documents. Zero otherwise. 
   * @generated */
  public void setOffsetInSource(int v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_offsetInSource == null)
      jcasType.jcas.throwFeatMissing("offsetInSource", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_offsetInSource, v);}    
   
    
  //*--------------*
  //* Feature: documentSize

  /** getter for documentSize - gets Size of original document in bytes before processing by CAS Initializer. Either absolute file size of size within file or other source.
   * @generated */
  public int getDocumentSize() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_documentSize == null)
      jcasType.jcas.throwFeatMissing("documentSize", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_documentSize);}
    
  /** setter for documentSize - sets Size of original document in bytes before processing by CAS Initializer. Either absolute file size of size within file or other source. 
   * @generated */
  public void setDocumentSize(int v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_documentSize == null)
      jcasType.jcas.throwFeatMissing("documentSize", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_documentSize, v);}    
   
    
  //*--------------*
  //* Feature: filingType

  /** getter for filingType - gets The SEC filing type. Values can be
1 - DEF 14A
2 - 10-k
3 - N-PX
   * @generated */
  public int getFilingType() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_filingType == null)
      jcasType.jcas.throwFeatMissing("filingType", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_filingType);}
    
  /** setter for filingType - sets The SEC filing type. Values can be
1 - DEF 14A
2 - 10-k
3 - N-PX 
   * @generated */
  public void setFilingType(int v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_filingType == null)
      jcasType.jcas.throwFeatMissing("filingType", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_filingType, v);}    
   
    
  //*--------------*
  //* Feature: documentType

  /** getter for documentType - gets 1 - .txt
2 - .html
3 - .pdf
4 - .xml
   * @generated */
  public int getDocumentType() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_documentType == null)
      jcasType.jcas.throwFeatMissing("documentType", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_documentType);}
    
  /** setter for documentType - sets 1 - .txt
2 - .html
3 - .pdf
4 - .xml 
   * @generated */
  public void setDocumentType(int v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_documentType == null)
      jcasType.jcas.throwFeatMissing("documentType", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_documentType, v);}    
   
    
  //*--------------*
  //* Feature: timeStamp

  /** getter for timeStamp - gets 
   * @generated */
  public String getTimeStamp() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_timeStamp == null)
      jcasType.jcas.throwFeatMissing("timeStamp", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_timeStamp);}
    
  /** setter for timeStamp - sets  
   * @generated */
  public void setTimeStamp(String v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_timeStamp == null)
      jcasType.jcas.throwFeatMissing("timeStamp", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setStringValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_timeStamp, v);}    
   
    
  //*--------------*
  //* Feature: fileName

  /** getter for fileName - gets source document file name
   * @generated */
  public String getFileName() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_fileName == null)
      jcasType.jcas.throwFeatMissing("fileName", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_fileName);}
    
  /** setter for fileName - sets source document file name 
   * @generated */
  public void setFileName(String v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_fileName == null)
      jcasType.jcas.throwFeatMissing("fileName", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setStringValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_fileName, v);}    
   
    
  //*--------------*
  //* Feature: sentenceCount

  /** getter for sentenceCount - gets 
   * @generated */
  public int getSentenceCount() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_sentenceCount == null)
      jcasType.jcas.throwFeatMissing("sentenceCount", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_sentenceCount);}
    
  /** setter for sentenceCount - sets  
   * @generated */
  public void setSentenceCount(int v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_sentenceCount == null)
      jcasType.jcas.throwFeatMissing("sentenceCount", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_sentenceCount, v);}    
   
    
  //*--------------*
  //* Feature: tokenCount

  /** getter for tokenCount - gets 
   * @generated */
  public int getTokenCount() {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_tokenCount == null)
      jcasType.jcas.throwFeatMissing("tokenCount", "com.dp.edgar.uima.type.SourceDocInfo");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_tokenCount);}
    
  /** setter for tokenCount - sets  
   * @generated */
  public void setTokenCount(int v) {
    if (SourceDocInfo_Type.featOkTst && ((SourceDocInfo_Type)jcasType).casFeat_tokenCount == null)
      jcasType.jcas.throwFeatMissing("tokenCount", "com.dp.edgar.uima.type.SourceDocInfo");
    jcasType.ll_cas.ll_setIntValue(addr, ((SourceDocInfo_Type)jcasType).casFeatCode_tokenCount, v);}    
  }

    