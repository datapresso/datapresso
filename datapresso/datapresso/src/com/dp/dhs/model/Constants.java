package com.dp.dhs.model;

public abstract class Constants {
	public static final String FILING_TYPE_DEF14A = "DEF 14A";
	public static final String FILING_TYPE_10K = "10-K";
	public static final String FILING_TYPE_NPX = "N-PX";
	public static final int FILING_TYPE_INVALID = 0;
	public static final int FILING_TYPE_NOTFOUND = -1;
	public static final int FILING_TYPE_DEF14A_ID = 1;
	public static final int FILING_TYPE_10K_ID = 2;
	public static final int FILING_TYPE_NPX_ID = 3;
	public static final int DOCUMENT_TYPE_TEXT = 1;
	public static final int DOCUMENT_TYPE_HTML = 2;
	public static final int DOCUMENT_TYPE_XML = 3;
	public static final String EDGAR_MESSAGE_CATALOG = "com.dp.edgar.uima.annotator.EdgarAnnotator_Messages";

	public Constants() {
		super();
		// TODO Auto-generated constructor stub
	}

}
