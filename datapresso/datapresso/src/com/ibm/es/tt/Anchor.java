

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Anchor annotation fot the anchor text and its target uri as feature value
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class Anchor extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Anchor.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Anchor() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Anchor(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Anchor(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Anchor(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: uri

  /** getter for uri - gets 
   * @generated */
  public String getUri() {
    if (Anchor_Type.featOkTst && ((Anchor_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "com.ibm.es.tt.Anchor");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Anchor_Type)jcasType).casFeatCode_uri);}
    
  /** setter for uri - sets  
   * @generated */
  public void setUri(String v) {
    if (Anchor_Type.featOkTst && ((Anchor_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "com.ibm.es.tt.Anchor");
    jcasType.ll_cas.ll_setStringValue(addr, ((Anchor_Type)jcasType).casFeatCode_uri, v);}    
  }

    