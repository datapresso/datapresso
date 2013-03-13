

/* First created by JCasGen Thu Apr 19 15:11:54 EDT 2007 */
package com.dp.dhs.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.FSArray;


/** 
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class Company extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Company.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Company() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Company(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Company(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */
  public Company(JCas jcas, int begin, int end) {
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
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: cik

  /** getter for cik - gets 
   * @generated */
  public String getCik() {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_cik == null)
      jcasType.jcas.throwFeatMissing("cik", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_cik);}
    
  /** setter for cik - sets  
   * @generated */
  public void setCik(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_cik == null)
      jcasType.jcas.throwFeatMissing("cik", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_cik, v);}    
   
    
  //*--------------*
  //* Feature: street

  /** getter for street - gets 
   * @generated */
  public String getStreet() {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_street == null)
      jcasType.jcas.throwFeatMissing("street", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_street);}
    
  /** setter for street - sets  
   * @generated */
  public void setStreet(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_street == null)
      jcasType.jcas.throwFeatMissing("street", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_street, v);}    
   
    
  //*--------------*
  //* Feature: city

  /** getter for city - gets 
   * @generated */
  public String getCity() {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_city == null)
      jcasType.jcas.throwFeatMissing("city", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_city);}
    
  /** setter for city - sets  
   * @generated */
  public void setCity(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_city == null)
      jcasType.jcas.throwFeatMissing("city", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_city, v);}    
   
    
  //*--------------*
  //* Feature: state

  /** getter for state - gets 
   * @generated */
  public String getState() {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_state == null)
      jcasType.jcas.throwFeatMissing("state", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_state);}
    
  /** setter for state - sets  
   * @generated */
  public void setState(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_state == null)
      jcasType.jcas.throwFeatMissing("state", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_state, v);}    
   
    
  //*--------------*
  //* Feature: country

  /** getter for country - gets 
   * @generated */
  public String getCountry() {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_country == null)
      jcasType.jcas.throwFeatMissing("country", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_country);}
    
  /** setter for country - sets  
   * @generated */
  public void setCountry(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_country == null)
      jcasType.jcas.throwFeatMissing("country", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_country, v);}    
   
    
  //*--------------*
  //* Feature: zip

  /** getter for zip - gets 
   * @generated */
  public String getZip() {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_zip == null)
      jcasType.jcas.throwFeatMissing("zip", "com.dp.edgar.uima.type.Company");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Company_Type)jcasType).casFeatCode_zip);}
    
  /** setter for zip - sets  
   * @generated */
  public void setZip(String v) {
    if (Company_Type.featOkTst && ((Company_Type)jcasType).casFeat_zip == null)
      jcasType.jcas.throwFeatMissing("zip", "com.dp.edgar.uima.type.Company");
    jcasType.ll_cas.ll_setStringValue(addr, ((Company_Type)jcasType).casFeatCode_zip, v);}    
  }

    