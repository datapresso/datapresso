'''
Created on Mar 1, 2011

@author: Andreea Bodnari
@contact: andreeab at mit dot edu
'''
# ---------------------------------------------------------------------------
# Imports
# ---------------------------------------------------------------------------

import sys

# ---------------------------------------------------------------------------
# Classes
# ---------------------------------------------------------------------------

class Markable():
    
    # ---------------------------------------------------------------------------
    # Class variables
    # ---------------------------------------------------------------------------
    text = ''
    assertionFileName = "assertions"
    startPos = 0
    startWordIndex = 0
    endPos = 0
    endWordIndex = 0
    type = 0
    assertion = ""
    chain = ""
    id = 0
    
    uniqueId = ""

    # ---------------------------------------------------------------------------
    # Class methods
    # --------------------------------------------------------------------------- 
    def sortMarkables(self, markables):
        finalList = []
        sortedKeys = markables.keys()
        sortedKeys.sort()
        for sortedStart in sortedKeys:
            lines = markables.get(sortedStart)
            newList = sorted(lines, key=lambda x: x.startWordIndex, reverse=False)
            for el in newList:
                finalList.append(el)
                
        return finalList
    
    def __init__(self, content, fileName , id, logFile, verbose):
        self.content = content
        self.id = id
        self.log = logFile
        self.verbose  = verbose

        #process the fileName before storing it
        self.fileName = self.parseFileName(fileName)

        # process the remaining markable content
        self.process()
    
    def parseFileName(self, fileName):
        '''
        Return a normalized version of a filename, without the file specific extension
        
        @param fileName: the name of the file to be normalized
        
        @return: the normalized file name 
        '''
        
        try:
            fileName = fileName.split(".")[0]
        except: 
            self.log.write("Could not process fileName %s" %fileName)
            self.forcedExiting()
        
        return fileName
    
    def process(self):
        (textReference , type) =  self.content.split("||")
        
        # We want to create a  unique hash value containing the markable text, offsets and file name
        self.uniqueId = hash(textReference + self.fileName)
        
        firstCharOccurrence = textReference.index("\"")
        lastcCharOccurrence = len(textReference) - textReference[::-1].index("\"")
        
        self.text = textReference[firstCharOccurrence+1: lastcCharOccurrence-1]
        
        if self.text == "":
            if self.verbose:
                self.log.write("ERROR: Markable processing failed. Incorrect value for markable text %s" %self.content)
                self.log.flush()
            self.forcedExiting()
            
        start = textReference[lastcCharOccurrence+1: len(textReference)].strip().split(" ")[0].split(":")
        
        try:
            (self.startPos, self.startWordIndex) = (int(start[0]), int(start[1]))
        except :
            if self.verbose:
                self.log.write( "ERROR: Markable processing failed.\n")
                self.log.flush()
            self.forcedExiting()
            
        end = textReference[lastcCharOccurrence+1: len(textReference)].strip().split(" ")[1].split(":")
        (self.endPos, self.endWordIndex) = (int(end[0]), int(end[1]))
             
        self.type = type.split("\"")[1]
        
        if "coref" in self.type:
            self.type = self.type.split(" ")[1]
            if self.type == "":
                if self.verbose:
                    self.log.write("ERROR: Markable processing failed. Incorrect semantic type. \n")
                    self.log.flush()
                self.forcedExiting()
                    
        
    def forcedExiting(self):
        print 'ERROR: Check the log file for more details.'
        sys.exit(-1)
                
    
    
    