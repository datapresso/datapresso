

/* First created by JCasGen Sun May 31 22:03:29 EDT 2009 */
package org.apache.uima.jcas.tcas;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import com.ibm.es.tt.DocumentMetaData;


/** 
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class DocumentAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(DocumentAnnotation.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DocumentAnnotation() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DocumentAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DocumentAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DocumentAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: language

  /** getter for language - gets 
   * @generated */
  public String getLanguage() {
    if (DocumentAnnotation_Type.featOkTst && ((DocumentAnnotation_Type)jcasType).casFeat_language == null)
      jcasType.jcas.throwFeatMissing("language", "uima.tcas.DocumentAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentAnnotation_Type)jcasType).casFeatCode_language);}
    
  /** setter for language - sets  
   * @generated */
  public void setLanguage(String v) {
    if (DocumentAnnotation_Type.featOkTst && ((DocumentAnnotation_Type)jcasType).casFeat_language == null)
      jcasType.jcas.throwFeatMissing("language", "uima.tcas.DocumentAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentAnnotation_Type)jcasType).casFeatCode_language, v);}    
   
    
  //*--------------*
  //* Feature: esDocumentMetaData

  /** getter for esDocumentMetaData - gets meta data of omnifind document
   * @generated */
  public DocumentMetaData getEsDocumentMetaData() {
    if (DocumentAnnotation_Type.featOkTst && ((DocumentAnnotation_Type)jcasType).casFeat_esDocumentMetaData == null)
      jcasType.jcas.throwFeatMissing("esDocumentMetaData", "uima.tcas.DocumentAnnotation");
    return (DocumentMetaData)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DocumentAnnotation_Type)jcasType).casFeatCode_esDocumentMetaData)));}
    
  /** setter for esDocumentMetaData - sets meta data of omnifind document 
   * @generated */
  public void setEsDocumentMetaData(DocumentMetaData v) {
    if (DocumentAnnotation_Type.featOkTst && ((DocumentAnnotation_Type)jcasType).casFeat_esDocumentMetaData == null)
      jcasType.jcas.throwFeatMissing("esDocumentMetaData", "uima.tcas.DocumentAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((DocumentAnnotation_Type)jcasType).casFeatCode_esDocumentMetaData, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    