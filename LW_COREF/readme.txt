LW_COREF version 0
Daniel Stewart
daniel.stewart77@gmail.com
281.781.4667


Before starting the LW_COREF application

1. Create a working directory with the following folders:
	chains		this will automatically be populated
	concepts		this will automatically be populated
	docs			save the origional source docs here
	index			this will automatically be populated
	lw_annotated	save the XCAS files from CVD here
	gold			save the gold standard documents here
	gold_converted	this will automatically be populated

2. You must have .net 4.5 install on your system

Once you have started the LW_COREF application:

1. You will immediately be prompted to select the working directory you have created.

2. Run each stage of the pipeline manually by selecting:
	Convert LW Files
	Create Chains
	Create Index Files

3. Perform a serch by typing in the Search for Names box. Predictive text and autocomplete are turned on. You can also simply, browse all available index files by pressing the dropdown arrow or using the down arrow.

4. Generate Recall, Precision, and F1 scores by pressing the Score LW button. For this utility to operate, each gold standard document must have its corresponding LanguageWare annotated document (converted to concept annotations) in the concepts folder with the same name. The utility will first convert all gold standard documents to concept annotations and save each document in the \gold_converted\ folder, then the scores will be displayed.