
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

/** Common field parameters for OmniFind
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * @generated */
public class CommonFieldParameters_Type extends TOP_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CommonFieldParameters_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CommonFieldParameters_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CommonFieldParameters(addr, CommonFieldParameters_Type.this);
  			   CommonFieldParameters_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CommonFieldParameters(addr, CommonFieldParameters_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = CommonFieldParameters.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.CommonFieldParameters");
 
  /** @generated */
  final Feature casFeat_searchable;
  /** @generated */
  final int     casFeatCode_searchable;
  /** @generated */ 
  public int getSearchable(int addr) {
        if (featOkTst && casFeat_searchable == null)
      jcas.throwFeatMissing("searchable", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getIntValue(addr, casFeatCode_searchable);
  }
  /** @generated */    
  public void setSearchable(int addr, int v) {
        if (featOkTst && casFeat_searchable == null)
      jcas.throwFeatMissing("searchable", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setIntValue(addr, casFeatCode_searchable, v);}
    
  
 
  /** @generated */
  final Feature casFeat_fieldSearchable;
  /** @generated */
  final int     casFeatCode_fieldSearchable;
  /** @generated */ 
  public int getFieldSearchable(int addr) {
        if (featOkTst && casFeat_fieldSearchable == null)
      jcas.throwFeatMissing("fieldSearchable", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getIntValue(addr, casFeatCode_fieldSearchable);
  }
  /** @generated */    
  public void setFieldSearchable(int addr, int v) {
        if (featOkTst && casFeat_fieldSearchable == null)
      jcas.throwFeatMissing("fieldSearchable", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setIntValue(addr, casFeatCode_fieldSearchable, v);}
    
  
 
  /** @generated */
  final Feature casFeat_parametric;
  /** @generated */
  final int     casFeatCode_parametric;
  /** @generated */ 
  public int getParametric(int addr) {
        if (featOkTst && casFeat_parametric == null)
      jcas.throwFeatMissing("parametric", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getIntValue(addr, casFeatCode_parametric);
  }
  /** @generated */    
  public void setParametric(int addr, int v) {
        if (featOkTst && casFeat_parametric == null)
      jcas.throwFeatMissing("parametric", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setIntValue(addr, casFeatCode_parametric, v);}
    
  
 
  /** @generated */
  final Feature casFeat_showInSearchResult;
  /** @generated */
  final int     casFeatCode_showInSearchResult;
  /** @generated */ 
  public int getShowInSearchResult(int addr) {
        if (featOkTst && casFeat_showInSearchResult == null)
      jcas.throwFeatMissing("showInSearchResult", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getIntValue(addr, casFeatCode_showInSearchResult);
  }
  /** @generated */    
  public void setShowInSearchResult(int addr, int v) {
        if (featOkTst && casFeat_showInSearchResult == null)
      jcas.throwFeatMissing("showInSearchResult", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setIntValue(addr, casFeatCode_showInSearchResult, v);}
    
  
 
  /** @generated */
  final Feature casFeat_resolveConflict;
  /** @generated */
  final int     casFeatCode_resolveConflict;
  /** @generated */ 
  public String getResolveConflict(int addr) {
        if (featOkTst && casFeat_resolveConflict == null)
      jcas.throwFeatMissing("resolveConflict", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getStringValue(addr, casFeatCode_resolveConflict);
  }
  /** @generated */    
  public void setResolveConflict(int addr, String v) {
        if (featOkTst && casFeat_resolveConflict == null)
      jcas.throwFeatMissing("resolveConflict", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setStringValue(addr, casFeatCode_resolveConflict, v);}
    
  
 
  /** @generated */
  final Feature casFeat_exactMatch;
  /** @generated */
  final int     casFeatCode_exactMatch;
  /** @generated */ 
  public int getExactMatch(int addr) {
        if (featOkTst && casFeat_exactMatch == null)
      jcas.throwFeatMissing("exactMatch", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getIntValue(addr, casFeatCode_exactMatch);
  }
  /** @generated */    
  public void setExactMatch(int addr, int v) {
        if (featOkTst && casFeat_exactMatch == null)
      jcas.throwFeatMissing("exactMatch", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setIntValue(addr, casFeatCode_exactMatch, v);}
    
  
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sortable;
  /** @generated */
  final int     casFeatCode_sortable;
  /** @generated */ 
  public int getSortable(int addr) {
        if (featOkTst && casFeat_sortable == null)
      jcas.throwFeatMissing("sortable", "com.ibm.es.tt.CommonFieldParameters");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sortable);
  }
  /** @generated */    
  public void setSortable(int addr, int v) {
        if (featOkTst && casFeat_sortable == null)
      jcas.throwFeatMissing("sortable", "com.ibm.es.tt.CommonFieldParameters");
    ll_cas.ll_setIntValue(addr, casFeatCode_sortable, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public CommonFieldParameters_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_searchable = jcas.getRequiredFeatureDE(casType, "searchable", "uima.cas.Integer", featOkTst);
    casFeatCode_searchable  = (null == casFeat_searchable) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_searchable).getCode();

 
    casFeat_fieldSearchable = jcas.getRequiredFeatureDE(casType, "fieldSearchable", "uima.cas.Integer", featOkTst);
    casFeatCode_fieldSearchable  = (null == casFeat_fieldSearchable) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_fieldSearchable).getCode();

 
    casFeat_parametric = jcas.getRequiredFeatureDE(casType, "parametric", "uima.cas.Integer", featOkTst);
    casFeatCode_parametric  = (null == casFeat_parametric) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parametric).getCode();

 
    casFeat_showInSearchResult = jcas.getRequiredFeatureDE(casType, "showInSearchResult", "uima.cas.Integer", featOkTst);
    casFeatCode_showInSearchResult  = (null == casFeat_showInSearchResult) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_showInSearchResult).getCode();

 
    casFeat_resolveConflict = jcas.getRequiredFeatureDE(casType, "resolveConflict", "uima.cas.String", featOkTst);
    casFeatCode_resolveConflict  = (null == casFeat_resolveConflict) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_resolveConflict).getCode();

 
    casFeat_exactMatch = jcas.getRequiredFeatureDE(casType, "exactMatch", "uima.cas.Integer", featOkTst);
    casFeatCode_exactMatch  = (null == casFeat_exactMatch) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_exactMatch).getCode();

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_sortable = jcas.getRequiredFeatureDE(casType, "sortable", "uima.cas.Integer", featOkTst);
    casFeatCode_sortable  = (null == casFeat_sortable) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sortable).getCode();

  }
}



    