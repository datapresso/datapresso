2011 I2B2 Shared Task
Rule Based Coreference Program


Authors: David Hinote <drhinote@comcast.net>, Carlos Ramirez <carlosfabianramirez@gmail.com>


The zip file contains both a compiled .jar file, and the source code for the program.  These Instructions are to help run the compiled jar file.



Things needed to run this program, must be set up prior to running the program:

64 Bit operating system, Either Windows or Linux

Java 1.6  - www.java.com , make sure to put the java directory in the path variable!

MySql 5.1.16 Database - www.mysql.com

UMLS - Any Version after 2007AA, must be loaded into the MySql Database.  Instructions to load UMLS into the database are at http://www.nlm.nih.gov/research/umls/implementation_resources/scripts/README_ORF_MySQL_Output_Stream.html

Optional Items:

BART Co-reference Tool - www.bartcoref.org

Stanford Co-Reference Tool - http://nlp.stanford.edu/software/dcoref.shtml

LingPipe NLP Software - www.lingpipe.com




Setup Instructions:

1. Unpack the Zip file into any directory.

2. Restore The "CoreferenceBackup.sql" file into the MySql Database.

3. Ensure the UMLS database is set up.

4. Open and edit the config.txt file to match the settings required for your system. The "Database" and "UMLS" information is required, BART and LingPipe Info is not necessary unless you intend to use those tools as well.

5. To run BART with this program, follow the instructions on the BART website to set up the program and place the URL to the bart server in the config file.

6. To run LingPipe with this program, follow the instructions on the lingpipe website to set up the Coreference Demo, and set the path where the lingpipe coreference batch file is located in the config.txt file.

7. To run the Stanford Tool with this system, place the java libraries for their system availabe on the stanford website in the same directory as CR.jar


To run:

1. In the console, navagate to the directory where the program was placed and run the program by entering "java -jar CR.jar -Xmx4g".

2. Sample files were included in the zip file to run this program on.  Any files processed by this system must have at least a doc, located in a "docs" folder in a directory, and concepts, located in a "concepts" folder in that same directory.  It will also use chains for evaluation if available, these must be located in the "chains" folder in that same directory.  Please view the "Samples" folder to see the format for these documents, and the necessary directory structure to read the files in.  If the document is named doc1.txt, the concepts file must be named doc1.txt.con and the chains file must be named doc1.txt.chains.

3. Once running, open a document from the "Files" menu, then the tree on the right side of the window and the "Operations" menu can be used to mark concept mentions, and discovered links.



Statistics for the document being viewed can be pulled up from the Operations menu, statistics for the entire directory can be pulled up from the Files menu and clicking "Run Directory".  "Run Directory" will also cause the program to output chains files of the detected chains in a folder called "output" in the current directory. 


Have Fun!


