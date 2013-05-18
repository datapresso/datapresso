This version is made for use on Windows XP or newer operating systems.

To use:
Extract all files from the .zip file into the same directory.

Be sure that Java runtime version 1.4 or greater is installed on the machine being used.



To run, try first double clicking the start.bat file included in the .zip folder.  If that does not work open the Windows command prompt and navagate to the directory of the extracted files then enter the command 

java -jar coref.jar

at the command prompt.  If that does not work, please check your java installation.



You should see a window open, this is where you can open documents to be analyzed and see the results.

To view a sample, find the menu at the top and click open 'Files' then 'Open a Document'.  A file menu should open.  Navagate to the folder in which you extracted the filsed from the .zip file.  When you find it, navagate into the folder called 'Samples', then navagate to 'docs'.  There should be 4 documents in that folder, any of which can be opened for examination. Open one of the 4 files by either double clicking or selecting it and pressing the 'Open' button.

Once a file has been opened, the text will be visible in the main window of the program.  TO view the 'concepts' being examined for coreference, click 'Highlight Concepts' in the Operations menu item.  

To view the accuracy and precision of the Artificial Intelligence, you can select show statistics from the Operations menu.

TO get a visual of predicted and actual links, you can select from the checkboxes in the right pane of the window.  I2B2 denotes acutal gold standard links, UHD denotes predicted links.  Each item can be expanded down to individual links if that level of comparison is desired.

Since the 4 files are in the same directory, the accuracy and precision of prediction in all the files can be viewed by selecting 'Run this Directory' from the files menu.

While this version does manage to predict many of the coreferent links, it is less effective than the version used for the I2B2 challenge because the ULMS database, the database containing custom coreference information made by our team, and internet searches are not available to it for this demonstration.

