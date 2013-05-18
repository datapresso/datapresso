'''
Created on May 14, 2011

@author: Andreea Bodnari
@contact: andreeab at mit dot edu
'''

# ---------------------------------------------------------------------------
# Imports
# ---------------------------------------------------------------------------

from xml.dom.minidom import Document
import os
import sys
# ---------------------------------------------------------------------------
# Classes
# ---------------------------------------------------------------------------

class XmlManager():
    # ---------------------------------------------------------------------------
    # Class variables
    # ---------------------------------------------------------------------------
    averageTag  = "unweightedAverageAllMetrics"
    measureTag = "measure"
    measuresTag = "measures"
    categoryTag = "category"
    typeTag = "tag"
    sizeTag = "size"
    corefTag = "coreference_evaluation"
    
    # ---------------------------------------------------------------------------
    # Class methods
    # ---------------------------------------------------------------------------
    def __init__(self, outputFilePath):
        # first check if the outputFilePath exists
        # otherwise prompt the error and stop execution
        if not os.path.exists(outputFilePath):
            dir =  os.path.dirname(outputFilePath)
            
            if not os.path.exists(dir):
                errorMessage = "ERROR: Incorrect output file path %s " %outputFilePath
                print errorMessage
            
                self.forcedExiting()
            
        self.doc = Document()
        # init the xml document
        self.corpus = self.doc.createElement(self.corefTag)
        self.doc.appendChild(self.corpus)
        
        # output file name
        self.outputFileName = outputFilePath
    
    def xmlConvertCumulative(self, resultsOverAllMetricsAndOverlap):
        for metric in resultsOverAllMetricsAndOverlap.keys():
            metricElement = self.doc.createElement(metric)
            self.corpus.appendChild(metricElement)
            
            metricOverlap = resultsOverAllMetricsAndOverlap.get(metric)
            
            for overlap in metricOverlap.keys():
                overlapElement = self.doc.createElement(overlap)
                metricElement.appendChild(overlapElement)
                
                semValues = metricOverlap.get(overlap)
                for semResults in semValues:
                    self.xmlConvert(semResults[0], semResults[1], semResults[2],overlapElement )
                    
                
    def xmlConvert(self, semanticCategory, sampleSize, results, parent=None):
        category = self.doc.createElement(self.categoryTag)
        category.setAttribute(self.typeTag, semanticCategory)
        category.setAttribute(self.sizeTag, str(sampleSize))
        
        for key in results.keys():
            if key == self.averageTag:
                self.appendUnweightedAverage(results.get(key), parent)
                continue
            
            measures = self.doc.createElement(self.measuresTag)
            measures.setAttribute(self.typeTag, key)
            category.appendChild(measures)
            
            analysisResults = results.get(key)
            
            for result in analysisResults.keys():
                measure = self.doc.createElement(self.measureTag)
                measure.setAttribute(self.typeTag, result)
                resultText = self.doc.createTextNode(str(analysisResults.get(result)))
                measure.appendChild(resultText)
                measures.appendChild(measure)
        
        if parent == None:    
            self.corpus.appendChild(category)
        else:
            parent.appendChild(category)
            
    def appendUnweightedAverage(self, value, parent = None):
        category = self.doc.createElement(self.categoryTag)
        category.setAttribute(self.typeTag, self.averageTag)
        resultText = self.doc.createTextNode(str(value))
        
        category.appendChild(resultText)
        
        if parent == None:
            self.corpus.appendChild(category)        
        else:
            parent.appendChild(category)
            
    def xmlRender(self):
        try:
            outputFile = open(self.outputFileName, "w")
            outputFile.write( self.doc.toprettyxml(indent="  "))
            outputFile.close()
        except :
            print "ERROR: Could not locate output file. Rendering to std output."
            print self.doc.toprettyxml(indent="  ")
    
    def forcedExiting(self):
        print 'ERROR: Check the log file for more details.'
        sys.exit(-1)
                
    
    