
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

/** 
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * @generated */
public class Fragment_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Fragment_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Fragment_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Fragment(addr, Fragment_Type.this);
  			   Fragment_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Fragment(addr, Fragment_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Fragment.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.Fragment");
 
  /** @generated */
  final Feature casFeat_tokenType;
  /** @generated */
  final int     casFeatCode_tokenType;
  /** @generated */ 
  public int getTokenType(int addr) {
        if (featOkTst && casFeat_tokenType == null)
      jcas.throwFeatMissing("tokenType", "com.ibm.es.tt.Fragment");
    return ll_cas.ll_getIntValue(addr, casFeatCode_tokenType);
  }
  /** @generated */    
  public void setTokenType(int addr, int v) {
        if (featOkTst && casFeat_tokenType == null)
      jcas.throwFeatMissing("tokenType", "com.ibm.es.tt.Fragment");
    ll_cas.ll_setIntValue(addr, casFeatCode_tokenType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Fragment_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tokenType = jcas.getRequiredFeatureDE(casType, "tokenType", "uima.cas.Integer", featOkTst);
    casFeatCode_tokenType  = (null == casFeat_tokenType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenType).getCode();

  }
}



    