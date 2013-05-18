

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class Fragment extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Fragment.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Fragment() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Fragment(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Fragment(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Fragment(JCas jcas, int begin, int end) {
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
  //* Feature: tokenType

  /** getter for tokenType - gets 
   * @generated */
  public int getTokenType() {
    if (Fragment_Type.featOkTst && ((Fragment_Type)jcasType).casFeat_tokenType == null)
      jcasType.jcas.throwFeatMissing("tokenType", "com.ibm.es.tt.Fragment");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Fragment_Type)jcasType).casFeatCode_tokenType);}
    
  /** setter for tokenType - sets  
   * @generated */
  public void setTokenType(int v) {
    if (Fragment_Type.featOkTst && ((Fragment_Type)jcasType).casFeat_tokenType == null)
      jcasType.jcas.throwFeatMissing("tokenType", "com.ibm.es.tt.Fragment");
    jcasType.ll_cas.ll_setIntValue(addr, ((Fragment_Type)jcasType).casFeatCode_tokenType, v);}    
  }

    