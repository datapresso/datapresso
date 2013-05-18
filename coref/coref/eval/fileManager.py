'''
Created on May 1, 2011

@author: Andreea Bodnari
@contact: andreeab at mit dot edu
'''
# ---------------------------------------------------------------------------
# Imports
# ---------------------------------------------------------------------------

import sys
import os
from markable import Markable

# ---------------------------------------------------------------------------
# Classes
# ---------------------------------------------------------------------------

class FileManager():
    
    chainDelimiter = "||"
    corpusSemCat = []
    
    def __init__(self, logFile, verbose):
        self.numMarkables = 0
        self.log = logFile
        self.verbose = verbose
    
    def ImportCoreferencePredictions(self, coreferencePredictionPath):
        '''
        Import coreference predictions that are in i2b2 file format
        @param corpusName: the name of the corpus for which the import is done
        
        @return: a list of markable chains
        '''
        coreferenceChains = {}
        fileNames = []
        
        for sem in self.corpusSemCat:
            coreferenceChains[sem] = []
        try:
            dirFiles = os.listdir(coreferencePredictionPath)
        except :
            if self.verbose:
                self.log.write( "Incorrect path %s.\n" %coreferencePredictionPath )
                self.log.flush()
            self.forcedExiting()
        
        for coreferenceFile in dirFiles:
            # Ignore the system files
            if coreferenceFile.startswith("."):
                continue
            
            # store the file name
            fileNames.append(self.processFileName(coreferenceFile))
            
            try:
                fileName = os.path.join(coreferencePredictionPath, coreferenceFile)
                readCoreferencePredictions = open(fileName, "r")
               
                # Each file line contains a coreference chain
                for line in readCoreferencePredictions.readlines():
                    processedChain = self.processChain(line, coreferenceFile)
                    if len(processedChain) == 0:
                        continue
                    type = processedChain[0].type
                    
                    if type in coreferenceChains.keys():
                        coreferenceChains.get(type).append(processedChain)
                    else:
                        if self.verbose:
                            self.log.write("Incorrect chain type not present in the markables types : %s\n" %type)
                            self.log.write("Check file : %s" %coreferenceFile)
                            self.log.flush()
                        self.forcedExiting()
                
                # close the file
                readCoreferencePredictions.close()
            except :
                if self.verbose:
                    self.log.write( "ERROR: Unable to process file %s \n" %fileName)
                    self.log.flush()
                self.forcedExiting()
            
        if len(coreferenceChains) == 0:
            if self.verbose:
                self.log.write( "ERROR: Unable to read in corpus coreference chains.\n")
                self.log.flush()
            self.forcedExiting()
            
            
        return (coreferenceChains, fileNames)
    
    def processFileName(self, fileName):
        '''
        Return the fileName with the removed file extension
        @param fileName:the fileName to be processed
        
        @return: the processed fileName 
        '''
        try:
            fileName = fileName.split(".")[0]
        except:
            if self.verbose:
                self.log.write("Could not process file name: %s. Using the standard file name form.\n" % fileName)
                self.log.flush()
        
        return fileName
        
    def ImportMarkables(self,  markablesPath):
        '''
        Import corpus markables 
        @param markablesPath: the path where the markables will be located 
        
        @return: a list of corpus markables, the file names
        '''
        markables = {}
        fileNames = []
        
        try:
            dirFiles = os.listdir(markablesPath)
        except:
            if self.verbose:
                self.log.write( "Incorrect path %s.\n" %markablesPath)
                self.log.flush()
            self.forcedExiting()
        
        for markableFile in dirFiles:
            # Ignore the system files
            if markableFile.startswith("."):
                continue
            
            # store the file name
            fileNames.append(self.processFileName(markableFile))
            
            try:
                fileName = os.path.join(markablesPath, markableFile)
                readMarkables = open(fileName, "r")
            
                
                # Each file line contains a coreference chain
                for line in readMarkables.readlines():
                    try:
                        processedMarkable = Markable(line.lower(), markableFile, 0, self.log, self.verbose) 
                        if processedMarkable.type in markables.keys():
                            markables.get(processedMarkable.type).append(processedMarkable)
                        else:
                            markables[processedMarkable.type] = [processedMarkable]
                            
                    except :
                        if self.verbose:
                            self.log.write( "ERROR: Unable to process markable %s .\n" %line)
                            self.log.write("Check file : %s" %markableFile)
                            self.log.flush()
                        self.forcedExiting()
                
                # close the file
                readMarkables.close()
                        
            except :
                if self.verbose:
                    self.log.write( "ERROR: Unable to process file %s ,\n" %fileName)
                    self.log.flush()
                self.forcedExiting()
                
        if len(markables) == 0:
            if self.verbose:
                self.log.write( "Unable to read in corpus markables.\n")
                self.log.flush() 
            self.forcedExiting()
        
        # we will define the corpus semantic categories depending on what semantic category
        # the markables have
        self.corpusSemCat = markables.keys()
        
        return (markables, fileNames)
    
    def processChain(self, line, coreferenceFile):
        '''
        Process one coreferent chain
        @param line: the chain to be processed
        @param coreferenceFile: the file from which the chain originated
        
        @return: a list with the chain markables  
        '''
        markables= []

        try:
            splitLine = line.split(self.chainDelimiter)
    
            # chain type is last element in the list
            chainType = splitLine[len(splitLine) - 1]
            splitLine.pop()
           
            for el in splitLine:
                markableContent  = el + self.chainDelimiter + chainType
                self.numMarkables  += 1
                markables.append(Markable(markableContent.lower(), coreferenceFile, self.numMarkables, self.log, self.verbose))
        except :
            if self.verbose:
                self.log.write( "ERROR: Unable to process chain %s \n" %line)
                self.log.flush()
            self.forcedExiting()
            
        return markables
            
        
        
    def forcedExiting(self):
        print 'ERROR: Check the log file for more details.'
        sys.exit(-1)
                