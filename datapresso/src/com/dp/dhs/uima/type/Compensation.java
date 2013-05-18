

/* First created by JCasGen Thu Apr 19 15:11:15 EDT 2007 */
package com.dp.dhs.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Jun 28 10:32:31 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation.xml
 * @generated */
public class Compensation extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Compensation.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Compensation() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Compensation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Compensation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */
  public Compensation(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Compensation_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setStringValue(addr, ((Compensation_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: position

  /** getter for position - gets 
   * @generated */
  public String getPosition() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_position == null)
      jcasType.jcas.throwFeatMissing("position", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Compensation_Type)jcasType).casFeatCode_position);}
    
  /** setter for position - sets  
   * @generated */
  public void setPosition(String v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_position == null)
      jcasType.jcas.throwFeatMissing("position", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setStringValue(addr, ((Compensation_Type)jcasType).casFeatCode_position, v);}    
   
    
  //*--------------*
  //* Feature: year

  /** getter for year - gets 
   * @generated */
  public int getYear() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_year == null)
      jcasType.jcas.throwFeatMissing("year", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Compensation_Type)jcasType).casFeatCode_year);}
    
  /** setter for year - sets  
   * @generated */
  public void setYear(int v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_year == null)
      jcasType.jcas.throwFeatMissing("year", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setIntValue(addr, ((Compensation_Type)jcasType).casFeatCode_year, v);}    
   
    
  //*--------------*
  //* Feature: salary

  /** getter for salary - gets 
   * @generated */
  public float getSalary() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_salary == null)
      jcasType.jcas.throwFeatMissing("salary", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_salary);}
    
  /** setter for salary - sets  
   * @generated */
  public void setSalary(float v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_salary == null)
      jcasType.jcas.throwFeatMissing("salary", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_salary, v);}    
   
    
  //*--------------*
  //* Feature: bonus

  /** getter for bonus - gets 
   * @generated */
  public float getBonus() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_bonus == null)
      jcasType.jcas.throwFeatMissing("bonus", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_bonus);}
    
  /** setter for bonus - sets  
   * @generated */
  public void setBonus(float v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_bonus == null)
      jcasType.jcas.throwFeatMissing("bonus", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_bonus, v);}    
   
    
  //*--------------*
  //* Feature: options

  /** getter for options - gets 
   * @generated */
  public float getOptions() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_options == null)
      jcasType.jcas.throwFeatMissing("options", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_options);}
    
  /** setter for options - sets  
   * @generated */
  public void setOptions(float v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_options == null)
      jcasType.jcas.throwFeatMissing("options", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_options, v);}    
   
    
  //*--------------*
  //* Feature: all

  /** getter for all - gets 
   * @generated */
  public float getAll() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_all == null)
      jcasType.jcas.throwFeatMissing("all", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_all);}
    
  /** setter for all - sets  
   * @generated */
  public void setAll(float v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_all == null)
      jcasType.jcas.throwFeatMissing("all", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_all, v);}    
   
    
  //*--------------*
  //* Feature: companyid

  /** getter for companyid - gets 
   * @generated */
  public String getCompanyid() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_companyid == null)
      jcasType.jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Compensation_Type)jcasType).casFeatCode_companyid);}
    
  /** setter for companyid - sets  
   * @generated */
  public void setCompanyid(String v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_companyid == null)
      jcasType.jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setStringValue(addr, ((Compensation_Type)jcasType).casFeatCode_companyid, v);}    
   
    
  //*--------------*
  //* Feature: personid

  /** getter for personid - gets 
   * @generated */
  public long getPersonid() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_personid == null)
      jcasType.jcas.throwFeatMissing("personid", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getLongValue(addr, ((Compensation_Type)jcasType).casFeatCode_personid);}
    
  /** setter for personid - sets  
   * @generated */
  public void setPersonid(long v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_personid == null)
      jcasType.jcas.throwFeatMissing("personid", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setLongValue(addr, ((Compensation_Type)jcasType).casFeatCode_personid, v);}    
   
    
  //*--------------*
  //* Feature: other

  /** getter for other - gets other compensations 
   * @generated */
  public float getOther() {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_other == null)
      jcasType.jcas.throwFeatMissing("other", "com.dp.edgar.uima.type.Compensation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_other);}
    
  /** setter for other - sets other compensations  
   * @generated */
  public void setOther(float v) {
    if (Compensation_Type.featOkTst && ((Compensation_Type)jcasType).casFeat_other == null)
      jcasType.jcas.throwFeatMissing("other", "com.dp.edgar.uima.type.Compensation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Compensation_Type)jcasType).casFeatCode_other, v);}    
  }

    