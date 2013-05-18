/*
 * Config.java
 *
 * Created on July 18, 2004, 11:33 PM
 */
package com.dp.dhs.model;
/**
 *
 * @author  Aaron
 */
import java.io.*;
import java.util.*;
import java.net.*;

import org.jdom.*;
import org.jdom.input.*;

public class EdgarProcessorConfig {
    private String inputDirectory;
    private HashMap titleMap;
    private HashMap vocabulary;
    private String tableConfig;
    private File tableFile;
    private String home;
    
    public String getInputDirectory() { return inputDirectory; }
    public Set getTitles() { return titleMap.keySet(); }
    public String getPosition(String title) {return (String) titleMap.get(title); }
    
    public HashMap getVocab(String key) {
        if (vocabulary.containsKey(key)) {
            /* This vocabulary file has already been read into the hashmap so
             * return it. */
            return (HashMap) vocabulary.get(key);
        }
        else {
            /* Need to read the vocabulary words into the hashmap */
            try {
                String line;
                //File f = new File( new URI(home + key));
                File f = new File( home + key);
                if (! (f.isFile())) {
                    throw new IOException("Unable to find file: " + home + key);
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                HashMap wordlist = new HashMap();
                while ((line = br.readLine()) != null) {
                    String word = line.trim().toLowerCase();
                    wordlist.put(word, new Integer(1));
                }
                vocabulary.put(key, wordlist);
            }
            catch (FileNotFoundException e)  {
                e.printStackTrace();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            //catch(URISyntaxException e) {
            //    e.printStackTrace();
            //}
        }
        return (HashMap) vocabulary.get(key);
    }
    public Element getTableConfig(String name) throws JDOMException, IOException {
        
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(tableFile);
        Element tables = doc.getRootElement();
        
        Iterator it = (tables.getChildren()).iterator();
        Element table = new Element("");
        
        while(it.hasNext()) {
            table = (Element)it.next();
            if (table.getAttribute("name").equals(name)) {
                break;
            }
        }
        return table;
    }
    
    public Iterator getTableConfig() throws JDOMException, IOException {
        
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(tableFile);
        Element tables = doc.getRootElement();
        return (tables.getChildren()).iterator();
    }
    
    public EdgarProcessorConfig(String home, String configFile) throws URISyntaxException,
    IOException,
    JDOMException {
        
        this.home = home;
        //File cfgFile = new File( new URI(home + configFile));
        File cfgFile = new File(home,configFile);
        if (! (cfgFile.isFile())) {
            throw new IOException("Unable to find configuration file: "
            + home + configFile);
        }
        
        readConfig(cfgFile);
        
        //tableFile = new File( new URI(home + "table.xml"));
        tableFile = new File( home , "table.xml");
        if (! (tableFile.isFile())) {
            throw new IOException("Unable to find configuration file: "
            + home + "table.xml");
        }

        vocabulary = new HashMap(1000);
    }
    
    void readConfig(File configFile) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        
        Document doc = builder.build(configFile);
        Element cers = doc.getRootElement();
        Element documentManager = cers.getChild("DocumentManager");
        inputDirectory = documentManager.getChild("InputDirectory").getText();
        List titles = cers.getChild("Titles").getChildren();
        Iterator it = titles.iterator();
        String position;
        titleMap = new HashMap(100);
        while (it.hasNext()) {
            Object o = it.next();
            if (o instanceof Element) {
                Element title = (Element) o;
                position = title.getAttributeValue("Position");
                List aliases = title.getChildren();
                Iterator it2 = aliases.iterator();
                while (it2.hasNext()) {
                    Object o2 = it2.next();
                    if (o2 instanceof Element) {
                        String alias = ((Element) o2).getTextTrim();
                        titleMap.put(new String(alias), new String(position));
                    }
                }
            }
        }
    }
}
