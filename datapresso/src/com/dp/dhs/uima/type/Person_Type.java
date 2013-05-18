
/* First created by JCasGen Wed Aug 29 21:44:40 EDT 2007 */
package com.dp.dhs.uima.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * @generated */
public class Person_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Person_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Person_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Person(addr, Person_Type.this);
  			   Person_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Person(addr, Person_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Person.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.dp.edgar.uima.type.Person");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public int getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getIntValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, int v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setIntValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_firstname;
  /** @generated */
  final int     casFeatCode_firstname;
  /** @generated */ 
  public String getFirstname(int addr) {
        if (featOkTst && casFeat_firstname == null)
      jcas.throwFeatMissing("firstname", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_firstname);
  }
  /** @generated */    
  public void setFirstname(int addr, String v) {
        if (featOkTst && casFeat_firstname == null)
      jcas.throwFeatMissing("firstname", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_firstname, v);}
    
  
 
  /** @generated */
  final Feature casFeat_lastname;
  /** @generated */
  final int     casFeatCode_lastname;
  /** @generated */ 
  public String getLastname(int addr) {
        if (featOkTst && casFeat_lastname == null)
      jcas.throwFeatMissing("lastname", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_lastname);
  }
  /** @generated */    
  public void setLastname(int addr, String v) {
        if (featOkTst && casFeat_lastname == null)
      jcas.throwFeatMissing("lastname", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_lastname, v);}
    
  
 
  /** @generated */
  final Feature casFeat_middlename;
  /** @generated */
  final int     casFeatCode_middlename;
  /** @generated */ 
  public String getMiddlename(int addr) {
        if (featOkTst && casFeat_middlename == null)
      jcas.throwFeatMissing("middlename", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_middlename);
  }
  /** @generated */    
  public void setMiddlename(int addr, String v) {
        if (featOkTst && casFeat_middlename == null)
      jcas.throwFeatMissing("middlename", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_middlename, v);}
    
  
 
  /** @generated */
  final Feature casFeat_age;
  /** @generated */
  final int     casFeatCode_age;
  /** @generated */ 
  public int getAge(int addr) {
        if (featOkTst && casFeat_age == null)
      jcas.throwFeatMissing("age", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getIntValue(addr, casFeatCode_age);
  }
  /** @generated */    
  public void setAge(int addr, int v) {
        if (featOkTst && casFeat_age == null)
      jcas.throwFeatMissing("age", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setIntValue(addr, casFeatCode_age, v);}
    
  
 
  /** @generated */
  final Feature casFeat_gender;
  /** @generated */
  final int     casFeatCode_gender;
  /** @generated */ 
  public String getGender(int addr) {
        if (featOkTst && casFeat_gender == null)
      jcas.throwFeatMissing("gender", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_gender);
  }
  /** @generated */    
  public void setGender(int addr, String v) {
        if (featOkTst && casFeat_gender == null)
      jcas.throwFeatMissing("gender", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_gender, v);}
    
  
 
  /** @generated */
  final Feature casFeat_education;
  /** @generated */
  final int     casFeatCode_education;
  /** @generated */ 
  public String getEducation(int addr) {
        if (featOkTst && casFeat_education == null)
      jcas.throwFeatMissing("education", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_education);
  }
  /** @generated */    
  public void setEducation(int addr, String v) {
        if (featOkTst && casFeat_education == null)
      jcas.throwFeatMissing("education", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_education, v);}
    
  
 
  /** @generated */
  final Feature casFeat_employment;
  /** @generated */
  final int     casFeatCode_employment;
  /** @generated */ 
  public int getEmployment(int addr) {
        if (featOkTst && casFeat_employment == null)
      jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getRefValue(addr, casFeatCode_employment);
  }
  /** @generated */    
  public void setEmployment(int addr, int v) {
        if (featOkTst && casFeat_employment == null)
      jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setRefValue(addr, casFeatCode_employment, v);}
    
   /** @generated */
  public String getEmployment(int addr, int i) {
        if (featOkTst && casFeat_employment == null)
      jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_employment), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_employment), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_employment), i);
  }
   
  /** @generated */ 
  public void setEmployment(int addr, int i, String v) {
        if (featOkTst && casFeat_employment == null)
      jcas.throwFeatMissing("employment", "com.dp.edgar.uima.type.Person");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_employment), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_employment), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_employment), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_suffix;
  /** @generated */
  final int     casFeatCode_suffix;
  /** @generated */ 
  public String getSuffix(int addr) {
        if (featOkTst && casFeat_suffix == null)
      jcas.throwFeatMissing("suffix", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_suffix);
  }
  /** @generated */    
  public void setSuffix(int addr, String v) {
        if (featOkTst && casFeat_suffix == null)
      jcas.throwFeatMissing("suffix", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_suffix, v);}
    
  
 
  /** @generated */
  final Feature casFeat_companyid;
  /** @generated */
  final int     casFeatCode_companyid;
  /** @generated */ 
  public String getCompanyid(int addr) {
        if (featOkTst && casFeat_companyid == null)
      jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Person");
    return ll_cas.ll_getStringValue(addr, casFeatCode_companyid);
  }
  /** @generated */    
  public void setCompanyid(int addr, String v) {
        if (featOkTst && casFeat_companyid == null)
      jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Person");
    ll_cas.ll_setStringValue(addr, casFeatCode_companyid, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Person_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.Integer", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_firstname = jcas.getRequiredFeatureDE(casType, "firstname", "uima.cas.String", featOkTst);
    casFeatCode_firstname  = (null == casFeat_firstname) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_firstname).getCode();

 
    casFeat_lastname = jcas.getRequiredFeatureDE(casType, "lastname", "uima.cas.String", featOkTst);
    casFeatCode_lastname  = (null == casFeat_lastname) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_lastname).getCode();

 
    casFeat_middlename = jcas.getRequiredFeatureDE(casType, "middlename", "uima.cas.String", featOkTst);
    casFeatCode_middlename  = (null == casFeat_middlename) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_middlename).getCode();

 
    casFeat_age = jcas.getRequiredFeatureDE(casType, "age", "uima.cas.Integer", featOkTst);
    casFeatCode_age  = (null == casFeat_age) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_age).getCode();

 
    casFeat_gender = jcas.getRequiredFeatureDE(casType, "gender", "uima.cas.String", featOkTst);
    casFeatCode_gender  = (null == casFeat_gender) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gender).getCode();

 
    casFeat_education = jcas.getRequiredFeatureDE(casType, "education", "uima.cas.String", featOkTst);
    casFeatCode_education  = (null == casFeat_education) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_education).getCode();

 
    casFeat_employment = jcas.getRequiredFeatureDE(casType, "employment", "uima.cas.StringArray", featOkTst);
    casFeatCode_employment  = (null == casFeat_employment) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_employment).getCode();

 
    casFeat_suffix = jcas.getRequiredFeatureDE(casType, "suffix", "uima.cas.String", featOkTst);
    casFeatCode_suffix  = (null == casFeat_suffix) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_suffix).getCode();

 
    casFeat_companyid = jcas.getRequiredFeatureDE(casType, "companyid", "uima.cas.String", featOkTst);
    casFeatCode_companyid  = (null == casFeat_companyid) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_companyid).getCode();

  }
}



    