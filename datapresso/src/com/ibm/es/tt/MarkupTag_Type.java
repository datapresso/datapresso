
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Annotates a markup information, for example an xml tag with its according attribute value pairs
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * @generated */
public class MarkupTag_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MarkupTag_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MarkupTag_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MarkupTag(addr, MarkupTag_Type.this);
  			   MarkupTag_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MarkupTag(addr, MarkupTag_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = MarkupTag.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.MarkupTag");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.ibm.es.tt.MarkupTag");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.ibm.es.tt.MarkupTag");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_depth;
  /** @generated */
  final int     casFeatCode_depth;
  /** @generated */ 
  public int getDepth(int addr) {
        if (featOkTst && casFeat_depth == null)
      jcas.throwFeatMissing("depth", "com.ibm.es.tt.MarkupTag");
    return ll_cas.ll_getIntValue(addr, casFeatCode_depth);
  }
  /** @generated */    
  public void setDepth(int addr, int v) {
        if (featOkTst && casFeat_depth == null)
      jcas.throwFeatMissing("depth", "com.ibm.es.tt.MarkupTag");
    ll_cas.ll_setIntValue(addr, casFeatCode_depth, v);}
    
  
 
  /** @generated */
  final Feature casFeat_attributeNames;
  /** @generated */
  final int     casFeatCode_attributeNames;
  /** @generated */ 
  public int getAttributeNames(int addr) {
        if (featOkTst && casFeat_attributeNames == null)
      jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    return ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames);
  }
  /** @generated */    
  public void setAttributeNames(int addr, int v) {
        if (featOkTst && casFeat_attributeNames == null)
      jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    ll_cas.ll_setRefValue(addr, casFeatCode_attributeNames, v);}
    
   /** @generated */
  public String getAttributeNames(int addr, int i) {
        if (featOkTst && casFeat_attributeNames == null)
      jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames), i);
  }
   
  /** @generated */ 
  public void setAttributeNames(int addr, int i, String v) {
        if (featOkTst && casFeat_attributeNames == null)
      jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeNames), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_attributeValues;
  /** @generated */
  final int     casFeatCode_attributeValues;
  /** @generated */ 
  public int getAttributeValues(int addr) {
        if (featOkTst && casFeat_attributeValues == null)
      jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    return ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues);
  }
  /** @generated */    
  public void setAttributeValues(int addr, int v) {
        if (featOkTst && casFeat_attributeValues == null)
      jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    ll_cas.ll_setRefValue(addr, casFeatCode_attributeValues, v);}
    
   /** @generated */
  public String getAttributeValues(int addr, int i) {
        if (featOkTst && casFeat_attributeValues == null)
      jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues), i);
  }
   
  /** @generated */ 
  public void setAttributeValues(int addr, int i, String v) {
        if (featOkTst && casFeat_attributeValues == null)
      jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_attributeValues), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MarkupTag_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_depth = jcas.getRequiredFeatureDE(casType, "depth", "uima.cas.Integer", featOkTst);
    casFeatCode_depth  = (null == casFeat_depth) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_depth).getCode();

 
    casFeat_attributeNames = jcas.getRequiredFeatureDE(casType, "attributeNames", "uima.cas.StringArray", featOkTst);
    casFeatCode_attributeNames  = (null == casFeat_attributeNames) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_attributeNames).getCode();

 
    casFeat_attributeValues = jcas.getRequiredFeatureDE(casType, "attributeValues", "uima.cas.StringArray", featOkTst);
    casFeatCode_attributeValues  = (null == casFeat_attributeValues) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_attributeValues).getCode();

  }
}



    