/*
 * TableData.java
 *
 * Created on October 10, 2004, 9:03 PM
 */

package com.dp.dhs.model;

import java.util.*;
import java.util.regex.*;
import org.jdom.*;

/**
 *
 * @author  Aaron
 */
public class TableData implements Comparable {
    
    private String name;
    private String dbName;
    private String pattern;
    private Double minValue;
    private Double maxValue;
    private HashMap vocab;
    private boolean checkContext = false;
    
    private float patternWeight = 1;
    private float rangeWeight = 1;
    private float vocabWeight = 1;
    private float contextWeight = 1;
    private float confidence = 1;
    private float result = 0;
    
    private Element columnCfg;
    private EdgarProcessorConfig appCfg;
    private int position;
    private int cursor;
    private String line;
    private String value;
    private Boolean valid;
    private Pattern p;
    private Matcher m;
    private int end = 0;
    public TableData nextColumn;
    
    /** Creates a new instance of TableData */
    public TableData(Element columnCfg, EdgarProcessorConfig appCfg, int position) {
        
        this.columnCfg = columnCfg;
        this.position = position;
        this.appCfg = appCfg;
        String weight;
        vocab = new HashMap();
        
        /* Get the required attributes */
        name = columnCfg.getAttributeValue("name");
        
        dbName = columnCfg.getChildText("dbName");
        
        pattern = columnCfg.getChildText("Pattern");
        weight = columnCfg.getChild("Pattern").getAttributeValue("weight");
        if (weight != null) {
            patternWeight = Float.parseFloat(weight);
        }
        
        confidence = Float.parseFloat( columnCfg.getAttributeValue("confidence") );
        
        /* Get the optional attributes */
        if (columnCfg.getChild("Range") != null) {
            Element range = columnCfg.getChild("Range");
            if (columnCfg.getChild("Range").getAttributeValue("low") != null) {
                minValue = new Double(range.getAttributeValue("low"));
            }
            if (columnCfg.getChild("Range").getAttributeValue("high") != null) {
                maxValue = new Double(range.getAttributeValue("high"));
            }
            weight = range.getAttributeValue("weight");
            if (weight != null) {
                rangeWeight = Float.parseFloat(weight);
            }
        }
        
        if (columnCfg.getChild("Vocabulary") != null) {
            vocab = appCfg.getVocab(columnCfg.getChildText("Vocabulary"));
            weight = columnCfg.getChild("Vocabulary").getAttributeValue("weight");
            if (weight != null) {
                vocabWeight = Float.parseFloat(weight);
            }
        }
        
        if (columnCfg.getChild("CheckContext") != null) {
            weight = columnCfg.getChild("CheckContext").getAttributeValue("weight");
            if (weight != null) {
                contextWeight = Float.parseFloat(weight);
                checkContext = true;
            }
        }
        
    }
    
    public TableData() {
        
    }
    
    /* verify if the text item is valid based on
     * weights and confidence check
     */
    public boolean isValid(String _line, int _cursor) {
        
        this.line = _line;
        this.cursor = _cursor;
        boolean patternMatch = false;
        boolean vocabMatch = false;
        boolean inRange = false;
        float weight = 0;
        
        //get the token content based on preprocessing and the current cursor position
        String token = getCurrentToken();
        _cursor = this.cursor;
        
        //a. Validate the token against the column configuration
        if (token.matches(pattern)) {
            weight += patternWeight;
        }
        //b. Validate if there it matches the predefined vocabulary
        if (! vocab.isEmpty()) {
            String word = token.replaceAll("[^aA-zZ]", "");
            vocabMatch = vocab.containsKey(word.toLowerCase());
            if (vocabMatch) {
                weight += vocabWeight;
            }
        }
        
        //c. Validate for ranging checking for numerical values
        if (token.matches("-?[0-9]+(\\.[0-9]*)?")) {
            // Token looks like a number so perform range checking
            if ( (minValue != null) && maxValue != null ) {
                // range has both an upper and lower bounds
                if (minValue != null) {
                    inRange = Double.parseDouble(token) >= minValue.doubleValue();
                }
                if (maxValue != null) {
                    inRange = inRange && ( Double.parseDouble(token) <= maxValue.doubleValue() );
                }
            }
            else {
                // range has either an upper or a lower bounds
                if (minValue != null) {
                    inRange = Double.parseDouble(token) >= minValue.doubleValue();
                }
                if (maxValue != null) {
                    inRange = Double.parseDouble(token) <= maxValue.doubleValue();
                }
            }
            if (inRange) {
                weight += rangeWeight;
            }
        }
        
        //d. Validate based on shallow context parser
        if (checkContext) {
                /* We will check the previous, current, and next tokens in
                 * the current line for validity.
                 * if previous and next tokens are valid then weight =* 1
                 * if either last or next token is valid then weight =* 1/3;
                 */
            
                /* Call this method recursively to check this token in context
                 * of previous and next token.
                 */
            checkContext = false;
            int lastPosition = getLastTokenPosition();
            int nextPosition = getNextTokenPosition();
            
            boolean validLastToken = (lastPosition >= 0) &&
            isValid( line, lastPosition );
            boolean validNextToken = (nextPosition >= 0) &&
            isValid(line,  nextPosition );
            cursor = _cursor;
            float factor = 0;
            if (validLastToken) {
                factor += 1;
            }
            if (validNextToken) {
                factor += 1;
            }
            weight += (contextWeight * (factor / 2));
            checkContext = true;
        }
        
        result = weight;
        return (weight >= confidence);
    }
    
    public void setValue(String line, int cursor) {
        
        value = getCurrentToken();
        
    }
    
    public void setDefault() {
        if (getDefaultValue() != null) {
            value = getDefaultValue();
        }
    }
    public void appendValue(String line, int cursor) {
        
        
        if (value != null) {
            value = value + " " + getCurrentToken();
        }
        else {
            value = getCurrentToken();
        }
}

public boolean isMultiword() {
    
    if (columnCfg.getAttributeValue("multiword") != null) {
        return columnCfg.getAttributeValue("multiword").equals("true");
    }
    else {
        return false;
    }
}

public boolean isMultiline() {
    
    if (columnCfg.getAttributeValue("multiline") != null) {
        return columnCfg.getAttributeValue("multiline").equals("true");
    }
    else {
        return false;
    }
}


public boolean hasOverlap() {
    
    if (columnCfg.getAttributeValue("overlap") != null) {
        return columnCfg.getAttributeValue("overlap").equals("true");
    }
    else {
        return false;
    }
}


public boolean isNonrepeating() {
    
    if (columnCfg.getAttributeValue("nonrepeating") != null) {
        return columnCfg.getAttributeValue("nonrepeating").equals("true");
    }
    else {
        return false;
    }
}

public boolean isPrimaryKey() {
    
    if (columnCfg.getAttributeValue("primary_key") != null) {
        return columnCfg.getAttributeValue("primary_key").equals("true");
    }
    else {
        return false;
    }
}

public String toString() {
    
    if (value == null) {
        return null;
    }
    else {
        return new String(value);
    }
}

public double toDouble() {
    
    return Double.parseDouble(value);
}

public int toInt() {
    return Integer.parseInt(value);
}

public int compareTo(Object o) {
    
    TableData td = (TableData)o;
    return this.position - td.getPosition();
    
}

public int getPosition() {
    return position;
}

public Element getColumnCfg() {
    return columnCfg;
}

public String getDataType() {
    
    return columnCfg.getAttributeValue("datatype");
    
}

public String getDbName() {
    
    return columnCfg.getChildText("dbName");
    
}

public String getDefaultValue() {
    
    if (columnCfg.getAttributeValue("default") != null) {
        return columnCfg.getAttributeValue("default");
    }
    else {
        return null;
    }
}

public float getResult() {
    
    return result;
}

private void preProcess() {
    
    if (columnCfg.getChild("Preprocess") != null) {
        Iterator it = columnCfg.getChild("Preprocess").getChildren("Replace").iterator();
        
        while(it.hasNext()) {
            Element r = (Element) it.next();
            String findPattern = r.getAttributeValue("pattern");
            String replacePattern = r.getAttributeValue("with");
            
            if (cursor > 0) {
                String subString1 = line.substring(0,cursor);
                String subString2 = line.substring(cursor);
                int oldLength = subString1.length();
                subString1 = subString1.replaceAll(findPattern, replacePattern);
                int deltaLength = oldLength - subString1.length();
                line = subString1 + subString2.replaceAll(findPattern, replacePattern);
                cursor -= deltaLength;
            }
            else {
                line = line.replaceAll(findPattern, replacePattern);
            }
            
        }
        
    }
}

private int getLastTokenPosition() {
    
    String regex = "\\s*(\\S+)\\s*$";
    p = Pattern.compile(regex);
    m = p.matcher( line.substring(0, cursor) );
    if (m.find()) {
        return m.start(1);
    }
    else {
        return -1;
    }
    
}

private String getCurrentToken() {
    
    preProcess();
    
    String regex = "^\\s*(\\S+)";
    p = Pattern.compile(regex);
    m = p.matcher( line.substring(cursor) );
    if (m.find()) {
        end = m.end();
        return m.group(1);
    }
    else {
        return "";
    }
}

private int getNextTokenPosition() {
    
    String regex = "^\\s*\\S+\\s+(\\S+)";
    p = Pattern.compile(regex);
    m = p.matcher( line.substring(cursor) );
    
    if (m.find()) {
        return m.start(1) + cursor;
    }
    else {
        return -1;
    }
}
}




