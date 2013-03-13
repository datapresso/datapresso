

/* First created by JCasGen Sun May 31 22:03:30 EDT 2009 */
package com.ibm.es.tt;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** Common field parameters for OmniFind
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * XML source: C:/workspace/datapresso/EdgarProcessor/desc/Compensation_TAE.xml
 * @generated */
public class CommonFieldParameters extends TOP {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(CommonFieldParameters.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CommonFieldParameters() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public CommonFieldParameters(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public CommonFieldParameters(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: searchable

  /** getter for searchable - gets flag for searchable, default is true
   * @generated */
  public int getSearchable() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_searchable == null)
      jcasType.jcas.throwFeatMissing("searchable", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_searchable);}
    
  /** setter for searchable - sets flag for searchable, default is true 
   * @generated */
  public void setSearchable(int v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_searchable == null)
      jcasType.jcas.throwFeatMissing("searchable", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_searchable, v);}    
   
    
  //*--------------*
  //* Feature: fieldSearchable

  /** getter for fieldSearchable - gets flag for fieldsearchable, default is true
   * @generated */
  public int getFieldSearchable() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_fieldSearchable == null)
      jcasType.jcas.throwFeatMissing("fieldSearchable", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_fieldSearchable);}
    
  /** setter for fieldSearchable - sets flag for fieldsearchable, default is true 
   * @generated */
  public void setFieldSearchable(int v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_fieldSearchable == null)
      jcasType.jcas.throwFeatMissing("fieldSearchable", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_fieldSearchable, v);}    
   
    
  //*--------------*
  //* Feature: parametric

  /** getter for parametric - gets flag for parametric search, default is false
   * @generated */
  public int getParametric() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_parametric == null)
      jcasType.jcas.throwFeatMissing("parametric", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_parametric);}
    
  /** setter for parametric - sets flag for parametric search, default is false 
   * @generated */
  public void setParametric(int v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_parametric == null)
      jcasType.jcas.throwFeatMissing("parametric", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_parametric, v);}    
   
    
  //*--------------*
  //* Feature: showInSearchResult

  /** getter for showInSearchResult - gets flag for showing the annotated data in the search result details, default is false
   * @generated */
  public int getShowInSearchResult() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_showInSearchResult == null)
      jcasType.jcas.throwFeatMissing("showInSearchResult", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_showInSearchResult);}
    
  /** setter for showInSearchResult - sets flag for showing the annotated data in the search result details, default is false 
   * @generated */
  public void setShowInSearchResult(int v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_showInSearchResult == null)
      jcasType.jcas.throwFeatMissing("showInSearchResult", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_showInSearchResult, v);}    
   
    
  //*--------------*
  //* Feature: resolveConflict

  /** getter for resolveConflict - gets flag for meta data resolve conflict: MetadataPreferred, ContentPreferred, and Coexist, default is ContentPreferred
   * @generated */
  public String getResolveConflict() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_resolveConflict == null)
      jcasType.jcas.throwFeatMissing("resolveConflict", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_resolveConflict);}
    
  /** setter for resolveConflict - sets flag for meta data resolve conflict: MetadataPreferred, ContentPreferred, and Coexist, default is ContentPreferred 
   * @generated */
  public void setResolveConflict(String v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_resolveConflict == null)
      jcasType.jcas.throwFeatMissing("resolveConflict", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setStringValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_resolveConflict, v);}    
   
    
  //*--------------*
  //* Feature: exactMatch

  /** getter for exactMatch - gets flag for exact matching of a field, default is false
   * @generated */
  public int getExactMatch() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_exactMatch == null)
      jcasType.jcas.throwFeatMissing("exactMatch", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_exactMatch);}
    
  /** setter for exactMatch - sets flag for exact matching of a field, default is false 
   * @generated */
  public void setExactMatch(int v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_exactMatch == null)
      jcasType.jcas.throwFeatMissing("exactMatch", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_exactMatch, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets Name of the field
   * @generated */
  public String getName() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets Name of the field 
   * @generated */
  public void setName(String v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setStringValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: sortable

  /** getter for sortable - gets 
   * @generated */
  public int getSortable() {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_sortable == null)
      jcasType.jcas.throwFeatMissing("sortable", "com.ibm.es.tt.CommonFieldParameters");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_sortable);}
    
  /** setter for sortable - sets  
   * @generated */
  public void setSortable(int v) {
    if (CommonFieldParameters_Type.featOkTst && ((CommonFieldParameters_Type)jcasType).casFeat_sortable == null)
      jcasType.jcas.throwFeatMissing("sortable", "com.ibm.es.tt.CommonFieldParameters");
    jcasType.ll_cas.ll_setIntValue(addr, ((CommonFieldParameters_Type)jcasType).casFeatCode_sortable, v);}    
  }

    