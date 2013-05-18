

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** Data of a meta field. The text data of the meta field are not part of the document content,  but is stored in the feature "text"
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class MetaDataField extends TOP {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(MetaDataField.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected MetaDataField() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MetaDataField(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MetaDataField(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: parameters

  /** getter for parameters - gets 
   * @generated */
  public CommonFieldParameters getParameters() {
    if (MetaDataField_Type.featOkTst && ((MetaDataField_Type)jcasType).casFeat_parameters == null)
      jcasType.jcas.throwFeatMissing("parameters", "com.ibm.es.tt.MetaDataField");
    return (CommonFieldParameters)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((MetaDataField_Type)jcasType).casFeatCode_parameters)));}
    
  /** setter for parameters - sets  
   * @generated */
  public void setParameters(CommonFieldParameters v) {
    if (MetaDataField_Type.featOkTst && ((MetaDataField_Type)jcasType).casFeat_parameters == null)
      jcasType.jcas.throwFeatMissing("parameters", "com.ibm.es.tt.MetaDataField");
    jcasType.ll_cas.ll_setRefValue(addr, ((MetaDataField_Type)jcasType).casFeatCode_parameters, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated */
  public String getText() {
    if (MetaDataField_Type.featOkTst && ((MetaDataField_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "com.ibm.es.tt.MetaDataField");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MetaDataField_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (MetaDataField_Type.featOkTst && ((MetaDataField_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "com.ibm.es.tt.MetaDataField");
    jcasType.ll_cas.ll_setStringValue(addr, ((MetaDataField_Type)jcasType).casFeatCode_text, v);}    
  }

    