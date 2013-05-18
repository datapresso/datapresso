'''
Created on Mar 1, 2011

@author: Andreea Bodnari
@contact: andreeab at mit dot edu
'''

# ---------------------------------------------------------------------------
# Imports
# ---------------------------------------------------------------------------

from optparse import OptionParser
from evaluationMetrics import EvaluationMetrics

# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main():
   
    use =  "Usage: %prog [options] goldStandardPath systemPredictionsPath markablesPath outputFilePath"
    
    parser = OptionParser(usage = use)
    
    parser.add_option("-q", "--quiet",  dest="quiet", 
                      default=True, action = "store_false",
                      help="Quiet the coreference evaluation process.")
    
    parser.add_option("-i", "--individualCategory",  dest="individualCategory", 
                      default=True, action = "store_false", 
                      help="Evaluate across all individual semantic categories one at a time.")
       
    (options, args) = parser.parse_args()
        
    if len(args) != 4:
        parser.error("Incorrect number of arguments or options")
        
    # mention whether we want to do the overall analysis rather than analysis 
    # at the level of each semantic category
    isEndToEnd = False
        
    EvaluationMetrics( args[:-1], args.pop(), isEndToEnd, options.individualCategory, options.quiet)
    
if __name__ == '__main__':
    main()
