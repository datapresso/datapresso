
/* First created by JCasGen Thu Apr 19 15:11:54 EDT 2007 */
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
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * @generated */
public class Company_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Company_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Company_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Company(addr, Company_Type.this);
  			   Company_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Company(addr, Company_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Company.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.dp.edgar.uima.type.Company");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_cik;
  /** @generated */
  final int     casFeatCode_cik;
  /** @generated */ 
  public String getCik(int addr) {
        if (featOkTst && casFeat_cik == null)
      jcas.throwFeatMissing("cik", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_cik);
  }
  /** @generated */    
  public void setCik(int addr, String v) {
        if (featOkTst && casFeat_cik == null)
      jcas.throwFeatMissing("cik", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_cik, v);}
    
  
 
  /** @generated */
  final Feature casFeat_street;
  /** @generated */
  final int     casFeatCode_street;
  /** @generated */ 
  public String getStreet(int addr) {
        if (featOkTst && casFeat_street == null)
      jcas.throwFeatMissing("street", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_street);
  }
  /** @generated */    
  public void setStreet(int addr, String v) {
        if (featOkTst && casFeat_street == null)
      jcas.throwFeatMissing("street", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_street, v);}
    
  
 
  /** @generated */
  final Feature casFeat_city;
  /** @generated */
  final int     casFeatCode_city;
  /** @generated */ 
  public String getCity(int addr) {
        if (featOkTst && casFeat_city == null)
      jcas.throwFeatMissing("city", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_city);
  }
  /** @generated */    
  public void setCity(int addr, String v) {
        if (featOkTst && casFeat_city == null)
      jcas.throwFeatMissing("city", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_city, v);}
    
  
 
  /** @generated */
  final Feature casFeat_state;
  /** @generated */
  final int     casFeatCode_state;
  /** @generated */ 
  public String getState(int addr) {
        if (featOkTst && casFeat_state == null)
      jcas.throwFeatMissing("state", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_state);
  }
  /** @generated */    
  public void setState(int addr, String v) {
        if (featOkTst && casFeat_state == null)
      jcas.throwFeatMissing("state", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_state, v);}
    
  
 
  /** @generated */
  final Feature casFeat_country;
  /** @generated */
  final int     casFeatCode_country;
  /** @generated */ 
  public String getCountry(int addr) {
        if (featOkTst && casFeat_country == null)
      jcas.throwFeatMissing("country", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_country);
  }
  /** @generated */    
  public void setCountry(int addr, String v) {
        if (featOkTst && casFeat_country == null)
      jcas.throwFeatMissing("country", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_country, v);}
    
  
 
  /** @generated */
  final Feature casFeat_zip;
  /** @generated */
  final int     casFeatCode_zip;
  /** @generated */ 
  public String getZip(int addr) {
        if (featOkTst && casFeat_zip == null)
      jcas.throwFeatMissing("zip", "com.dp.edgar.uima.type.Company");
    return ll_cas.ll_getStringValue(addr, casFeatCode_zip);
  }
  /** @generated */    
  public void setZip(int addr, String v) {
        if (featOkTst && casFeat_zip == null)
      jcas.throwFeatMissing("zip", "com.dp.edgar.uima.type.Company");
    ll_cas.ll_setStringValue(addr, casFeatCode_zip, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Company_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_cik = jcas.getRequiredFeatureDE(casType, "cik", "uima.cas.String", featOkTst);
    casFeatCode_cik  = (null == casFeat_cik) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_cik).getCode();

 
    casFeat_street = jcas.getRequiredFeatureDE(casType, "street", "uima.cas.String", featOkTst);
    casFeatCode_street  = (null == casFeat_street) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_street).getCode();

 
    casFeat_city = jcas.getRequiredFeatureDE(casType, "city", "uima.cas.String", featOkTst);
    casFeatCode_city  = (null == casFeat_city) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_city).getCode();

 
    casFeat_state = jcas.getRequiredFeatureDE(casType, "state", "uima.cas.String", featOkTst);
    casFeatCode_state  = (null == casFeat_state) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_state).getCode();

 
    casFeat_country = jcas.getRequiredFeatureDE(casType, "country", "uima.cas.String", featOkTst);
    casFeatCode_country  = (null == casFeat_country) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_country).getCode();

 
    casFeat_zip = jcas.getRequiredFeatureDE(casType, "zip", "uima.cas.String", featOkTst);
    casFeatCode_zip  = (null == casFeat_zip) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_zip).getCode();

  }
}



    