

/* First created by JCasGen Sun May 31 22:03:29 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringArray;


/** Document meta data specific for omnifind. The feature structure will  connected to the DocumentAnnotation
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class DocumentMetaData extends TOP {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(DocumentMetaData.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DocumentMetaData() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DocumentMetaData(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DocumentMetaData(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: crawlerId

  /** getter for crawlerId - gets crawler name, document meta data
   * @generated */
  public String getCrawlerId() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_crawlerId == null)
      jcasType.jcas.throwFeatMissing("crawlerId", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_crawlerId);}
    
  /** setter for crawlerId - sets crawler name, document meta data 
   * @generated */
  public void setCrawlerId(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_crawlerId == null)
      jcasType.jcas.throwFeatMissing("crawlerId", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_crawlerId, v);}    
   
    
  //*--------------*
  //* Feature: dataSource

  /** getter for dataSource - gets data source type like db2 or web(depends on the crawler), document meta data
   * @generated */
  public String getDataSource() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_dataSource == null)
      jcasType.jcas.throwFeatMissing("dataSource", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_dataSource);}
    
  /** setter for dataSource - sets data source type like db2 or web(depends on the crawler), document meta data 
   * @generated */
  public void setDataSource(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_dataSource == null)
      jcasType.jcas.throwFeatMissing("dataSource", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_dataSource, v);}    
   
    
  //*--------------*
  //* Feature: dataSourceName

  /** getter for dataSourceName - gets each crawler(datasource) has a specific name(desciption), document meta data
   * @generated */
  public String getDataSourceName() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_dataSourceName == null)
      jcasType.jcas.throwFeatMissing("dataSourceName", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_dataSourceName);}
    
  /** setter for dataSourceName - sets each crawler(datasource) has a specific name(desciption), document meta data 
   * @generated */
  public void setDataSourceName(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_dataSourceName == null)
      jcasType.jcas.throwFeatMissing("dataSourceName", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_dataSourceName, v);}    
   
    
  //*--------------*
  //* Feature: charset

  /** getter for charset - gets Fallback codepage of the document.  Will only be used
                                 when no knownCharset is specified, and codepage detection
                                 is turned off or doesn"t find anything.
   * @generated */
  public String getCharset() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_charset == null)
      jcasType.jcas.throwFeatMissing("charset", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_charset);}
    
  /** setter for charset - sets Fallback codepage of the document.  Will only be used
                                 when no knownCharset is specified, and codepage detection
                                 is turned off or doesn"t find anything. 
   * @generated */
  public void setCharset(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_charset == null)
      jcasType.jcas.throwFeatMissing("charset", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_charset, v);}    
   
    
  //*--------------*
  //* Feature: knownCharset

  /** getter for knownCharset - gets User-defined odepage of document.  If this is set, this code
                                 page was used for the document (unless it wasn"t possible to read in
                                 the document with this encoding).
   * @generated */
  public String getKnownCharset() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_knownCharset == null)
      jcasType.jcas.throwFeatMissing("knownCharset", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_knownCharset);}
    
  /** setter for knownCharset - sets User-defined odepage of document.  If this is set, this code
                                 page was used for the document (unless it wasn"t possible to read in
                                 the document with this encoding). 
   * @generated */
  public void setKnownCharset(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_knownCharset == null)
      jcasType.jcas.throwFeatMissing("knownCharset", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_knownCharset, v);}    
   
    
  //*--------------*
  //* Feature: actualCharset

  /** getter for actualCharset - gets This is the charset that was actually used to read
                                 in the document.  Mostly useful for debugging.
   * @generated */
  public String getActualCharset() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_actualCharset == null)
      jcasType.jcas.throwFeatMissing("actualCharset", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_actualCharset);}
    
  /** setter for actualCharset - sets This is the charset that was actually used to read
                                 in the document.  Mostly useful for debugging. 
   * @generated */
  public void setActualCharset(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_actualCharset == null)
      jcasType.jcas.throwFeatMissing("actualCharset", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_actualCharset, v);}    
   
    
  //*--------------*
  //* Feature: docType

  /** getter for docType - gets docuement type, like text, html, pdf
   * @generated */
  public String getDocType() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_docType == null)
      jcasType.jcas.throwFeatMissing("docType", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_docType);}
    
  /** setter for docType - sets docuement type, like text, html, pdf 
   * @generated */
  public void setDocType(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_docType == null)
      jcasType.jcas.throwFeatMissing("docType", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_docType, v);}    
   
    
  //*--------------*
  //* Feature: securityTokens

  /** getter for securityTokens - gets Security token of the document, document meta data
   * @generated */
  public StringArray getSecurityTokens() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_securityTokens == null)
      jcasType.jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_securityTokens)));}
    
  /** setter for securityTokens - sets Security token of the document, document meta data 
   * @generated */
  public void setSecurityTokens(StringArray v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_securityTokens == null)
      jcasType.jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_securityTokens, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for securityTokens - gets an indexed value - Security token of the document, document meta data
   * @generated */
  public String getSecurityTokens(int i) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_securityTokens == null)
      jcasType.jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_securityTokens), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_securityTokens), i);}

  /** indexed setter for securityTokens - sets an indexed value - Security token of the document, document meta data
   * @generated */
  public void setSecurityTokens(int i, String v) { 
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_securityTokens == null)
      jcasType.jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_securityTokens), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_securityTokens), i, v);}
   
    
  //*--------------*
  //* Feature: date

  /** getter for date - gets document date, document meta data
   * @generated */
  public String getDate() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_date == null)
      jcasType.jcas.throwFeatMissing("date", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_date);}
    
  /** setter for date - sets document date, document meta data 
   * @generated */
  public void setDate(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_date == null)
      jcasType.jcas.throwFeatMissing("date", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_date, v);}    
   
    
  //*--------------*
  //* Feature: staticScore

  /** getter for staticScore - gets static document score, document meta data
   * @generated */
  public String getStaticScore() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_staticScore == null)
      jcasType.jcas.throwFeatMissing("staticScore", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_staticScore);}
    
  /** setter for staticScore - sets static document score, document meta data 
   * @generated */
  public void setStaticScore(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_staticScore == null)
      jcasType.jcas.throwFeatMissing("staticScore", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_staticScore, v);}    
   
    
  //*--------------*
  //* Feature: baseUri

  /** getter for baseUri - gets base uri of the page
   * @generated */
  public String getBaseUri() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_baseUri == null)
      jcasType.jcas.throwFeatMissing("baseUri", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_baseUri);}
    
  /** setter for baseUri - sets base uri of the page 
   * @generated */
  public void setBaseUri(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_baseUri == null)
      jcasType.jcas.throwFeatMissing("baseUri", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_baseUri, v);}    
   
    
  //*--------------*
  //* Feature: metaDataFields

  /** getter for metaDataFields - gets list of meta data fields
   * @generated */
  public FSArray getMetaDataFields() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metaDataFields == null)
      jcasType.jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaDataFields)));}
    
  /** setter for metaDataFields - sets list of meta data fields 
   * @generated */
  public void setMetaDataFields(FSArray v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metaDataFields == null)
      jcasType.jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaDataFields, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for metaDataFields - gets an indexed value - list of meta data fields
   * @generated */
  public TOP getMetaDataFields(int i) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metaDataFields == null)
      jcasType.jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaDataFields), i);
    return (TOP)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaDataFields), i)));}

  /** indexed setter for metaDataFields - sets an indexed value - list of meta data fields
   * @generated */
  public void setMetaDataFields(int i, TOP v) { 
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metaDataFields == null)
      jcasType.jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaDataFields), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaDataFields), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: redirectUrl

  /** getter for redirectUrl - gets 
   * @generated */
  public String getRedirectUrl() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_redirectUrl == null)
      jcasType.jcas.throwFeatMissing("redirectUrl", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_redirectUrl);}
    
  /** setter for redirectUrl - sets  
   * @generated */
  public void setRedirectUrl(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_redirectUrl == null)
      jcasType.jcas.throwFeatMissing("redirectUrl", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_redirectUrl, v);}    
   
    
  //*--------------*
  //* Feature: knownLanguage

  /** getter for knownLanguage - gets 
   * @generated */
  public String getKnownLanguage() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_knownLanguage == null)
      jcasType.jcas.throwFeatMissing("knownLanguage", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_knownLanguage);}
    
  /** setter for knownLanguage - sets  
   * @generated */
  public void setKnownLanguage(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_knownLanguage == null)
      jcasType.jcas.throwFeatMissing("knownLanguage", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_knownLanguage, v);}    
   
    
  //*--------------*
  //* Feature: contentLanguage

  /** getter for contentLanguage - gets 
   * @generated */
  public String getContentLanguage() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_contentLanguage == null)
      jcasType.jcas.throwFeatMissing("contentLanguage", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_contentLanguage);}
    
  /** setter for contentLanguage - sets  
   * @generated */
  public void setContentLanguage(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_contentLanguage == null)
      jcasType.jcas.throwFeatMissing("contentLanguage", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_contentLanguage, v);}    
   
    
  //*--------------*
  //* Feature: compressed

  /** getter for compressed - gets 
   * @generated */
  public int getCompressed() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_compressed == null)
      jcasType.jcas.throwFeatMissing("compressed", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_compressed);}
    
  /** setter for compressed - sets  
   * @generated */
  public void setCompressed(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_compressed == null)
      jcasType.jcas.throwFeatMissing("compressed", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_compressed, v);}    
   
    
  //*--------------*
  //* Feature: truncated

  /** getter for truncated - gets 
   * @generated */
  public int getTruncated() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_truncated == null)
      jcasType.jcas.throwFeatMissing("truncated", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_truncated);}
    
  /** setter for truncated - sets  
   * @generated */
  public void setTruncated(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_truncated == null)
      jcasType.jcas.throwFeatMissing("truncated", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_truncated, v);}    
   
    
  //*--------------*
  //* Feature: hasSeparatContent

  /** getter for hasSeparatContent - gets 
   * @generated */
  public int getHasSeparatContent() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_hasSeparatContent == null)
      jcasType.jcas.throwFeatMissing("hasSeparatContent", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_hasSeparatContent);}
    
  /** setter for hasSeparatContent - sets  
   * @generated */
  public void setHasSeparatContent(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_hasSeparatContent == null)
      jcasType.jcas.throwFeatMissing("hasSeparatContent", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_hasSeparatContent, v);}    
   
    
  //*--------------*
  //* Feature: mimeType

  /** getter for mimeType - gets 
   * @generated */
  public String getMimeType() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_mimeType == null)
      jcasType.jcas.throwFeatMissing("mimeType", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_mimeType);}
    
  /** setter for mimeType - sets  
   * @generated */
  public void setMimeType(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_mimeType == null)
      jcasType.jcas.throwFeatMissing("mimeType", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_mimeType, v);}    
   
    
  //*--------------*
  //* Feature: metaLanguage

  /** getter for metaLanguage - gets 
   * @generated */
  public String getMetaLanguage() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metaLanguage == null)
      jcasType.jcas.throwFeatMissing("metaLanguage", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaLanguage);}
    
  /** setter for metaLanguage - sets  
   * @generated */
  public void setMetaLanguage(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metaLanguage == null)
      jcasType.jcas.throwFeatMissing("metaLanguage", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metaLanguage, v);}    
   
    
  //*--------------*
  //* Feature: url

  /** getter for url - gets 
   * @generated */
  public String getUrl() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_url == null)
      jcasType.jcas.throwFeatMissing("url", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_url);}
    
  /** setter for url - sets  
   * @generated */
  public void setUrl(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_url == null)
      jcasType.jcas.throwFeatMissing("url", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_url, v);}    
   
    
  //*--------------*
  //* Feature: documentName

  /** getter for documentName - gets 
   * @generated */
  public String getDocumentName() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_documentName == null)
      jcasType.jcas.throwFeatMissing("documentName", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_documentName);}
    
  /** setter for documentName - sets  
   * @generated */
  public void setDocumentName(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_documentName == null)
      jcasType.jcas.throwFeatMissing("documentName", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_documentName, v);}    
   
    
  //*--------------*
  //* Feature: httpcode

  /** getter for httpcode - gets 
   * @generated */
  public int getHttpcode() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_httpcode == null)
      jcasType.jcas.throwFeatMissing("httpcode", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_httpcode);}
    
  /** setter for httpcode - sets  
   * @generated */
  public void setHttpcode(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_httpcode == null)
      jcasType.jcas.throwFeatMissing("httpcode", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_httpcode, v);}    
   
    
  //*--------------*
  //* Feature: metalength

  /** getter for metalength - gets 
   * @generated */
  public int getMetalength() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metalength == null)
      jcasType.jcas.throwFeatMissing("metalength", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metalength);}
    
  /** setter for metalength - sets  
   * @generated */
  public void setMetalength(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_metalength == null)
      jcasType.jcas.throwFeatMissing("metalength", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_metalength, v);}    
   
    
  //*--------------*
  //* Feature: contentlength

  /** getter for contentlength - gets 
   * @generated */
  public int getContentlength() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_contentlength == null)
      jcasType.jcas.throwFeatMissing("contentlength", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_contentlength);}
    
  /** setter for contentlength - sets  
   * @generated */
  public void setContentlength(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_contentlength == null)
      jcasType.jcas.throwFeatMissing("contentlength", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_contentlength, v);}    
   
    
  //*--------------*
  //* Feature: rdstype

  /** getter for rdstype - gets raw data store type: data listener/crawler
   * @generated */
  public int getRdstype() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_rdstype == null)
      jcasType.jcas.throwFeatMissing("rdstype", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_rdstype);}
    
  /** setter for rdstype - sets raw data store type: data listener/crawler 
   * @generated */
  public void setRdstype(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_rdstype == null)
      jcasType.jcas.throwFeatMissing("rdstype", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_rdstype, v);}    
   
    
  //*--------------*
  //* Feature: nativeACLS

  /** getter for nativeACLS - gets 
   * @generated */
  public NativeACLS getNativeACLS() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_nativeACLS == null)
      jcasType.jcas.throwFeatMissing("nativeACLS", "com.ibm.es.tt.DocumentMetaData");
    return (NativeACLS)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_nativeACLS)));}
    
  /** setter for nativeACLS - sets  
   * @generated */
  public void setNativeACLS(NativeACLS v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_nativeACLS == null)
      jcasType.jcas.throwFeatMissing("nativeACLS", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_nativeACLS, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: isCompleted

  /** getter for isCompleted - gets flag for chunked documents, shows if it is completed
   * @generated */
  public int getIsCompleted() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_isCompleted == null)
      jcasType.jcas.throwFeatMissing("isCompleted", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_isCompleted);}
    
  /** setter for isCompleted - sets flag for chunked documents, shows if it is completed 
   * @generated */
  public void setIsCompleted(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_isCompleted == null)
      jcasType.jcas.throwFeatMissing("isCompleted", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_isCompleted, v);}    
   
    
  //*--------------*
  //* Feature: sequenceNumber

  /** getter for sequenceNumber - gets sequence number of the chunk; 0 if no chunking
   * @generated */
  public int getSequenceNumber() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_sequenceNumber == null)
      jcasType.jcas.throwFeatMissing("sequenceNumber", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_sequenceNumber);}
    
  /** setter for sequenceNumber - sets sequence number of the chunk; 0 if no chunking 
   * @generated */
  public void setSequenceNumber(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_sequenceNumber == null)
      jcasType.jcas.throwFeatMissing("sequenceNumber", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_sequenceNumber, v);}    
   
    
  //*--------------*
  //* Feature: documentId

  /** getter for documentId - gets unique and sortable document id
   * @generated */
  public int getDocumentId() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_documentId == null)
      jcasType.jcas.throwFeatMissing("documentId", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_documentId);}
    
  /** setter for documentId - sets unique and sortable document id 
   * @generated */
  public void setDocumentId(int v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_documentId == null)
      jcasType.jcas.throwFeatMissing("documentId", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setIntValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_documentId, v);}    
   
    
  //*--------------*
  //* Feature: title

  /** getter for title - gets 
   * @generated */
  public String getTitle() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets  
   * @generated */
  public void setTitle(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_title, v);}    
   
    
  //*--------------*
  //* Feature: frames

  /** getter for frames - gets 
   * @generated */
  public StringArray getFrames() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_frames == null)
      jcasType.jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_frames)));}
    
  /** setter for frames - sets  
   * @generated */
  public void setFrames(StringArray v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_frames == null)
      jcasType.jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_frames, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for frames - gets an indexed value - 
   * @generated */
  public String getFrames(int i) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_frames == null)
      jcasType.jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_frames), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_frames), i);}

  /** indexed setter for frames - sets an indexed value - 
   * @generated */
  public void setFrames(int i, String v) { 
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_frames == null)
      jcasType.jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_frames), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_frames), i, v);}
   
    
  //*--------------*
  //* Feature: throttleID

  /** getter for throttleID - gets 
   * @generated */
  public String getThrottleID() {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_throttleID == null)
      jcasType.jcas.throwFeatMissing("throttleID", "com.ibm.es.tt.DocumentMetaData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_throttleID);}
    
  /** setter for throttleID - sets  
   * @generated */
  public void setThrottleID(String v) {
    if (DocumentMetaData_Type.featOkTst && ((DocumentMetaData_Type)jcasType).casFeat_throttleID == null)
      jcasType.jcas.throwFeatMissing("throttleID", "com.ibm.es.tt.DocumentMetaData");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetaData_Type)jcasType).casFeatCode_throttleID, v);}    
  }

    