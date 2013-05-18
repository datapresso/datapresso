
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

/** Content Field Annotation
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * @generated */
public class ContentField_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ContentField_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ContentField_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ContentField(addr, ContentField_Type.this);
  			   ContentField_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ContentField(addr, ContentField_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = ContentField.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.ContentField");
 
  /** @generated */
  final Feature casFeat_parameters;
  /** @generated */
  final int     casFeatCode_parameters;
  /** @generated */ 
  public int getParameters(int addr) {
        if (featOkTst && casFeat_parameters == null)
      jcas.throwFeatMissing("parameters", "com.ibm.es.tt.ContentField");
    return ll_cas.ll_getRefValue(addr, casFeatCode_parameters);
  }
  /** @generated */    
  public void setParameters(int addr, int v) {
        if (featOkTst && casFeat_parameters == null)
      jcas.throwFeatMissing("parameters", "com.ibm.es.tt.ContentField");
    ll_cas.ll_setRefValue(addr, casFeatCode_parameters, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ContentField_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_parameters = jcas.getRequiredFeatureDE(casType, "parameters", "com.ibm.es.tt.CommonFieldParameters", featOkTst);
    casFeatCode_parameters  = (null == casFeat_parameters) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parameters).getCode();

  }
}



    