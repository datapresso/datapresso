
/* First created by JCasGen Sun May 31 22:03:29 EDT 2009 */
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

/** Document meta data specific for omnifind. The feature structure will  connected to the DocumentAnnotation
 * Updated by JCasGen Sat Jun 20 14:35:52 EDT 2009
 * @generated */
public class DocumentMetaData_Type extends TOP_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DocumentMetaData_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DocumentMetaData_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DocumentMetaData(addr, DocumentMetaData_Type.this);
  			   DocumentMetaData_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DocumentMetaData(addr, DocumentMetaData_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = DocumentMetaData.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.ibm.es.tt.DocumentMetaData");
 
  /** @generated */
  final Feature casFeat_crawlerId;
  /** @generated */
  final int     casFeatCode_crawlerId;
  /** @generated */ 
  public String getCrawlerId(int addr) {
        if (featOkTst && casFeat_crawlerId == null)
      jcas.throwFeatMissing("crawlerId", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_crawlerId);
  }
  /** @generated */    
  public void setCrawlerId(int addr, String v) {
        if (featOkTst && casFeat_crawlerId == null)
      jcas.throwFeatMissing("crawlerId", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_crawlerId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dataSource;
  /** @generated */
  final int     casFeatCode_dataSource;
  /** @generated */ 
  public String getDataSource(int addr) {
        if (featOkTst && casFeat_dataSource == null)
      jcas.throwFeatMissing("dataSource", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_dataSource);
  }
  /** @generated */    
  public void setDataSource(int addr, String v) {
        if (featOkTst && casFeat_dataSource == null)
      jcas.throwFeatMissing("dataSource", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_dataSource, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dataSourceName;
  /** @generated */
  final int     casFeatCode_dataSourceName;
  /** @generated */ 
  public String getDataSourceName(int addr) {
        if (featOkTst && casFeat_dataSourceName == null)
      jcas.throwFeatMissing("dataSourceName", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_dataSourceName);
  }
  /** @generated */    
  public void setDataSourceName(int addr, String v) {
        if (featOkTst && casFeat_dataSourceName == null)
      jcas.throwFeatMissing("dataSourceName", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_dataSourceName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_charset;
  /** @generated */
  final int     casFeatCode_charset;
  /** @generated */ 
  public String getCharset(int addr) {
        if (featOkTst && casFeat_charset == null)
      jcas.throwFeatMissing("charset", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_charset);
  }
  /** @generated */    
  public void setCharset(int addr, String v) {
        if (featOkTst && casFeat_charset == null)
      jcas.throwFeatMissing("charset", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_charset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_knownCharset;
  /** @generated */
  final int     casFeatCode_knownCharset;
  /** @generated */ 
  public String getKnownCharset(int addr) {
        if (featOkTst && casFeat_knownCharset == null)
      jcas.throwFeatMissing("knownCharset", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_knownCharset);
  }
  /** @generated */    
  public void setKnownCharset(int addr, String v) {
        if (featOkTst && casFeat_knownCharset == null)
      jcas.throwFeatMissing("knownCharset", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_knownCharset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_actualCharset;
  /** @generated */
  final int     casFeatCode_actualCharset;
  /** @generated */ 
  public String getActualCharset(int addr) {
        if (featOkTst && casFeat_actualCharset == null)
      jcas.throwFeatMissing("actualCharset", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_actualCharset);
  }
  /** @generated */    
  public void setActualCharset(int addr, String v) {
        if (featOkTst && casFeat_actualCharset == null)
      jcas.throwFeatMissing("actualCharset", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_actualCharset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_docType;
  /** @generated */
  final int     casFeatCode_docType;
  /** @generated */ 
  public String getDocType(int addr) {
        if (featOkTst && casFeat_docType == null)
      jcas.throwFeatMissing("docType", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_docType);
  }
  /** @generated */    
  public void setDocType(int addr, String v) {
        if (featOkTst && casFeat_docType == null)
      jcas.throwFeatMissing("docType", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_docType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_securityTokens;
  /** @generated */
  final int     casFeatCode_securityTokens;
  /** @generated */ 
  public int getSecurityTokens(int addr) {
        if (featOkTst && casFeat_securityTokens == null)
      jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens);
  }
  /** @generated */    
  public void setSecurityTokens(int addr, int v) {
        if (featOkTst && casFeat_securityTokens == null)
      jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setRefValue(addr, casFeatCode_securityTokens, v);}
    
   /** @generated */
  public String getSecurityTokens(int addr, int i) {
        if (featOkTst && casFeat_securityTokens == null)
      jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens), i);
  }
   
  /** @generated */ 
  public void setSecurityTokens(int addr, int i, String v) {
        if (featOkTst && casFeat_securityTokens == null)
      jcas.throwFeatMissing("securityTokens", "com.ibm.es.tt.DocumentMetaData");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_securityTokens), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_date;
  /** @generated */
  final int     casFeatCode_date;
  /** @generated */ 
  public String getDate(int addr) {
        if (featOkTst && casFeat_date == null)
      jcas.throwFeatMissing("date", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_date);
  }
  /** @generated */    
  public void setDate(int addr, String v) {
        if (featOkTst && casFeat_date == null)
      jcas.throwFeatMissing("date", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_date, v);}
    
  
 
  /** @generated */
  final Feature casFeat_staticScore;
  /** @generated */
  final int     casFeatCode_staticScore;
  /** @generated */ 
  public String getStaticScore(int addr) {
        if (featOkTst && casFeat_staticScore == null)
      jcas.throwFeatMissing("staticScore", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_staticScore);
  }
  /** @generated */    
  public void setStaticScore(int addr, String v) {
        if (featOkTst && casFeat_staticScore == null)
      jcas.throwFeatMissing("staticScore", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_staticScore, v);}
    
  
 
  /** @generated */
  final Feature casFeat_baseUri;
  /** @generated */
  final int     casFeatCode_baseUri;
  /** @generated */ 
  public String getBaseUri(int addr) {
        if (featOkTst && casFeat_baseUri == null)
      jcas.throwFeatMissing("baseUri", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_baseUri);
  }
  /** @generated */    
  public void setBaseUri(int addr, String v) {
        if (featOkTst && casFeat_baseUri == null)
      jcas.throwFeatMissing("baseUri", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_baseUri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_metaDataFields;
  /** @generated */
  final int     casFeatCode_metaDataFields;
  /** @generated */ 
  public int getMetaDataFields(int addr) {
        if (featOkTst && casFeat_metaDataFields == null)
      jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields);
  }
  /** @generated */    
  public void setMetaDataFields(int addr, int v) {
        if (featOkTst && casFeat_metaDataFields == null)
      jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setRefValue(addr, casFeatCode_metaDataFields, v);}
    
   /** @generated */
  public int getMetaDataFields(int addr, int i) {
        if (featOkTst && casFeat_metaDataFields == null)
      jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields), i);
  }
   
  /** @generated */ 
  public void setMetaDataFields(int addr, int i, int v) {
        if (featOkTst && casFeat_metaDataFields == null)
      jcas.throwFeatMissing("metaDataFields", "com.ibm.es.tt.DocumentMetaData");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_metaDataFields), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_redirectUrl;
  /** @generated */
  final int     casFeatCode_redirectUrl;
  /** @generated */ 
  public String getRedirectUrl(int addr) {
        if (featOkTst && casFeat_redirectUrl == null)
      jcas.throwFeatMissing("redirectUrl", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_redirectUrl);
  }
  /** @generated */    
  public void setRedirectUrl(int addr, String v) {
        if (featOkTst && casFeat_redirectUrl == null)
      jcas.throwFeatMissing("redirectUrl", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_redirectUrl, v);}
    
  
 
  /** @generated */
  final Feature casFeat_knownLanguage;
  /** @generated */
  final int     casFeatCode_knownLanguage;
  /** @generated */ 
  public String getKnownLanguage(int addr) {
        if (featOkTst && casFeat_knownLanguage == null)
      jcas.throwFeatMissing("knownLanguage", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_knownLanguage);
  }
  /** @generated */    
  public void setKnownLanguage(int addr, String v) {
        if (featOkTst && casFeat_knownLanguage == null)
      jcas.throwFeatMissing("knownLanguage", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_knownLanguage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_contentLanguage;
  /** @generated */
  final int     casFeatCode_contentLanguage;
  /** @generated */ 
  public String getContentLanguage(int addr) {
        if (featOkTst && casFeat_contentLanguage == null)
      jcas.throwFeatMissing("contentLanguage", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_contentLanguage);
  }
  /** @generated */    
  public void setContentLanguage(int addr, String v) {
        if (featOkTst && casFeat_contentLanguage == null)
      jcas.throwFeatMissing("contentLanguage", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_contentLanguage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_compressed;
  /** @generated */
  final int     casFeatCode_compressed;
  /** @generated */ 
  public int getCompressed(int addr) {
        if (featOkTst && casFeat_compressed == null)
      jcas.throwFeatMissing("compressed", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_compressed);
  }
  /** @generated */    
  public void setCompressed(int addr, int v) {
        if (featOkTst && casFeat_compressed == null)
      jcas.throwFeatMissing("compressed", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_compressed, v);}
    
  
 
  /** @generated */
  final Feature casFeat_truncated;
  /** @generated */
  final int     casFeatCode_truncated;
  /** @generated */ 
  public int getTruncated(int addr) {
        if (featOkTst && casFeat_truncated == null)
      jcas.throwFeatMissing("truncated", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_truncated);
  }
  /** @generated */    
  public void setTruncated(int addr, int v) {
        if (featOkTst && casFeat_truncated == null)
      jcas.throwFeatMissing("truncated", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_truncated, v);}
    
  
 
  /** @generated */
  final Feature casFeat_hasSeparatContent;
  /** @generated */
  final int     casFeatCode_hasSeparatContent;
  /** @generated */ 
  public int getHasSeparatContent(int addr) {
        if (featOkTst && casFeat_hasSeparatContent == null)
      jcas.throwFeatMissing("hasSeparatContent", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_hasSeparatContent);
  }
  /** @generated */    
  public void setHasSeparatContent(int addr, int v) {
        if (featOkTst && casFeat_hasSeparatContent == null)
      jcas.throwFeatMissing("hasSeparatContent", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_hasSeparatContent, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mimeType;
  /** @generated */
  final int     casFeatCode_mimeType;
  /** @generated */ 
  public String getMimeType(int addr) {
        if (featOkTst && casFeat_mimeType == null)
      jcas.throwFeatMissing("mimeType", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_mimeType);
  }
  /** @generated */    
  public void setMimeType(int addr, String v) {
        if (featOkTst && casFeat_mimeType == null)
      jcas.throwFeatMissing("mimeType", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_mimeType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_metaLanguage;
  /** @generated */
  final int     casFeatCode_metaLanguage;
  /** @generated */ 
  public String getMetaLanguage(int addr) {
        if (featOkTst && casFeat_metaLanguage == null)
      jcas.throwFeatMissing("metaLanguage", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_metaLanguage);
  }
  /** @generated */    
  public void setMetaLanguage(int addr, String v) {
        if (featOkTst && casFeat_metaLanguage == null)
      jcas.throwFeatMissing("metaLanguage", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_metaLanguage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_url;
  /** @generated */
  final int     casFeatCode_url;
  /** @generated */ 
  public String getUrl(int addr) {
        if (featOkTst && casFeat_url == null)
      jcas.throwFeatMissing("url", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_url);
  }
  /** @generated */    
  public void setUrl(int addr, String v) {
        if (featOkTst && casFeat_url == null)
      jcas.throwFeatMissing("url", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_url, v);}
    
  
 
  /** @generated */
  final Feature casFeat_documentName;
  /** @generated */
  final int     casFeatCode_documentName;
  /** @generated */ 
  public String getDocumentName(int addr) {
        if (featOkTst && casFeat_documentName == null)
      jcas.throwFeatMissing("documentName", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_documentName);
  }
  /** @generated */    
  public void setDocumentName(int addr, String v) {
        if (featOkTst && casFeat_documentName == null)
      jcas.throwFeatMissing("documentName", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_documentName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_httpcode;
  /** @generated */
  final int     casFeatCode_httpcode;
  /** @generated */ 
  public int getHttpcode(int addr) {
        if (featOkTst && casFeat_httpcode == null)
      jcas.throwFeatMissing("httpcode", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_httpcode);
  }
  /** @generated */    
  public void setHttpcode(int addr, int v) {
        if (featOkTst && casFeat_httpcode == null)
      jcas.throwFeatMissing("httpcode", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_httpcode, v);}
    
  
 
  /** @generated */
  final Feature casFeat_metalength;
  /** @generated */
  final int     casFeatCode_metalength;
  /** @generated */ 
  public int getMetalength(int addr) {
        if (featOkTst && casFeat_metalength == null)
      jcas.throwFeatMissing("metalength", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_metalength);
  }
  /** @generated */    
  public void setMetalength(int addr, int v) {
        if (featOkTst && casFeat_metalength == null)
      jcas.throwFeatMissing("metalength", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_metalength, v);}
    
  
 
  /** @generated */
  final Feature casFeat_contentlength;
  /** @generated */
  final int     casFeatCode_contentlength;
  /** @generated */ 
  public int getContentlength(int addr) {
        if (featOkTst && casFeat_contentlength == null)
      jcas.throwFeatMissing("contentlength", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_contentlength);
  }
  /** @generated */    
  public void setContentlength(int addr, int v) {
        if (featOkTst && casFeat_contentlength == null)
      jcas.throwFeatMissing("contentlength", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_contentlength, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rdstype;
  /** @generated */
  final int     casFeatCode_rdstype;
  /** @generated */ 
  public int getRdstype(int addr) {
        if (featOkTst && casFeat_rdstype == null)
      jcas.throwFeatMissing("rdstype", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_rdstype);
  }
  /** @generated */    
  public void setRdstype(int addr, int v) {
        if (featOkTst && casFeat_rdstype == null)
      jcas.throwFeatMissing("rdstype", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_rdstype, v);}
    
  
 
  /** @generated */
  final Feature casFeat_nativeACLS;
  /** @generated */
  final int     casFeatCode_nativeACLS;
  /** @generated */ 
  public int getNativeACLS(int addr) {
        if (featOkTst && casFeat_nativeACLS == null)
      jcas.throwFeatMissing("nativeACLS", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getRefValue(addr, casFeatCode_nativeACLS);
  }
  /** @generated */    
  public void setNativeACLS(int addr, int v) {
        if (featOkTst && casFeat_nativeACLS == null)
      jcas.throwFeatMissing("nativeACLS", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setRefValue(addr, casFeatCode_nativeACLS, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isCompleted;
  /** @generated */
  final int     casFeatCode_isCompleted;
  /** @generated */ 
  public int getIsCompleted(int addr) {
        if (featOkTst && casFeat_isCompleted == null)
      jcas.throwFeatMissing("isCompleted", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_isCompleted);
  }
  /** @generated */    
  public void setIsCompleted(int addr, int v) {
        if (featOkTst && casFeat_isCompleted == null)
      jcas.throwFeatMissing("isCompleted", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_isCompleted, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sequenceNumber;
  /** @generated */
  final int     casFeatCode_sequenceNumber;
  /** @generated */ 
  public int getSequenceNumber(int addr) {
        if (featOkTst && casFeat_sequenceNumber == null)
      jcas.throwFeatMissing("sequenceNumber", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sequenceNumber);
  }
  /** @generated */    
  public void setSequenceNumber(int addr, int v) {
        if (featOkTst && casFeat_sequenceNumber == null)
      jcas.throwFeatMissing("sequenceNumber", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_sequenceNumber, v);}
    
  
 
  /** @generated */
  final Feature casFeat_documentId;
  /** @generated */
  final int     casFeatCode_documentId;
  /** @generated */ 
  public int getDocumentId(int addr) {
        if (featOkTst && casFeat_documentId == null)
      jcas.throwFeatMissing("documentId", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getIntValue(addr, casFeatCode_documentId);
  }
  /** @generated */    
  public void setDocumentId(int addr, int v) {
        if (featOkTst && casFeat_documentId == null)
      jcas.throwFeatMissing("documentId", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setIntValue(addr, casFeatCode_documentId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_title;
  /** @generated */
  final int     casFeatCode_title;
  /** @generated */ 
  public String getTitle(int addr) {
        if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_title);
  }
  /** @generated */    
  public void setTitle(int addr, String v) {
        if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_title, v);}
    
  
 
  /** @generated */
  final Feature casFeat_frames;
  /** @generated */
  final int     casFeatCode_frames;
  /** @generated */ 
  public int getFrames(int addr) {
        if (featOkTst && casFeat_frames == null)
      jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getRefValue(addr, casFeatCode_frames);
  }
  /** @generated */    
  public void setFrames(int addr, int v) {
        if (featOkTst && casFeat_frames == null)
      jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setRefValue(addr, casFeatCode_frames, v);}
    
   /** @generated */
  public String getFrames(int addr, int i) {
        if (featOkTst && casFeat_frames == null)
      jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_frames), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_frames), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_frames), i);
  }
   
  /** @generated */ 
  public void setFrames(int addr, int i, String v) {
        if (featOkTst && casFeat_frames == null)
      jcas.throwFeatMissing("frames", "com.ibm.es.tt.DocumentMetaData");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_frames), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_frames), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_frames), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_throttleID;
  /** @generated */
  final int     casFeatCode_throttleID;
  /** @generated */ 
  public String getThrottleID(int addr) {
        if (featOkTst && casFeat_throttleID == null)
      jcas.throwFeatMissing("throttleID", "com.ibm.es.tt.DocumentMetaData");
    return ll_cas.ll_getStringValue(addr, casFeatCode_throttleID);
  }
  /** @generated */    
  public void setThrottleID(int addr, String v) {
        if (featOkTst && casFeat_throttleID == null)
      jcas.throwFeatMissing("throttleID", "com.ibm.es.tt.DocumentMetaData");
    ll_cas.ll_setStringValue(addr, casFeatCode_throttleID, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DocumentMetaData_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_crawlerId = jcas.getRequiredFeatureDE(casType, "crawlerId", "uima.cas.String", featOkTst);
    casFeatCode_crawlerId  = (null == casFeat_crawlerId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_crawlerId).getCode();

 
    casFeat_dataSource = jcas.getRequiredFeatureDE(casType, "dataSource", "uima.cas.String", featOkTst);
    casFeatCode_dataSource  = (null == casFeat_dataSource) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dataSource).getCode();

 
    casFeat_dataSourceName = jcas.getRequiredFeatureDE(casType, "dataSourceName", "uima.cas.String", featOkTst);
    casFeatCode_dataSourceName  = (null == casFeat_dataSourceName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dataSourceName).getCode();

 
    casFeat_charset = jcas.getRequiredFeatureDE(casType, "charset", "uima.cas.String", featOkTst);
    casFeatCode_charset  = (null == casFeat_charset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_charset).getCode();

 
    casFeat_knownCharset = jcas.getRequiredFeatureDE(casType, "knownCharset", "uima.cas.String", featOkTst);
    casFeatCode_knownCharset  = (null == casFeat_knownCharset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_knownCharset).getCode();

 
    casFeat_actualCharset = jcas.getRequiredFeatureDE(casType, "actualCharset", "uima.cas.String", featOkTst);
    casFeatCode_actualCharset  = (null == casFeat_actualCharset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_actualCharset).getCode();

 
    casFeat_docType = jcas.getRequiredFeatureDE(casType, "docType", "uima.cas.String", featOkTst);
    casFeatCode_docType  = (null == casFeat_docType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_docType).getCode();

 
    casFeat_securityTokens = jcas.getRequiredFeatureDE(casType, "securityTokens", "uima.cas.StringArray", featOkTst);
    casFeatCode_securityTokens  = (null == casFeat_securityTokens) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_securityTokens).getCode();

 
    casFeat_date = jcas.getRequiredFeatureDE(casType, "date", "uima.cas.String", featOkTst);
    casFeatCode_date  = (null == casFeat_date) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_date).getCode();

 
    casFeat_staticScore = jcas.getRequiredFeatureDE(casType, "staticScore", "uima.cas.String", featOkTst);
    casFeatCode_staticScore  = (null == casFeat_staticScore) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_staticScore).getCode();

 
    casFeat_baseUri = jcas.getRequiredFeatureDE(casType, "baseUri", "uima.cas.String", featOkTst);
    casFeatCode_baseUri  = (null == casFeat_baseUri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_baseUri).getCode();

 
    casFeat_metaDataFields = jcas.getRequiredFeatureDE(casType, "metaDataFields", "uima.cas.FSArray", featOkTst);
    casFeatCode_metaDataFields  = (null == casFeat_metaDataFields) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_metaDataFields).getCode();

 
    casFeat_redirectUrl = jcas.getRequiredFeatureDE(casType, "redirectUrl", "uima.cas.String", featOkTst);
    casFeatCode_redirectUrl  = (null == casFeat_redirectUrl) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_redirectUrl).getCode();

 
    casFeat_knownLanguage = jcas.getRequiredFeatureDE(casType, "knownLanguage", "uima.cas.String", featOkTst);
    casFeatCode_knownLanguage  = (null == casFeat_knownLanguage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_knownLanguage).getCode();

 
    casFeat_contentLanguage = jcas.getRequiredFeatureDE(casType, "contentLanguage", "uima.cas.String", featOkTst);
    casFeatCode_contentLanguage  = (null == casFeat_contentLanguage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_contentLanguage).getCode();

 
    casFeat_compressed = jcas.getRequiredFeatureDE(casType, "compressed", "uima.cas.Integer", featOkTst);
    casFeatCode_compressed  = (null == casFeat_compressed) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_compressed).getCode();

 
    casFeat_truncated = jcas.getRequiredFeatureDE(casType, "truncated", "uima.cas.Integer", featOkTst);
    casFeatCode_truncated  = (null == casFeat_truncated) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_truncated).getCode();

 
    casFeat_hasSeparatContent = jcas.getRequiredFeatureDE(casType, "hasSeparatContent", "uima.cas.Integer", featOkTst);
    casFeatCode_hasSeparatContent  = (null == casFeat_hasSeparatContent) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_hasSeparatContent).getCode();

 
    casFeat_mimeType = jcas.getRequiredFeatureDE(casType, "mimeType", "uima.cas.String", featOkTst);
    casFeatCode_mimeType  = (null == casFeat_mimeType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mimeType).getCode();

 
    casFeat_metaLanguage = jcas.getRequiredFeatureDE(casType, "metaLanguage", "uima.cas.String", featOkTst);
    casFeatCode_metaLanguage  = (null == casFeat_metaLanguage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_metaLanguage).getCode();

 
    casFeat_url = jcas.getRequiredFeatureDE(casType, "url", "uima.cas.String", featOkTst);
    casFeatCode_url  = (null == casFeat_url) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_url).getCode();

 
    casFeat_documentName = jcas.getRequiredFeatureDE(casType, "documentName", "uima.cas.String", featOkTst);
    casFeatCode_documentName  = (null == casFeat_documentName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_documentName).getCode();

 
    casFeat_httpcode = jcas.getRequiredFeatureDE(casType, "httpcode", "uima.cas.Integer", featOkTst);
    casFeatCode_httpcode  = (null == casFeat_httpcode) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_httpcode).getCode();

 
    casFeat_metalength = jcas.getRequiredFeatureDE(casType, "metalength", "uima.cas.Integer", featOkTst);
    casFeatCode_metalength  = (null == casFeat_metalength) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_metalength).getCode();

 
    casFeat_contentlength = jcas.getRequiredFeatureDE(casType, "contentlength", "uima.cas.Integer", featOkTst);
    casFeatCode_contentlength  = (null == casFeat_contentlength) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_contentlength).getCode();

 
    casFeat_rdstype = jcas.getRequiredFeatureDE(casType, "rdstype", "uima.cas.Integer", featOkTst);
    casFeatCode_rdstype  = (null == casFeat_rdstype) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rdstype).getCode();

 
    casFeat_nativeACLS = jcas.getRequiredFeatureDE(casType, "nativeACLS", "com.ibm.es.tt.NativeACLS", featOkTst);
    casFeatCode_nativeACLS  = (null == casFeat_nativeACLS) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nativeACLS).getCode();

 
    casFeat_isCompleted = jcas.getRequiredFeatureDE(casType, "isCompleted", "uima.cas.Integer", featOkTst);
    casFeatCode_isCompleted  = (null == casFeat_isCompleted) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isCompleted).getCode();

 
    casFeat_sequenceNumber = jcas.getRequiredFeatureDE(casType, "sequenceNumber", "uima.cas.Integer", featOkTst);
    casFeatCode_sequenceNumber  = (null == casFeat_sequenceNumber) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sequenceNumber).getCode();

 
    casFeat_documentId = jcas.getRequiredFeatureDE(casType, "documentId", "uima.cas.Integer", featOkTst);
    casFeatCode_documentId  = (null == casFeat_documentId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_documentId).getCode();

 
    casFeat_title = jcas.getRequiredFeatureDE(casType, "title", "uima.cas.String", featOkTst);
    casFeatCode_title  = (null == casFeat_title) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_title).getCode();

 
    casFeat_frames = jcas.getRequiredFeatureDE(casType, "frames", "uima.cas.StringArray", featOkTst);
    casFeatCode_frames  = (null == casFeat_frames) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_frames).getCode();

 
    casFeat_throttleID = jcas.getRequiredFeatureDE(casType, "throttleID", "uima.cas.String", featOkTst);
    casFeatCode_throttleID  = (null == casFeat_throttleID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_throttleID).getCode();

  }
}



    