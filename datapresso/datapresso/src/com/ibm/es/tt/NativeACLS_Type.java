
/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** 
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * @generated */
public class NativeACLS_Type extends TOP_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NativeACLS_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NativeACLS_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NativeACLS(addr, NativeACLS_Type.this);
  			   NativeACLS_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NativeACLS(addr, NativeACLS_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = NativeACLS.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.NativeACLS");
 
  /** @generated */
  final Feature casFeat_domain;
  /** @generated */
  final int     casFeatCode_domain;
  /** @generated */ 
  public String getDomain(int addr) {
        if (featOkTst && casFeat_domain == null)
      jcas.throwFeatMissing("domain", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getStringValue(addr, casFeatCode_domain);
  }
  /** @generated */    
  public void setDomain(int addr, String v) {
        if (featOkTst && casFeat_domain == null)
      jcas.throwFeatMissing("domain", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setStringValue(addr, casFeatCode_domain, v);}
    
  
 
  /** @generated */
  final Feature casFeat_level1allow;
  /** @generated */
  final int     casFeatCode_level1allow;
  /** @generated */ 
  public int getLevel1allow(int addr) {
        if (featOkTst && casFeat_level1allow == null)
      jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getRefValue(addr, casFeatCode_level1allow);
  }
  /** @generated */    
  public void setLevel1allow(int addr, int v) {
        if (featOkTst && casFeat_level1allow == null)
      jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setRefValue(addr, casFeatCode_level1allow, v);}
    
   /** @generated */
  public String getLevel1allow(int addr, int i) {
        if (featOkTst && casFeat_level1allow == null)
      jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1allow), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level1allow), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1allow), i);
  }
   
  /** @generated */ 
  public void setLevel1allow(int addr, int i, String v) {
        if (featOkTst && casFeat_level1allow == null)
      jcas.throwFeatMissing("level1allow", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1allow), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level1allow), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1allow), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_level1deny;
  /** @generated */
  final int     casFeatCode_level1deny;
  /** @generated */ 
  public int getLevel1deny(int addr) {
        if (featOkTst && casFeat_level1deny == null)
      jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getRefValue(addr, casFeatCode_level1deny);
  }
  /** @generated */    
  public void setLevel1deny(int addr, int v) {
        if (featOkTst && casFeat_level1deny == null)
      jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setRefValue(addr, casFeatCode_level1deny, v);}
    
   /** @generated */
  public String getLevel1deny(int addr, int i) {
        if (featOkTst && casFeat_level1deny == null)
      jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1deny), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level1deny), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1deny), i);
  }
   
  /** @generated */ 
  public void setLevel1deny(int addr, int i, String v) {
        if (featOkTst && casFeat_level1deny == null)
      jcas.throwFeatMissing("level1deny", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1deny), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level1deny), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level1deny), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_level2allow;
  /** @generated */
  final int     casFeatCode_level2allow;
  /** @generated */ 
  public int getLevel2allow(int addr) {
        if (featOkTst && casFeat_level2allow == null)
      jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getRefValue(addr, casFeatCode_level2allow);
  }
  /** @generated */    
  public void setLevel2allow(int addr, int v) {
        if (featOkTst && casFeat_level2allow == null)
      jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setRefValue(addr, casFeatCode_level2allow, v);}
    
   /** @generated */
  public String getLevel2allow(int addr, int i) {
        if (featOkTst && casFeat_level2allow == null)
      jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2allow), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level2allow), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2allow), i);
  }
   
  /** @generated */ 
  public void setLevel2allow(int addr, int i, String v) {
        if (featOkTst && casFeat_level2allow == null)
      jcas.throwFeatMissing("level2allow", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2allow), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level2allow), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2allow), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_level2deny;
  /** @generated */
  final int     casFeatCode_level2deny;
  /** @generated */ 
  public int getLevel2deny(int addr) {
        if (featOkTst && casFeat_level2deny == null)
      jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getRefValue(addr, casFeatCode_level2deny);
  }
  /** @generated */    
  public void setLevel2deny(int addr, int v) {
        if (featOkTst && casFeat_level2deny == null)
      jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setRefValue(addr, casFeatCode_level2deny, v);}
    
   /** @generated */
  public String getLevel2deny(int addr, int i) {
        if (featOkTst && casFeat_level2deny == null)
      jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2deny), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level2deny), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2deny), i);
  }
   
  /** @generated */ 
  public void setLevel2deny(int addr, int i, String v) {
        if (featOkTst && casFeat_level2deny == null)
      jcas.throwFeatMissing("level2deny", "com.ibm.es.tt.NativeACLS");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2deny), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_level2deny), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_level2deny), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_impersonate;
  /** @generated */
  final int     casFeatCode_impersonate;
  /** @generated */ 
  public int getImpersonate(int addr) {
        if (featOkTst && casFeat_impersonate == null)
      jcas.throwFeatMissing("impersonate", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getIntValue(addr, casFeatCode_impersonate);
  }
  /** @generated */    
  public void setImpersonate(int addr, int v) {
        if (featOkTst && casFeat_impersonate == null)
      jcas.throwFeatMissing("impersonate", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setIntValue(addr, casFeatCode_impersonate, v);}
    
  
 
  /** @generated */
  final Feature casFeat_protocol;
  /** @generated */
  final int     casFeatCode_protocol;
  /** @generated */ 
  public String getProtocol(int addr) {
        if (featOkTst && casFeat_protocol == null)
      jcas.throwFeatMissing("protocol", "com.ibm.es.tt.NativeACLS");
    return ll_cas.ll_getStringValue(addr, casFeatCode_protocol);
  }
  /** @generated */    
  public void setProtocol(int addr, String v) {
        if (featOkTst && casFeat_protocol == null)
      jcas.throwFeatMissing("protocol", "com.ibm.es.tt.NativeACLS");
    ll_cas.ll_setStringValue(addr, casFeatCode_protocol, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public NativeACLS_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_domain = jcas.getRequiredFeatureDE(casType, "domain", "uima.cas.String", featOkTst);
    casFeatCode_domain  = (null == casFeat_domain) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_domain).getCode();

 
    casFeat_level1allow = jcas.getRequiredFeatureDE(casType, "level1allow", "uima.cas.StringArray", featOkTst);
    casFeatCode_level1allow  = (null == casFeat_level1allow) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_level1allow).getCode();

 
    casFeat_level1deny = jcas.getRequiredFeatureDE(casType, "level1deny", "uima.cas.StringArray", featOkTst);
    casFeatCode_level1deny  = (null == casFeat_level1deny) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_level1deny).getCode();

 
    casFeat_level2allow = jcas.getRequiredFeatureDE(casType, "level2allow", "uima.cas.StringArray", featOkTst);
    casFeatCode_level2allow  = (null == casFeat_level2allow) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_level2allow).getCode();

 
    casFeat_level2deny = jcas.getRequiredFeatureDE(casType, "level2deny", "uima.cas.StringArray", featOkTst);
    casFeatCode_level2deny  = (null == casFeat_level2deny) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_level2deny).getCode();

 
    casFeat_impersonate = jcas.getRequiredFeatureDE(casType, "impersonate", "uima.cas.Integer", featOkTst);
    casFeatCode_impersonate  = (null == casFeat_impersonate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_impersonate).getCode();

 
    casFeat_protocol = jcas.getRequiredFeatureDE(casType, "protocol", "uima.cas.String", featOkTst);
    casFeatCode_protocol  = (null == casFeat_protocol) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_protocol).getCode();

  }
}



    