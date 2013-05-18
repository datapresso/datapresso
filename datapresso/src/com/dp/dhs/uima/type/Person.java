

/* First created by JCasGen Wed Aug 29 21:44:40 EDT 2007 */
package com.dp.dhs.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.cas.StringArray;


/** 
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class Person extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Person.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Person() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Person(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Person(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */
  public Person(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public int getId() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Person_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(int v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setIntValue(addr, ((Person_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: firstname

  /** getter for firstname - gets 
   * @generated */
  public String getFirstname() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_firstname == null)
      jcasType.jcas.throwFeatMissing("firstname", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_firstname);}
    
  /** setter for firstname - sets  
   * @generated */
  public void setFirstname(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_firstname == null)
      jcasType.jcas.throwFeatMissing("firstname", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_firstname, v);}    
   
    
  //*--------------*
  //* Feature: lastname

  /** getter for lastname - gets 
   * @generated */
  public String getLastname() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_lastname == null)
      jcasType.jcas.throwFeatMissing("lastname", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_lastname);}
    
  /** setter for lastname - sets  
   * @generated */
  public void setLastname(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_lastname == null)
      jcasType.jcas.throwFeatMissing("lastname", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_lastname, v);}    
   
    
  //*--------------*
  //* Feature: middlename

  /** getter for middlename - gets 
   * @generated */
  public String getMiddlename() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_middlename == null)
      jcasType.jcas.throwFeatMissing("middlename", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_middlename);}
    
  /** setter for middlename - sets  
   * @generated */
  public void setMiddlename(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_middlename == null)
      jcasType.jcas.throwFeatMissing("middlename", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_middlename, v);}    
   
    
  //*--------------*
  //* Feature: age

  /** getter for age - gets 
   * @generated */
  public int getAge() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_age == null)
      jcasType.jcas.throwFeatMissing("age", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Person_Type)jcasType).casFeatCode_age);}
    
  /** setter for age - sets  
   * @generated */
  public void setAge(int v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_age == null)
      jcasType.jcas.throwFeatMissing("age", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setIntValue(addr, ((Person_Type)jcasType).casFeatCode_age, v);}    
   
    
  //*--------------*
  //* Feature: gender

  /** getter for gender - gets 
   * @generated */
  public String getGender() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_gender == null)
      jcasType.jcas.throwFeatMissing("gender", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_gender);}
    
  /** setter for gender - sets  
   * @generated */
  public void setGender(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_gender == null)
      jcasType.jcas.throwFeatMissing("gender", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_gender, v);}    
   
    
  //*--------------*
  //* Feature: education

  /** getter for education - gets 
   * @generated */
  public String getEducation() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_education == null)
      jcasType.jcas.throwFeatMissing("education", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_education);}
    
  /** setter for education - sets  
   * @generated */
  public void setEducation(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_education == null)
      jcasType.jcas.throwFeatMissing("education", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_education, v);}    
   
    
  //*--------------*
  //* Feature: employment

  /** getter for employment - gets 
   * @generated */
  public StringArray getEmployment() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_employment == null)
      jcasType.jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Person_Type)jcasType).casFeatCode_employment)));}
    
  /** setter for employment - sets  
   * @generated */
  public void setEmployment(StringArray v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_employment == null)
      jcasType.jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setRefValue(addr, ((Person_Type)jcasType).casFeatCode_employment, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for employment - gets an indexed value - 
   * @generated */
  public String getEmployment(int i) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_employment == null)
      jcasType.jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Person_Type)jcasType).casFeatCode_employment), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Person_Type)jcasType).casFeatCode_employment), i);}

  /** indexed setter for employment - sets an indexed value - 
   * @generated */
  public void setEmployment(int i, String v) { 
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_employment == null)
      jcasType.jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Person_Type)jcasType).casFeatCode_employment), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Person_Type)jcasType).casFeatCode_employment), i, v);}
   
    
  //*--------------*
  //* Feature: suffix

  /** getter for suffix - gets Jr
III
the Great
etc
   * @generated */
  public String getSuffix() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_suffix == null)
      jcasType.jcas.throwFeatMissing("suffix", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_suffix);}
    
  /** setter for suffix - sets Jr
III
the Great
etc 
   * @generated */
  public void setSuffix(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_suffix == null)
      jcasType.jcas.throwFeatMissing("suffix", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_suffix, v);}    
   
    
  //*--------------*
  //* Feature: companyid

  /** getter for companyid - gets 
   * @generated */
  public String getCompanyid() {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_companyid == null)
      jcasType.jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Person");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Person_Type)jcasType).casFeatCode_companyid);}
    
  /** setter for companyid - sets  
   * @generated */
  public void setCompanyid(String v) {
    if (Person_Type.featOkTst && ((Person_Type)jcasType).casFeat_companyid == null)
      jcasType.jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Person");
    jcasType.ll_cas.ll_setStringValue(addr, ((Person_Type)jcasType).casFeatCode_companyid, v);}    
  }

    