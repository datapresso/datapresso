
/* First created by JCasGen Thu Apr 19 15:11:15 EDT 2007 */
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
 * Updated by JCasGen Sun Jun 28 10:32:31 EDT 2009
 * @generated */
public class Compensation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Compensation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Compensation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Compensation(addr, Compensation_Type.this);
  			   Compensation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Compensation(addr, Compensation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Compensation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.dp.edgar.uima.type.Compensation");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_position;
  /** @generated */
  final int     casFeatCode_position;
  /** @generated */ 
  public String getPosition(int addr) {
        if (featOkTst && casFeat_position == null)
      jcas.throwFeatMissing("position", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_position);
  }
  /** @generated */    
  public void setPosition(int addr, String v) {
        if (featOkTst && casFeat_position == null)
      jcas.throwFeatMissing("position", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setStringValue(addr, casFeatCode_position, v);}
    
  
 
  /** @generated */
  final Feature casFeat_year;
  /** @generated */
  final int     casFeatCode_year;
  /** @generated */ 
  public int getYear(int addr) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_year);
  }
  /** @generated */    
  public void setYear(int addr, int v) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setIntValue(addr, casFeatCode_year, v);}
    
  
 
  /** @generated */
  final Feature casFeat_salary;
  /** @generated */
  final int     casFeatCode_salary;
  /** @generated */ 
  public float getSalary(int addr) {
        if (featOkTst && casFeat_salary == null)
      jcas.throwFeatMissing("salary", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_salary);
  }
  /** @generated */    
  public void setSalary(int addr, float v) {
        if (featOkTst && casFeat_salary == null)
      jcas.throwFeatMissing("salary", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setFloatValue(addr, casFeatCode_salary, v);}
    
  
 
  /** @generated */
  final Feature casFeat_bonus;
  /** @generated */
  final int     casFeatCode_bonus;
  /** @generated */ 
  public float getBonus(int addr) {
        if (featOkTst && casFeat_bonus == null)
      jcas.throwFeatMissing("bonus", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_bonus);
  }
  /** @generated */    
  public void setBonus(int addr, float v) {
        if (featOkTst && casFeat_bonus == null)
      jcas.throwFeatMissing("bonus", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setFloatValue(addr, casFeatCode_bonus, v);}
    
  
 
  /** @generated */
  final Feature casFeat_options;
  /** @generated */
  final int     casFeatCode_options;
  /** @generated */ 
  public float getOptions(int addr) {
        if (featOkTst && casFeat_options == null)
      jcas.throwFeatMissing("options", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_options);
  }
  /** @generated */    
  public void setOptions(int addr, float v) {
        if (featOkTst && casFeat_options == null)
      jcas.throwFeatMissing("options", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setFloatValue(addr, casFeatCode_options, v);}
    
  
 
  /** @generated */
  final Feature casFeat_all;
  /** @generated */
  final int     casFeatCode_all;
  /** @generated */ 
  public float getAll(int addr) {
        if (featOkTst && casFeat_all == null)
      jcas.throwFeatMissing("all", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_all);
  }
  /** @generated */    
  public void setAll(int addr, float v) {
        if (featOkTst && casFeat_all == null)
      jcas.throwFeatMissing("all", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setFloatValue(addr, casFeatCode_all, v);}
    
  
 
  /** @generated */
  final Feature casFeat_companyid;
  /** @generated */
  final int     casFeatCode_companyid;
  /** @generated */ 
  public String getCompanyid(int addr) {
        if (featOkTst && casFeat_companyid == null)
      jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_companyid);
  }
  /** @generated */    
  public void setCompanyid(int addr, String v) {
        if (featOkTst && casFeat_companyid == null)
      jcas.throwFeatMissing("companyid", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setStringValue(addr, casFeatCode_companyid, v);}
    
  
 
  /** @generated */
  final Feature casFeat_personid;
  /** @generated */
  final int     casFeatCode_personid;
  /** @generated */ 
  public long getPersonid(int addr) {
        if (featOkTst && casFeat_personid == null)
      jcas.throwFeatMissing("personid", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getLongValue(addr, casFeatCode_personid);
  }
  /** @generated */    
  public void setPersonid(int addr, long v) {
        if (featOkTst && casFeat_personid == null)
      jcas.throwFeatMissing("personid", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setLongValue(addr, casFeatCode_personid, v);}
    
  
 
  /** @generated */
  final Feature casFeat_other;
  /** @generated */
  final int     casFeatCode_other;
  /** @generated */ 
  public float getOther(int addr) {
        if (featOkTst && casFeat_other == null)
      jcas.throwFeatMissing("other", "com.dp.edgar.uima.type.Compensation");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_other);
  }
  /** @generated */    
  public void setOther(int addr, float v) {
        if (featOkTst && casFeat_other == null)
      jcas.throwFeatMissing("other", "com.dp.edgar.uima.type.Compensation");
    ll_cas.ll_setFloatValue(addr, casFeatCode_other, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Compensation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_position = jcas.getRequiredFeatureDE(casType, "position", "uima.cas.String", featOkTst);
    casFeatCode_position  = (null == casFeat_position) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_position).getCode();

 
    casFeat_year = jcas.getRequiredFeatureDE(casType, "year", "uima.cas.Integer", featOkTst);
    casFeatCode_year  = (null == casFeat_year) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_year).getCode();

 
    casFeat_salary = jcas.getRequiredFeatureDE(casType, "salary", "uima.cas.Float", featOkTst);
    casFeatCode_salary  = (null == casFeat_salary) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_salary).getCode();

 
    casFeat_bonus = jcas.getRequiredFeatureDE(casType, "bonus", "uima.cas.Float", featOkTst);
    casFeatCode_bonus  = (null == casFeat_bonus) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_bonus).getCode();

 
    casFeat_options = jcas.getRequiredFeatureDE(casType, "options", "uima.cas.Float", featOkTst);
    casFeatCode_options  = (null == casFeat_options) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_options).getCode();

 
    casFeat_all = jcas.getRequiredFeatureDE(casType, "all", "uima.cas.Float", featOkTst);
    casFeatCode_all  = (null == casFeat_all) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_all).getCode();

 
    casFeat_companyid = jcas.getRequiredFeatureDE(casType, "companyid", "uima.cas.String", featOkTst);
    casFeatCode_companyid  = (null == casFeat_companyid) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_companyid).getCode();

 
    casFeat_personid = jcas.getRequiredFeatureDE(casType, "personid", "uima.cas.Long", featOkTst);
    casFeatCode_personid  = (null == casFeat_personid) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_personid).getCode();

 
    casFeat_other = jcas.getRequiredFeatureDE(casType, "other", "uima.cas.Float", featOkTst);
    casFeatCode_other  = (null == casFeat_other) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_other).getCode();

  }
}



    