

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.cas.StringArray;


/** Annotates a markup information, for example an xml tag with its according attribute value pairs
 * Updated by JCasGen Sat Jun 20 14:35:53 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class MarkupTag extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(MarkupTag.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected MarkupTag() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MarkupTag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MarkupTag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public MarkupTag(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.ibm.es.tt.MarkupTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.ibm.es.tt.MarkupTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: depth

  /** getter for depth - gets 
   * @generated */
  public int getDepth() {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_depth == null)
      jcasType.jcas.throwFeatMissing("depth", "com.ibm.es.tt.MarkupTag");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_depth);}
    
  /** setter for depth - sets  
   * @generated */
  public void setDepth(int v) {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_depth == null)
      jcasType.jcas.throwFeatMissing("depth", "com.ibm.es.tt.MarkupTag");
    jcasType.ll_cas.ll_setIntValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_depth, v);}    
   
    
  //*--------------*
  //* Feature: attributeNames

  /** getter for attributeNames - gets 
   * @generated */
  public StringArray getAttributeNames() {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeNames == null)
      jcasType.jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeNames)));}
    
  /** setter for attributeNames - sets  
   * @generated */
  public void setAttributeNames(StringArray v) {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeNames == null)
      jcasType.jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    jcasType.ll_cas.ll_setRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeNames, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for attributeNames - gets an indexed value - 
   * @generated */
  public String getAttributeNames(int i) {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeNames == null)
      jcasType.jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeNames), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeNames), i);}

  /** indexed setter for attributeNames - sets an indexed value - 
   * @generated */
  public void setAttributeNames(int i, String v) { 
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeNames == null)
      jcasType.jcas.throwFeatMissing("attributeNames", "com.ibm.es.tt.MarkupTag");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeNames), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeNames), i, v);}
   
    
  //*--------------*
  //* Feature: attributeValues

  /** getter for attributeValues - gets 
   * @generated */
  public StringArray getAttributeValues() {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeValues == null)
      jcasType.jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeValues)));}
    
  /** setter for attributeValues - sets  
   * @generated */
  public void setAttributeValues(StringArray v) {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeValues == null)
      jcasType.jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    jcasType.ll_cas.ll_setRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeValues, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for attributeValues - gets an indexed value - 
   * @generated */
  public String getAttributeValues(int i) {
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeValues == null)
      jcasType.jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeValues), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeValues), i);}

  /** indexed setter for attributeValues - sets an indexed value - 
   * @generated */
  public void setAttributeValues(int i, String v) { 
    if (MarkupTag_Type.featOkTst && ((MarkupTag_Type)jcasType).casFeat_attributeValues == null)
      jcasType.jcas.throwFeatMissing("attributeValues", "com.ibm.es.tt.MarkupTag");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeValues), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((MarkupTag_Type)jcasType).casFeatCode_attributeValues), i, v);}
  }

    