

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringArray;


/** 
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class NativeACLS extends TOP {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(NativeACLS.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NativeACLS() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NativeACLS(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NativeACLS(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: domain

  /** getter for domain - gets 
   * @generated */
  public String getDomain() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_domain == null)
      jcasType.jcas.throwFeatMissing("domain", "com.ibm.es.tt.NativeACLS");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_domain);}
    
  /** setter for domain - sets  
   * @generated */
  public void setDomain(String v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_domain == null)
      jcasType.jcas.throwFeatMissing("domain", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setStringValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_domain, v);}    
   
    
  //*--------------*
  //* Feature: level1allow

  /** getter for level1allow - gets 
   * @generated */
  public StringArray getLevel1allow() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1allow == null)
      jcasType.jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1allow)));}
    
  /** setter for level1allow - sets  
   * @generated */
  public void setLevel1allow(StringArray v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1allow == null)
      jcasType.jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1allow, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for level1allow - gets an indexed value - 
   * @generated */
  public String getLevel1allow(int i) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1allow == null)
      jcasType.jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1allow), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1allow), i);}

  /** indexed setter for level1allow - sets an indexed value - 
   * @generated */
  public void setLevel1allow(int i, String v) { 
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1allow == null)
      jcasType.jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1allow), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1allow), i, v);}
   
    
  //*--------------*
  //* Feature: level1deny

  /** getter for level1deny - gets 
   * @generated */
  public StringArray getLevel1deny() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1deny == null)
      jcasType.jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1deny)));}
    
  /** setter for level1deny - sets  
   * @generated */
  public void setLevel1deny(StringArray v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1deny == null)
      jcasType.jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1deny, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for level1deny - gets an indexed value - 
   * @generated */
  public String getLevel1deny(int i) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1deny == null)
      jcasType.jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1deny), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1deny), i);}

  /** indexed setter for level1deny - sets an indexed value - 
   * @generated */
  public void setLevel1deny(int i, String v) { 
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level1deny == null)
      jcasType.jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1deny), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level1deny), i, v);}
   
    
  //*--------------*
  //* Feature: level2allow

  /** getter for level2allow - gets 
   * @generated */
  public StringArray getLevel2allow() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2allow == null)
      jcasType.jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2allow)));}
    
  /** setter for level2allow - sets  
   * @generated */
  public void setLevel2allow(StringArray v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2allow == null)
      jcasType.jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2allow, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for level2allow - gets an indexed value - 
   * @generated */
  public String getLevel2allow(int i) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2allow == null)
      jcasType.jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2allow), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2allow), i);}

  /** indexed setter for level2allow - sets an indexed value - 
   * @generated */
  public void setLevel2allow(int i, String v) { 
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2allow == null)
      jcasType.jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2allow), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2allow), i, v);}
   
    
  //*--------------*
  //* Feature: level2deny

  /** getter for level2deny - gets 
   * @generated */
  public StringArray getLevel2deny() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2deny == null)
      jcasType.jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2deny)));}
    
  /** setter for level2deny - sets  
   * @generated */
  public void setLevel2deny(StringArray v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2deny == null)
      jcasType.jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2deny, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for level2deny - gets an indexed value - 
   * @generated */
  public String getLevel2deny(int i) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2deny == null)
      jcasType.jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2deny), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2deny), i);}

  /** indexed setter for level2deny - sets an indexed value - 
   * @generated */
  public void setLevel2deny(int i, String v) { 
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_level2deny == null)
      jcasType.jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2deny), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_level2deny), i, v);}
   
    
  //*--------------*
  //* Feature: impersonate

  /** getter for impersonate - gets 
   * @generated */
  public int getImpersonate() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_impersonate == null)
      jcasType.jcas.throwFeatMissing("impersonate", "com.ibm.es.tt.NativeACLS");
    return jcasType.ll_cas.ll_getIntValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_impersonate);}
    
  /** setter for impersonate - sets  
   * @generated */
  public void setImpersonate(int v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_impersonate == null)
      jcasType.jcas.throwFeatMissing("impersonate", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setIntValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_impersonate, v);}    
   
    
  //*--------------*
  //* Feature: protocol

  /** getter for protocol - gets 
   * @generated */
  public String getProtocol() {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_protocol == null)
      jcasType.jcas.throwFeatMissing("protocol", "com.ibm.es.tt.NativeACLS");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_protocol);}
    
  /** setter for protocol - sets  
   * @generated */
  public void setProtocol(String v) {
    if (NativeACLS_Type.featOkTst && ((NativeACLS_Type)jcasType).casFeat_protocol == null)
      jcasType.jcas.throwFeatMissing("protocol", "com.ibm.es.tt.NativeACLS");
    jcasType.ll_cas.ll_setStringValue(addr, ((NativeACLS_Type)jcasType).casFeatCode_protocol, v);}    
  }

    