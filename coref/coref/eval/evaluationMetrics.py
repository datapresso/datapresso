'''
Created on Mar 1, 2011

@author: Andreea Bodnari
@contact: andreeab at mit dot edu
'''

# ---------------------------------------------------------------------------
# Imports
# ---------------------------------------------------------------------------

import pp
from munkres import *

from copy import deepcopy
from fileManager import FileManager
from xmlManager import XmlManager

import sys
import itertools
import time

class EvaluationMetrics():
    # ---------------------------------------------------------------------------
    # Class variables
    # ---------------------------------------------------------------------------
    warningMissingFiles = "WARNING: Missing system files"
    
    errorAdditionalSystemFiles = "ERROR: The system files should map to the gold standard files. Spurious file " 
    errorSemanticCategory = "Error incorrect semantic category "
    errorInputFiles = "Error input file names or incorrect number of input files "
    errorMetricResult = "Error computation of metric (cannot get value higher than 1) "
    errorMarkableProcessing = "Error processing markable "
    
    logProcessing = "Processing semantic category "
    logStartMetric = "===== STARTED "
    logEndMetric = "===== FINISHED "
    
    exactAndpartialOverlap = "exactANDpartial"
    exactOverlap = "exact"
    
    overallEvaluation = "overall"
    fmeasure = "fmeasure"
    blanc = "blanc"
    evalType = [ 'MucEvaluation','BcubedEvaluationChain', 'CEAFEvaluationChain','BlancEvaluationChain' ]
    
    # ---------------------------------------------------------------------------
    # Class methods
    # ---------------------------------------------------------------------------
    def __init__(self, coreferencePredictionsPath, outputFilePath, isEndToEnd , isOverall, verbose ):
        # xml doc for results output
        self.output = XmlManager(outputFilePath)
                
        self.sem = ''
        self.isEndToEnd = isEndToEnd
        self.isOverall = isOverall
        
        # Log handling
        self.verbose = verbose
        self.log = None
        self.startLogging()
        
        #Data importer
        self.ioImport = FileManager(self.log, self.verbose)
        
        #Import gold standard
        (self.markablesCategories, gsMarkableFiles) = self.ioImport.ImportMarkables(coreferencePredictionsPath[2])    
        (self.goldStandardCategories, gsFiles) = self.ioImport.ImportCoreferencePredictions(coreferencePredictionsPath[0])
        
        # Import system predictions
        (self.systemPredictionsCategories, systemFiles) = self.ioImport.ImportCoreferencePredictions(coreferencePredictionsPath[1]) 
        if isEndToEnd:
            (self.markablesSystemCategories, systemMarkableFiles) = self.ioImport.ImportMarkables(coreferencePredictionsPath[3])
        else:
            systemMarkableFiles = None
            
        self.validateInputFiles(gsFiles, systemFiles, gsMarkableFiles, systemMarkableFiles)              
                        
        # add the overall markables for computing the micro-average
        if self.isOverall:
            overallGoldStandard = []
            overallSystemPredictions = []
            overallMarkables = []
            overallSystemMarkables = []
            
            for sem in self.goldStandardCategories.keys():
                overallGoldStandard += self.goldStandardCategories.get(sem)
                
                # we have to check whether the system markables present this semantic category
                if sem in self.systemPredictionsCategories.keys():
                    overallSystemPredictions +=  self.systemPredictionsCategories.get(sem)
                else:
                    self.logMessage(self.errorSemanticCategory, sem)
                    self.forcedExiting()
                    
                overallMarkables  += self.markablesCategories.get(sem)
                if self.isEndToEnd:
                    if sem in self.markablesSystemCategories.keys():
                        overallSystemMarkables += self.markablesSystemCategories.get(sem)
                    else:
                        self.logMessage(self.errorSemanticCategory, sem)
                        self.forcedExiting()
                        
            sem = self.overallEvaluation
            self.goldStandardCategories[sem] = overallGoldStandard
            self.systemPredictionsCategories[sem] = overallSystemPredictions
            self.markablesCategories[sem] = overallMarkables      
            if self.isEndToEnd:      
                self.markablesSystemCategories[sem] = overallSystemMarkables
             
        # start processing if import were successful   
        if self.isEndToEnd:
            self.executeEndToEndEvaluation()
        else:              
            self.executeEvaluation()   
        
        # Finish logging
        self.finishLogging()   
    
    def validateInputFiles(self, gsFiles, systemFiles, gsMarkableFiles, systemMarkableFiles):
        # Check the validity of chain files            
        # if there are additional system chain files compared to the gold standard we stop execution
        unionChainFiles = set(systemFiles).difference(set(gsFiles))
        if len(unionChainFiles) <> 0:
            self.logMessage(self.errorAdditionalSystemFiles, unionChainFiles)
            self.forcedExiting()

        # if a system chain file is missing, we just log a warning message
        intersectionChainFiles = set(gsFiles).difference(set(systemFiles))
        if len(intersectionChainFiles) <> 0:
            self.logMessage(self.warningMissingFiles, intersectionChainFiles)

        # check the validity of markable files
        if self.isEndToEnd:
            
            # Check if the system markable files have additional files compared to the gold standard
            additionalSystemMarkablesFiles = set(systemMarkableFiles).difference(set(gsMarkableFiles))
            if len(additionalSystemMarkablesFiles) <> 0:
                self.logMessage(self.errorAdditionalSystemFiles, str(additionalSystemMarkablesFiles))
                self.forcedExiting()
                        
            # Check if the system markables files are missing one of the gold standard files
            # If one of the files is missing we just send out a warning message and treat the missing file as an empty file
            missingSystemMarkablesFiles = set(gsMarkableFiles).difference(set(systemMarkableFiles))
            if len(missingSystemMarkablesFiles) <> 0:
                self.logMessage(self.warningMissingFiles, str(missingSystemMarkablesFiles))

                                
                    
    def processDataEndToEnd(self):
        # 1. discard all singleton twinless markables in the system chains
        # twinless markables = markables not in the system and gold standard
        self.discardSingletonSystemTwinless()
        
        # 2. put all twinless gold standard markables into system chains as singletons 
        self.systemMarkables = self.addTwinlessToChains(self.markables, self.systemMarkables)
        
        # PRECISION:
        # a. merge remaining twinless system markables into the gold standard as singletons
        self.gsPrecisionMarkables = self.addTwinlessToChains(self.systemMarkables, self.markables)
        
        # RECALL
        # a. discard the remaining twinless system markables
        (self.systemRecallMarkables, self.systemRecallChains) = self.discardSystemTwinless(self.systemMarkables, self.systemPredictions)                 
        
    def executeEndToEndEvaluation(self):
        '''
        We have a slightly different initialization process for the end to end coreference evaluation
        We are now given the system generated markables as well
        We also have to process the system and goldStandard chains slightly before we __
        __ start the evaluation process
        
        '''
        metricType = ['CoNLL', 'SYS']
        overlapTypes = [self.exactOverlap, self.exactAndpartialOverlap]
        evaluationPerType = {'CoNLL': [ 'MucEvaluation','BcubedEvaluationChain', 'CEAFEvaluationChain','BlancEvaluationChain' ],
                             'SYS': [ 'BcubedEvaluationChainEndToEnd', 'CEAFEvaluationChainEndToEnd' ]}
        
        
        resultsOverAllMetricsAndOverlap = {}
        
        for overlap in overlapTypes:
            self.overlap = overlap  
            
            for sem in self.goldStandardCategories.keys():
                
                if self.isOverall and sem <> self.overallEvaluation:
                    continue
                
                self.logMessage(self.logProcessing, sem)
                
                self.goldStandard = deepcopy(self.goldStandardCategories.get(sem))
                self.systemPredictions = deepcopy(self.systemPredictionsCategories.get(sem))
                self.markables = deepcopy(self.markablesCategories.get(sem))
                self.systemMarkables = deepcopy(self.markablesSystemCategories.get(sem))
                copySystemMarkables = deepcopy(self.systemMarkables)
                copySystemChains = deepcopy(self.systemPredictions)
    
                self.sem = sem
                
                if self.goldStandard == [] and self.systemPredictions == []:
                    continue
               
                # Process the data for the end to end evaluation metrics                    
                self.processDataEndToEnd() 
                
                # output sample size
                numMarkables = 0   
                for chain in self.systemPredictions:
                    numMarkables += len(chain)
                                        
                countMeasure = 0
                fMeasureSum = 0.
                
                for metric in metricType:
                    self.evalType =  evaluationPerType.get(metric)
                
                    results = {}
    
                    if metric == "CoNLL":                       
                        self.systemMarkables = self.systemRecallMarkables
                        self.systemPredictions = self.systemRecallChains
                        
                    for eval in self.evalType:
                        
                        self.logMessage(self.logStartMetric, eval)
                    
                        evalToCall = getattr(EvaluationMetrics, eval)
                        evalResults = evalToCall(self)
                        
                        for val in evalResults.values():
                            if val > 1.1 :
                                self.logMessage(self.errorMetricResult)                       
                                self.forcedExiting()
                                    
                        if self.blanc not in eval.lower() and sem == self.overallEvaluation:
                            fMeasureSum += evalResults.get(self.fmeasure)
                            countMeasure += 1
                            
                                            
                        # Round the results to 3 significant digits
                        for key in evalResults.keys():
                            evalResults[key] = round(evalResults.get(key),3)
                            
                        results[eval] = evalResults 
                        
                        self.logMessage(self.logEndMetric, eval)
                    
                    # Restore the system markables and the system chains
                    if metric == "CoNLL":
                        self.systemMarkables = copySystemMarkables
                        self.systemPredictions = copySystemChains
                        
                    if sem == self.overallEvaluation and countMeasure <> 0:
                        unweightedAverage = fMeasureSum
                    
                    results["unweightedAverageAllMetrics"] = round(unweightedAverage/countMeasure, 3)
                    
                    if metric in resultsOverAllMetricsAndOverlap.keys():
                        metricValues = resultsOverAllMetricsAndOverlap.get(metric)
                        
                        if overlap in metricValues.keys():
                            overlapValues = metricValues.get(overlap)
                            
                            overlapValues.append([sem, numMarkables, results])
                        else:
                            metricValues[overlap] = [[sem, numMarkables, results]]
                    else:
                        resultsOverAllMetricsAndOverlap[metric] = {overlap:[[sem, numMarkables, results]]}
                        
        self.output.xmlConvertCumulative(resultsOverAllMetricsAndOverlap)
                     
        self.output.xmlRender()
  
    def executeEvaluation(self):
        '''
        Evaluate coreference resolution for systems that take as input the gold standard__
        markables and determine only the coreference chains
        
        '''
          
        for sem in self.goldStandardCategories.keys():
            
            if self.isOverall and sem <> self.overallEvaluation:
                continue
            
            self.logMessage(self.logProcessing, sem)
            
            self.goldStandard = self.goldStandardCategories.get(sem)
            self.systemPredictions = self.systemPredictionsCategories.get(sem)
            self.markables = self.markablesCategories.get(sem)
            self.sem = sem
            
            if self.goldStandard == [] and self.systemPredictions == []:
                continue
                
            numMarkables = 0   
            for chain in self.systemPredictions:
                numMarkables += len(chain)
                    
            results = {}
            
            countMeasure = 0
            fMeasureSum = 0.
            for eval in self.evalType:
                
                self.logMessage(self.logStartMetric, eval)
            
                evalToCall = getattr(EvaluationMetrics, eval)
                evalResults= evalToCall(self)
                
                for val in evalResults.values():
                    if val > 1.1 :
                        self.logMessage(self.errorMetricResult)
                        self.forcedExiting()
                            
                if self.blanc not in eval.lower() and sem == self.overallEvaluation:
                    fMeasureSum += evalResults.get(self.fmeasure)
                    countMeasure += 1
                    
                # Round the results to 3 significant digits
                for key in evalResults.keys():
                    evalResults[key] = round(evalResults.get(key),3)                    

                results[eval] = evalResults 
                
                self.logMessage(self.logEndMetric)
            
            if sem == self.overallEvaluation and countMeasure <> 0:
                unweightedAverage = round(fMeasureSum/countMeasure,3)
                self.output.appendUnweightedAverage(unweightedAverage)
                
            self.output.xmlConvert(sem, numMarkables, results)
        
        self.output.xmlRender()
   
    def MucEvaluation(self):
        '''
        Compute the MUC evaluation for stored corpus data
        @return: precision, recall, f-measure
        '''
        t1  = time.clock()
        
        precision = 0.
        recall = 0.
        
        countPrecision = 0.
        countRecall = 0.
        countNormal = 0.
        
        # a workaround to get better performance time
        # runs down from exponential to log time
        hashSystem = {}
        for chain in self.goldStandard:
            concatenated = ""
            for markable in chain:
                concatenated += str(markable.uniqueId) + ","   
            
            for markable in chain:
                hashSystem[str(markable.uniqueId)] = concatenated
        
        for chain in self.systemPredictions:
            chainLength = len(chain)
            countRecall += chainLength -  self.clusterOverlap(chain, hashSystem)
            countNormal += chainLength - 1
                
        if countNormal <> 0:
            recall = float(countRecall)/countNormal
        
        hashSystem = {}
        for chain in self.systemPredictions:
            concatenated = ""
            for markable in chain:
                concatenated += str(markable.uniqueId) + "," 
            
            for markable in chain:
                hashSystem[str(markable.uniqueId)] = concatenated
                
        countNormal = 0.
        for chain in self.goldStandard:
            chainLength = len(chain)
            countPrecision += chainLength -  self.clusterOverlap(chain, hashSystem)
            countNormal += chainLength - 1

        if countNormal <> 0:
            precision = float(countPrecision)/countNormal
        
        fmeasure = self.computeFmeasure(precision, recall)
        
        if self.verbose:
            self.log.write("MUC taking %f \n" %(time.clock()  - t1))
            self.log.flush()
        
        return {"precision": precision, "recall": recall, "fmeasure": fmeasure}
    
    def BcubedEvaluationChain(self):
        '''
        Compute the BCUBED evaluation for stored corpus data
        @return: precision, recall, f-measure
        '''
        t1 = time.clock()
        
        precision = 0.
        recall = 0.
        
        systemSingletons = self.getSingletons(self.systemPredictions)
        goldStandardSingletons = self.getSingletons(self.goldStandard)

        systemChainLength = len(self.systemPredictions) + len(systemSingletons)
        goldStandarChainLength  = len(self.goldStandard) + len(goldStandardSingletons)
             
        # put some parallelization in place so we can get faster results
        ppservers = ()
        job_server = pp.Server(ppservers=ppservers)
        
        if self.verbose:
            self.log.write( "Starting parallelization with %f workers \n" % job_server.get_ncpus() )
            self.log.flush()
        
        total = job_server.get_ncpus()
        if total > 60:
            total = 60
            
        splitSizeReference = 1.0/(total)*len(self.markables)
        jobs = []

        for index in xrange(total):
            start = int(round(index*splitSizeReference))
            stop = int(round((index+1)*splitSizeReference))
            jobs.append(job_server.submit(self.optimalBCUBED, \
                                          (start, stop, systemChainLength, goldStandarChainLength)))
        
        for job in jobs:
            result = job()
            precision += result[0]
            recall += result[1]
            
        #destroy the job server
        job_server.destroy()
        
        precision = round(precision, 3)
        recall = round(recall, 3)
        
        fmeasure  = self.computeFmeasure(precision, recall)
        
        if self.verbose:
            self.log.write("BCUBED taking %f \n" %(time.clock() - t1))
            self.log.flush()
           
        return {"precision": precision, "recall": recall, "fmeasure": fmeasure}

    def BcubedEvaluationChainEndToEnd(self):
        '''
        Computer the BCUBED evaluation for stored corpus data
        @return: precision, recall, f-measure
        '''
        t1 = time.clock()
        
        precision = 0.
        recall = 0.
          
        # compute RECALL
        # change the needed system values
        initialSystemMarkables = deepcopy(self.systemMarkables)
        initialSystemChains = deepcopy(self.systemPredictions)
        
        self.systemMarkables = self.systemRecallMarkables 
        self.systemPredictions = self.systemRecallChains
        
        # start evaluation steps        
        goldStandardSingletons = self.getSingletons(self.goldStandard)        
        goldStandarChainLength  = len(self.goldStandard) + len(goldStandardSingletons)
        
        for markable in self.markables:
            
            (goldStandardPartition, systemPartition) = self.getPartitions(markable)
            partitionOverlap = []
        
            for goldStandardMarkable in goldStandardPartition:
                for systemMarkable in systemPartition:
                    if goldStandardMarkable.uniqueId == systemMarkable.uniqueId:
                        partitionOverlap.append(goldStandardMarkable)
                        break
                
            weightRecall = 1./(len(goldStandardPartition)* goldStandarChainLength)
            markableRecallScore = float(len(partitionOverlap))/len(goldStandardPartition)
            recall += markableRecallScore * weightRecall
            
        # restore the initial values
        self.systemMarkables = initialSystemMarkables
        self.systemPredictions = initialSystemChains
                    
        # compute PRECISION
        # change the needed system values
        initialGsMarkables = deepcopy(self.markables)
        self.markables = self.gsPrecisionMarkables
        
        # start evaluation steps
        systemSingletons = self.getSingletons(self.systemPredictions)        
        systemChainLength = len(self.systemPredictions) + len(systemSingletons)
        

        for markable in self.markables:
          
            (goldStandardPartition, systemPartition) = self.getPartitions(markable)
            partitionOverlap = []
            
            for goldStandardMarkable in goldStandardPartition:
                for systemMarkable in systemPartition:
                    if goldStandardMarkable.uniqueId == systemMarkable.uniqueId:
                        partitionOverlap.append(goldStandardMarkable)
                        break
            
            weightPrecision = 1./(len(systemPartition)* systemChainLength)
            markablePrecisionScore = float(len(partitionOverlap))/len(systemPartition)
            precision += markablePrecisionScore * weightPrecision
            
        # restore to initial values
        self.markables = initialGsMarkables
        
        precision = round(precision, 2)
        recall = round(recall, 2)
        
        fmeasure  = self.computeFmeasure(precision, recall)
           
        if self.verbose:
            self.log.write("BCUBED end-to-end taking: %f \n" %(time.clock() - t1))
            self.log.flush()
        
     
        return {"precision": precision, "recall": recall, "fmeasure": fmeasure}
    
     
    def CEAFEvaluationChain(self):
        '''
        Compute the CEAF evaluation for stored corpus data
        
        The similarity metric for chains is based on how many common markables two chains share
        The metric is defined as similarity #4 in the original paper (Xiaoqiang Luo, 2005)
        similarity  = 2 |referenceChain intersects systemChain|/ (|referenceChain| + |systemChain|)
      
        @return: precision, recall, f-measure
        '''
        t1 = time.clock()
  
        # go through each element in the system and reference chains and compute the similarity metric
        singletons = self.getSingletons(self.goldStandard)        
        allReferenceChains =  singletons + self.goldStandard

        singletons = self.getSingletons(self.systemPredictions)
        allSystemChains = singletons + self.systemPredictions
        
        # sort the markables and chains depending on their original file        
        
        referenceChainsPerFile = self.sortChainsPerFile(allReferenceChains)
        systemChainsPerFile = self.sortChainsPerFile(allSystemChains)
        
        finalCost = 0.
        finalSystemSimilarities = 0.
        finalReferenceSimilarities  = 0.
        
        for file in referenceChainsPerFile.keys():
            
            # first check if the file is in the system chains as well
            if file not in systemChainsPerFile.keys():
                self.log.write("Could not locate file %s in the system responses." %file)
                self.forcedExiting()
            
            referenceChains = referenceChainsPerFile.get(file)
            systemChains = systemChainsPerFile.get(file)
            
            # AB: we have to move out of the function the calculation of the similarity matrix __
            # __ for optimization purposes, a parallel algorithm will be employed
            
            similarities = self.computeCEAFMatrix (referenceChains, systemChains)
           
            systemSimilarities = 0.
            referenceSimilarities = 0.
             
            # calculate the reference similarity
            for referenceChain in referenceChains:
                referenceSimilarities += self.computeCEAFSimilarity(referenceChain, referenceChain)
            
            # calculate the system similarity
            for systemChain in systemChains:
                systemSimilarities += self.computeCEAFSimilarity(systemChain, systemChain)
    
            # use the munkres library to compute the chain alignment
            m = Munkres()
            
            cost_matrix = make_cost_matrix(similarities, lambda cost: sys.maxint - int(100*cost))
            
            try:
                indexes = m.compute(cost_matrix)        
            except:
                if self.verbose:
                    self.log.write( "ERROR: Could not process CEAF metric. Possible issue coming from inexistent system chains.\n")
                    self.log.flush()
                self.forcedExiting()
            
            cost = 0
            for row, column in indexes:
                value = similarities[row][column]
                cost += value
            
            #store the results for final calculations across all files
            finalCost += cost
            finalSystemSimilarities += systemSimilarities
            finalReferenceSimilarities += referenceSimilarities
            
        precision = finalCost / finalSystemSimilarities
        recall = finalCost / finalReferenceSimilarities
        fmeasure = self.computeFmeasure(precision, recall)
        
        if self.verbose:
            self.log.write("CEAF taking: %f \n" %(time.clock() - t1))
            self.log.flush()
        
        return {"precision": precision, "recall": recall, "fmeasure": fmeasure}

    def CEAFEvaluationChainEndToEnd(self):
        '''
        Computer the CEAF evaluation for stored corpus data
        @return: precision, recall, f-measure
        '''
        t1 = time.clock()
        
        # compute RECALL
        # change the needed system values
        initialSystemMarkables = deepcopy(self.systemMarkables)
        initialSystemChains = deepcopy(self.systemPredictions)
        
        self.systemMarkables = self.systemRecallMarkables 
        self.systemPredictions = self.systemRecallChains
        
        results = self.CEAFEvaluationChain()
        recall  = results.get("recall")
        
        # restore the initial values
        self.systemMarkables = initialSystemMarkables
        self.systemPredictions = initialSystemChains
                    
        # compute PRECISION
        # change the needed system values
        initialGsMarkables = deepcopy(self.markables)
        self.markables = self.gsPrecisionMarkables
        
        results = self.CEAFEvaluationChain()
        precision = results.get("precision")

        # restore to initial values
        self.markables = initialGsMarkables
        
        # compute f-measure
        fmeasure = self.computeFmeasure(precision, recall)
        
        if self.verbose:
            self.log.write("CEAF end-to-end taking: %f \n" %(time.clock() - t1))
            self.log.flush()
        
     
        return {"precision": precision, "recall": recall, "fmeasure": fmeasure}

   
    def BlancEvaluationChain(self):
        '''
        Computer the BLANC evaluation for stored corpus data
        @return: (precision, recall, f-measure
        '''
        t1 = time.clock()
        
        # retrieve the right-coreferent, wrong-coreferen chains
        # as well as the right-noncorefernt, wrong-noncoreferent ones
        (rc, wc, rn, wn) = self.retrieveCoreferencePairs()
        
        rc = 1.*rc
        wc = 1.*wc
        rn = 1.*rn
        wn = 1.*wn
        
        # compute P, R, and F for coreferent pairs
        if (rc + wc) == 0  :
            if self.verbose:
                self.log.write( "ERROR: Incorrect values for BLANC evaluation\n" )
                self.log.flush()
            precisionCoref = 0
        else:    
            precisionCoref = round(rc/(rc + wc),3)
        
        if (rc + wn) == 0: 
            if self.verbose:
                self.log.write( "ERROR: Incorrect values for BLANC evaluation\n" )
                self.log.flush()
                
            recallCoref = 0
        else:   
            recallCoref = round(rc/(rc + wn),3)
            
        fmeasureCoref = self.computeFmeasure(precisionCoref, recallCoref)
        
        # compute P, R and F for non-coreferent pairs
        if (rn + wn) == 0:
            if self.verbose:
                self.log.write( "Warning: No right non-coreferent chains and no wrong non-coreferent chains found\n" )
                self.log.flush()
                
            precisionNonCoref = 1.
        else:
            precisionNonCoref = rn/(rn+wn)
            
        if (rn + wc) == 0:
            if self.verbose:
                self.log.write( "Warning: No right non-coreferent chains and no wrong coreferent chains found\n" )
                self.log.flush()
                
            recallNonCoref = 1.0
        else:
            recallNonCoref = rn/(rn+wc)
            
        fmeasureNonCoref = self.computeFmeasure(precisionNonCoref, recallNonCoref)
        
        # the BLANC P,R, and F are the average of 
        # the coreferent and non-coreferent P, R, and F respectively
        precision = (precisionCoref + precisionNonCoref)/2
        recall = (recallCoref + recallNonCoref)/2
        fmeasure  = (fmeasureCoref + fmeasureNonCoref)/2
        
        if self.verbose:
            self.log.write("BLANC taking %f \n" %(time.clock() - t1))
            self.log.flush()
           

        return {"precision": precision, "recall": recall, "fmeasure": fmeasure}

        
    def comparePairs(self, pair1, pair2):
        '''
        Determine whether two corpus markables are identical
        
        @param pair1: the first markable
        @param pair2: the second markable to be compared
        
        @return: the overlap boolean 
        '''
        overlap = False
         
        if (pair1[0].text == pair2[0].text) and (pair1[1].text == pair2[1].text):
            return True      
        
        return overlap
        
    def findEqPrediction(self, referencePair, responseOrdered):
        '''
        Determine whether the given reference pair is encountered in the response
        If the reference pair is encountered in the response we eliminate it and
        return the response minus the found pair
        
        @param referencePair: the reference pair we search for
        @param response: the response pairs
        
        @return: True/False and the response pairs  
        '''
        found = False
        toRemove = None
        
        matchingPairs = responseOrdered.get(referencePair[0].content)
        
        if matchingPairs == None:
            return (found, toRemove)
        
        if referencePair[1].content in matchingPairs:
            found = True

        return (found, toRemove)
    
    def partitionOverlap(self, goldStandardPartition, systemPartition):
        '''
        Compute the overlap between two partitions
        @param goldStandardPartition: first partition to consider for overlap
        @param systemPartition: second partition to consider for overlap
        
        @return: the overlap partition  
        '''
        overlap = []
        
        for goldStandardMarkable in goldStandardPartition:
            for systemMarkable in systemPartition:
                if goldStandardMarkable.text == systemMarkable.text and \
                   goldStandardMarkable.startPos == systemMarkable.startPos and \
                   goldStandardMarkable.startWordIndex == systemMarkable.startWordIndex:
                    overlap.append(goldStandardMarkable)
                    break
                
        return overlap
    
    def optimalBCUBED(self, start,stop, systemChainLength, goldStandarChainLength):
        precision = 0.
        recall = 0.
        
        for markable in self.markables[start:stop]:
            
            (goldStandardPartition, systemPartition) = self.getPartitions(markable)
            
            partitionOverlap = []
            for goldStandardMarkable in goldStandardPartition:
                for systemMarkable in systemPartition:
                    if goldStandardMarkable.uniqueId == systemMarkable.uniqueId:
                        partitionOverlap.append(goldStandardMarkable)
                        break
                
        
            weightPrecision = 1./(len(systemPartition)*systemChainLength) 
            weightRecall = 1./(len(goldStandardPartition)* goldStandarChainLength) 
            
            markablePrecisionScore = float(len(partitionOverlap))/len(systemPartition) 
            markableRecallScore = float(len(partitionOverlap))/len(goldStandardPartition) 
            
            precision += markablePrecisionScore * weightPrecision 
            recall += markableRecallScore * weightRecall
        
        return (precision, recall)
    
    def getPartitions(self, markable):
        '''
        Get the system generated chain to which the markable belongs
        Get the gold standard generated chain to which the markable belongs
        
        @param markable: the markable for which the partitions are generated
        
        @return: the system and gold standard partitions 
        '''
        systemPartition = []
        goldStandardPartition = []
        
        try:
            markableContent = markable.content.split("||")[0]
        except:
            if self.verbose:
                self.log.write( "Unable to process markable %s \n" %markableContent.content)
                self.log.flush()
            
            self.forcedExiting()
            
        for chain1 in self.systemPredictions:
            for chainMarkable in chain1:
                if markableContent in chainMarkable.content :
                    systemPartition = chain1
                    break
            if systemPartition <> []:
                break
        
        for chain2 in self.goldStandard:
            for chainMarkable in chain2:
                if markableContent in chainMarkable.content:
                    goldStandardPartition = chain2
                    break
            if goldStandardPartition <> []:
                break
        
        if goldStandardPartition <> [] and systemPartition == []:
            systemPartition = [markable]
        elif systemPartition <> [] and goldStandardPartition == []:
            goldStandardPartition = [markable]
        
        if goldStandardPartition == [] and systemPartition == []:
            goldStandardPartition = [markable]
            systemPartition = [markable]
            
        return (goldStandardPartition, systemPartition)
    
    def computeCEAFSimilarity(self, referenceChain, systemChain):
        '''
        Computes the similarity metric for chains based on how many common markables two chains share
        The metric is defined as similarity #4 in the original paper (Xiaoqiang Luo, 2005)
        similarity  = 2 |referenceChain intersects systemChain|/ (|referenceChain| + |systemChain|)
        
        @param referenceChain: the reference chain as read from std input
        @param systemChain: the system chain as read from std input
        
        @return: a number representing the similarity of the two chains
        '''
        partitionOverlap = self.partitionOverlap(referenceChain, systemChain)
        similarity = 2.0 * len(partitionOverlap)
        similarity = similarity/(len(referenceChain) + len(systemChain))

            
        return similarity
    
    def computeCEAFMatrix(self, referenceChains, systemChains):
        '''
        Compute the CEAF similarity matrix from the reference chains and system chains
        
        @param referenceChains: all chains included in the gold standard annotations
        @param systemChaims: all chains included in the system annotations
        
        @return: the CEAF similarity matrix  
        '''
        similarities = []

        stringGS = []
        for referenceChain in referenceChains:
            tempChain = set([])
            for markable in referenceChain:
                tempChain.add(str(markable.uniqueId))
            stringGS.append(tempChain)
        
        stringSystem = []
        for systemChain in systemChains:
            tempChain = set([])
            for markable in systemChain:
                tempChain.add(str(markable.uniqueId))
            stringSystem.append(tempChain)
        
        for referenceChain in stringGS:
              
            referenceChainLength = len(referenceChain)
            tempSimilarities = []
            
            for systemChain in stringSystem:

                partitionOverlap = referenceChain.intersection(systemChain)
                similarity = (2.0 * len(partitionOverlap))/(referenceChainLength + len(systemChain))

                tempSimilarities.append(similarity)
             
#          
            similarities.append(tempSimilarities)
                
        return similarities
        
        
    def computeFmeasure(self, precision, recall):
        '''
        Compute traditional F-Measure given precision and recall
        @param precision
        @param recall
        
        @return: the fmeasure of the given precision and recall 
        '''
        fmeasure = 0.
        
        if (precision + recall) == 0:
            if self.verbose:
                self.log.write( "ERROR: Incorrect values for precision and recall\n" )
                self.log.flush()
            fmeasure = 0
        else:
            fmeasure = 2.0*(precision*recall)/float(precision + recall)
        
        return fmeasure
    
    def clusterOverlap(self, partition, predictions ):
        '''
        Determine the number of clusters in the predictions that intersect the given partition
        @param partition
        
        @return: the number of clusters  
        '''
        overlapClusters = []
        countCoveredMarkables = 0
        
        for markable in partition:
            valueLookup = str(markable.uniqueId)
            if valueLookup in predictions.keys():
                overlapClusters.append(predictions.get(valueLookup))
                countCoveredMarkables += 1
                
        overlapClusters = list(set(overlapClusters)) 
            
        # if there is no element overlap, then we are dealing with singletons
        if len(overlapClusters) == 0:
            return len(partition)
        
        # we have to check if some of the markables were included in the system but 
        # and are singletons in the gold standard
        if countCoveredMarkables <> len(partition):
            finalLength = len(partition) - countCoveredMarkables + len(overlapClusters)
            return finalLength
        
        return len(overlapClusters)
                   
    def retrieveCoreferencePairs(self):
        '''
        Determine the number of right and wrong coreferent pairs
                  the number of right and wrong non-coreferent pairs
        
        A right pair has the same value (coreferent or non-coreferent) in the reference and system 
        A wrong pair has different values (coreferent or non-coreferent) in the reference and system
        
        @return: rc, wc, rn, wn
        '''
        allReferencePairs = self.retrievePairsFromChains(self.goldStandard)
        allSystemPairs = self.retrievePairsFromChains(self.systemPredictions)
    
        # find the union between the allSystemPairs and allReferencePairs
        # find the intersection between the allSystemPairs and allReferencePairs
        
        union = allSystemPairs + allReferencePairs
        withDuplicatesLength = len(union)
        
        #remove duplicates        
        union = list(set(union))

        intersectionLength = withDuplicatesLength - len(union )
                
        rn = len(self.markables)*((len(self.markables)-1))/2. - len(union)        
        wn =  len(allReferencePairs) - intersectionLength
        
        rc = intersectionLength
        wc = len(allSystemPairs) - rc
       
        return (rc, wc, rn, wn)
    
    def retrievePairsFromChains(self, chains):
        pairs = []
        
        for chain in chains:
            chainTexts = []
            
            if len(chain) > 1:
                for el in chain:
                    chainTexts.append(el.uniqueId)
                    
                #sort the list before generating the pairs
                chainTexts.sort()
                pairs += list(itertools.combinations(chainTexts, 2))
                
        return pairs
    
    def pairDictCreation(self, pairs, pairsDict ):
        for pair in pairs:
            if pair[0] in pairsDict.keys():
                pairsDict.get(pair[0]).append(pair[1])
            else:
                pairsDict[pair[0]] = [pair[1]]
     
    def getCombinations(self, start, stop, markablesContent, allPairs):
        markablesLength = len(markablesContent)

        for i in xrange(start, stop):
            for j in xrange(i+1, markablesLength):
                allPairs.append((markablesContent[i], markablesContent[j]))
        
   
    def getSingletons(self, chains):
        '''
        Retrieves the singleton markables - i.e. markables not in the chains param.
        
        @param chains: the reference chains
        
        @return: a list of the singletons
        '''
        
        markablesText = []
        
        #retrieve the markables text
        for markable in self.markables:
            splitMarkable = str(markable.uniqueId)
            markablesText.append(splitMarkable)
            
        for chain in chains:
            for markable in chain:
                content = str(markable.uniqueId)
                if content in markablesText:
                    markablesText.remove(content)
                            
        #retrieve the singleton markables based on their content text
        singletonMarkables = []
        for markable in self.markables:
            if str(markable.uniqueId) in markablesText:
                singletonMarkables.append([markable])
     
        return singletonMarkables
    
    def discardSingletonSystemTwinless(self):
        '''
        Go through each of the system markables and discard those that are __ 
        __ not encountered in the gold standard
        We are not discarding markables from the chains at this point, only from the list of markables 
        '''
        toRemove = []
        
        # take all markables not in the system markables
        for systemMarkable in self.systemMarkables:
            twinFound = False
            
            for gSMarkable in self.markables:
                if self.markableIdentity(systemMarkable, gSMarkable):
                    twinFound = True
                    break
            
            if not twinFound:
                toRemove.append(systemMarkable)

        
        # check if the markables are in some sort of a coreference chain in the system predictions
        for chain in self.systemPredictions:
            for markable in chain:
                for markableToBeRemoved in toRemove:
                    if self.markableIdentity(markable, markableToBeRemoved):
                        toRemove.remove(markableToBeRemoved)
                        break
        
        
        # remove the twinless markables from the 
        for markable in toRemove:
            self.systemMarkables.remove(markable)
    
    
    def discardSystemTwinless(self, systemMarkables, systemChains):
        '''
        Go through each of the system markables and discard those if they are __ 
        __ not encountered in the gold standard
        Markables are accepted if they match the head of the gold standard markables
        We do discard markables from the chains at this point, as well as from markables 
        
        @return:  a pair of the filtered markables and filtered chains
        '''
        toRemove = []
        # find all system twinless markables
        for systemMarkable in systemMarkables:
            twinFound = False
            
            for gSMarkable in self.markables:
                if self.markableIdentity(systemMarkable, gSMarkable):
                    twinFound = True
                    break
            
            if not twinFound:
                toRemove.append(systemMarkable)
        
        # remove the system twinless markbales from the markables list
        filteredMarkables = []
        for markable in systemMarkables:
            if markable not in toRemove:
                filteredMarkables.append(markable)
        
        # remove the system twinless markables from the chains
        filteredChains = []
        for chain in systemChains:
            chainCopy = []
            
            for markable in chain:
                add = True
                
                for toRemoveMarkable in toRemove:
                    if self.markableIdentity(toRemoveMarkable, markable):
                        add = False
                        break
                if add:
                    chainCopy.append(markable)
                    
            if len(chainCopy) <> 0:
                filteredChains.append(chainCopy)
        
        return (filteredMarkables, filteredChains)
                           
        
    def addTwinlessToChains(self, system1, system2):
        '''
        Add all twinless markables in system1 as singletons in system2
        
        @return: the merged markables
        '''
        toAdd = []
        
        for goldMarkable in system1:
            twinFound = False
            for systemMarkable in system2:
                if self.markableIdentity(goldMarkable, systemMarkable):
                    twinFound = True
                    break
                
            if not twinFound:
                toAdd.append(goldMarkable)
        
        for markable in system2:
            toAdd.append(markable)
        
        return toAdd
    
    def markableIdentity(self, systemMarkable, gsMarkable):
        if self.overlap == self.exactOverlap:
            return self.markableExactIdentity(systemMarkable, gsMarkable)
        else:
            return self.markablePartialIdentity(systemMarkable, gsMarkable)
        
    def markableExactIdentity(self, systemMarkable, gsMarkable):
        '''
        Check if two markables are identical
        Markables are identical if they have 
            1. the same text
            2. the same overlaps 
            3. the same semantic type
        
        @param systemMarkable: the system markable to include in comparison
        @param gsMarkable: the gold standard markable to include in comparison
        
        @return: the validity of markable identity  
        '''
        identical = False
        
        if systemMarkable.text == gsMarkable.text and  \
                    systemMarkable.startPos == gsMarkable.startPos and  \
                    systemMarkable.endPos == gsMarkable.endPos and  \
                    systemMarkable.startWordIndex == gsMarkable.startWordIndex and \
                    systemMarkable.endWordIndex == gsMarkable.endWordIndex :
#                    and systemMarkable.type == gsMarkable.type:
            identical = True
        
        return identical
    
    def markablePartialIdentity(self, systemMarkable, gsMarkable):
        '''
        Check if two markables are partially identical
        Markables are partially identical if they have 
            1. the same semantic type
            2. some of the markable text is common; 
               we check for common text by comparing the markable spans
            
        @param systemMarkable: the system markable to include in comparison
        @param gsMarkable: the gold standard markable to include in comparison
        
        @return: the validity of markable identity 
        '''
        partiallyIdentical = False
        
        if systemMarkable.type == gsMarkable.type:
            try:
                systemStartPos = int(systemMarkable.startPos)
                systemEndPos = int(systemMarkable.endPos)
                systemStartOffset = int(systemMarkable.startWordIndex)
                systemEndOffset = int(systemMarkable.endWordIndex)
            except:
                self.logMessage(self.errorMarkableProcessing, systemMarkable.content)
                self.forcedExiting()
                
            try:
                gsStartPos = int(gsMarkable.startPos)
                gsEndPos = int(gsMarkable.endPos)
                gsStartOffset = int(gsMarkable.startWordIndex)
                gsEndOffset = int(gsMarkable.endWordIndex)
            except:
                self.logMessage(self.errorMarkableProcessing, gsMarkable.startPos)
                self.forcedExiting()
                
            if systemStartPos > gsStartPos:
                if systemStartPos < gsEndPos:
                    partiallyIdentical = True
                elif systemStartPos == gsEndPos:
                    if systemStartOffset <= gsEndOffset:
                        partiallyIdentical = True
            elif systemStartPos == gsStartPos:
                if systemEndPos == gsEndPos:
                    systemList = list()
                    systemList.extend(range(systemStartOffset, systemEndOffset + 1))
                    
                    gsList = list()
                    gsList.extend(range(gsStartOffset, gsEndOffset + 1))
                    
                    if len(set(systemList).intersection(set(gsList))) > 0:
                        partiallyIdentical = True  
                elif systemEndPos > gsStartPos:
                    partiallyIdentical = True
                    
        return partiallyIdentical
    
    def sortChainsPerFile(self, chains):
        '''
        Sort the given chains based on the original file they come from
        
        @param chains: the chains to be sorted 
        
        @return: the sorted chains
        '''
        sortedChains = {}
        
        for chain in chains:
            originalFile = chain[0].fileName
            
            if originalFile in sortedChains.keys():
                sortedChains.get(originalFile).append(chain)
            else:
                sortedChains[originalFile] = [chain]
        
        return sortedChains
    
# ---------------------------------------------------------------------------
# Log handling functions
# ---------------------------------------------------------------------------
    def startLogging(self):
        if self.verbose:
            try:
                self.log = open("coreferenceLog.log", "w")
            except:
                print "ERROR: Could not create coreference log file. No log will be kept."
                self.verbose = False
                
            self.log.write("=====================================================\n")
            self.log.write("Coreference evaluation library \n")
            self.log.write("Author: Andreea Bodnari < andreeab at mit dot edu > \n")
            self.log.write("=====================================================\n\n")
            self.log.write("================== STARTING Evaluation ================== \n")
            self.log.flush()
            
    def finishLogging(self):
        if self.verbose:
            self.log.write("================== FINISHED Evaluation ================== \n\n")
            self.log.flush()
            self.log.close() 
        print "Evaluation finished successfully."
    
    def logMessage(self, messageType, attribute = None):
        if self.verbose:
            if attribute == None:
                self.log.write(messageType + "\n")
            else:
                self.log.write("%s : %s \n" %(messageType, attribute) )
            
            self.log.flush()
    
    def forcedExiting(self):
        print 'ERROR: Check the log file for more details.'
        sys.exit(-1)