

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Content Field Annotation
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class ContentField extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(ContentField.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ContentField() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ContentField(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ContentField(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ContentField(JCas jcas, int begin, int end) {
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
  //* Feature: parameters

  /** getter for parameters - gets 
   * @generated */
  public CommonFieldParameters getParameters() {
    if (ContentField_Type.featOkTst && ((ContentField_Type)jcasType).casFeat_parameters == null)
      jcasType.jcas.throwFeatMissing("parameters", "com.ibm.es.tt.ContentField");
    return (CommonFieldParameters)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ContentField_Type)jcasType).casFeatCode_parameters)));}
    
  /** setter for parameters - sets  
   * @generated */
  public void setParameters(CommonFieldParameters v) {
    if (ContentField_Type.featOkTst && ((ContentField_Type)jcasType).casFeat_parameters == null)
      jcasType.jcas.throwFeatMissing("parameters", "com.ibm.es.tt.ContentField");
    jcasType.ll_cas.ll_setRefValue(addr, ((ContentField_Type)jcasType).casFeatCode_parameters, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    