
/* First created by JCasGen Sun May 31 22:03:29 EDT 2009 */
package org.apache.uima.jcas.tcas;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * @generated */
public class DocumentAnnotation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DocumentAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DocumentAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DocumentAnnotation(addr, DocumentAnnotation_Type.this);
  			   DocumentAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DocumentAnnotation(addr, DocumentAnnotation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = DocumentAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("uima.tcas.DocumentAnnotation");
 
  /** @generated */
  final Feature casFeat_language;
  /** @generated */
  final int     casFeatCode_language;
  /** @generated */ 
  public String getLanguage(int addr) {
        if (featOkTst && casFeat_language == null)
      jcas.throwFeatMissing("language", "uima.tcas.DocumentAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_language);
  }
  /** @generated */    
  public void setLanguage(int addr, String v) {
        if (featOkTst && casFeat_language == null)
      jcas.throwFeatMissing("language", "uima.tcas.DocumentAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_language, v);}
    
  
 
  /** @generated */
  final Feature casFeat_esDocumentMetaData;
  /** @generated */
  final int     casFeatCode_esDocumentMetaData;
  /** @generated */ 
  public int getEsDocumentMetaData(int addr) {
        if (featOkTst && casFeat_esDocumentMetaData == null)
      jcas.throwFeatMissing("esDocumentMetaData", "uima.tcas.DocumentAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_esDocumentMetaData);
  }
  /** @generated */    
  public void setEsDocumentMetaData(int addr, int v) {
        if (featOkTst && casFeat_esDocumentMetaData == null)
      jcas.throwFeatMissing("esDocumentMetaData", "uima.tcas.DocumentAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_esDocumentMetaData, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DocumentAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_language = jcas.getRequiredFeatureDE(casType, "language", "uima.cas.String", featOkTst);
    casFeatCode_language  = (null == casFeat_language) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_language).getCode();

 
    casFeat_esDocumentMetaData = jcas.getRequiredFeatureDE(casType, "esDocumentMetaData", "com.ibm.es.tt.DocumentMetaData", featOkTst);
    casFeatCode_esDocumentMetaData  = (null == casFeat_esDocumentMetaData) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_esDocumentMetaData).getCode();

  }
}



    