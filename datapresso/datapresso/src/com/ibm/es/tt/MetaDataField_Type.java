
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

/** Data of a meta field. The text data of the meta field are not part of the document content,  but is stored in the feature "text"
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * @generated */
public class MetaDataField_Type extends TOP_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MetaDataField_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MetaDataField_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MetaDataField(addr, MetaDataField_Type.this);
  			   MetaDataField_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MetaDataField(addr, MetaDataField_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = MetaDataField.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.MetaDataField");
 
  /** @generated */
  final Feature casFeat_parameters;
  /** @generated */
  final int     casFeatCode_parameters;
  /** @generated */ 
  public int getParameters(int addr) {
        if (featOkTst && casFeat_parameters == null)
      jcas.throwFeatMissing("parameters", "com.ibm.es.tt.MetaDataField");
    return ll_cas.ll_getRefValue(addr, casFeatCode_parameters);
  }
  /** @generated */    
  public void setParameters(int addr, int v) {
        if (featOkTst && casFeat_parameters == null)
      jcas.throwFeatMissing("parameters", "com.ibm.es.tt.MetaDataField");
    ll_cas.ll_setRefValue(addr, casFeatCode_parameters, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "com.ibm.es.tt.MetaDataField");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "com.ibm.es.tt.MetaDataField");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MetaDataField_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_parameters = jcas.getRequiredFeatureDE(casType, "parameters", "com.ibm.es.tt.CommonFieldParameters", featOkTst);
    casFeatCode_parameters  = (null == casFeat_parameters) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parameters).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

  }
}



    