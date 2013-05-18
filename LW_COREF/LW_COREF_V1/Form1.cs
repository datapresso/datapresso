using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;
using System.IO;

namespace LW_COREF
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.TopMost = true;
            this.Text = "NER + Coreference => Search Tool";
            ChooseFolder();
            richTextBox1.Font = new System.Drawing.Font("Times New Roman", 12);
            richTextBox1.DetectUrls = true;
            richTextBox1.LinkClicked += richTextBox1_LinkClicked;
            search_box.AutoCompleteMode = AutoCompleteMode.SuggestAppend;
            string[] fileList = Directory.GetFiles(WorkingDir.root + @"\index\");

            for (int i = 0; i < fileList.Length; i++)
            {
                fileList[i] = fileList[i].Replace(WorkingDir.root + @"\index\", "");
                fileList[i] = fileList[i].Replace(".txt", "");
            }

            search_box.DataSource = fileList;
            search_box.AutoCompleteSource = AutoCompleteSource.CustomSource;
            search_box.AutoCompleteCustomSource.AddRange(fileList);

            try
            {
                search_box.KeyDown += search_box_KeyDown;
            }
            catch
            {
                MessageBox.Show("search_box.KeyDown Error");
            }
        }

        private void search_box_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter) 
            {
                string selectedFile = search_box.SelectedText.Replace(search_box.SelectedText,search_box.SelectedText + ".txt");
                List<string> results = new List<string>();
                using (StreamReader index_file = new StreamReader(WorkingDir.root + @"\index\" + selectedFile))
                {
                    while (!index_file.EndOfStream)
                    {
                        results.Add(index_file.ReadLine());
                        //MessageBox.Show(results[results.Count - 1]);
                    }
                }
                string personName = selectedFile.Replace(".txt", "").ToUpper();
                try
                {
                    process_results(results, personName);
                }
                catch { MessageBox.Show("Process Results Error"); }
            }
        }

        private void opn_lw_btn_Click(object sender, EventArgs e)
        {
            try
            {
                // delete all files in \\doc_root\chains
                DirectoryInfo directory = new System.IO.DirectoryInfo(WorkingDir.root + @"\concepts\");
                Empty(directory);

                string[] filePaths = Directory.GetFiles(WorkingDir.root + @"\lw_annotated\", "*.txt");

                foreach (string file in filePaths)
                {
                    FileInfo fileInfo = new FileInfo(file);
                    //MessageBox.Show(fileInfo.DirectoryName);
                    System.IO.StreamReader annotationFile = new System.IO.StreamReader(file);
                    string fileContent = annotationFile.ReadToEnd();
                    //MessageBox.Show(fileContent);
                    //MessageBox.Show(clean_lw_text(fileContent));
                    //richTextBox1.Text = clean_lw_text(fileContent);
                    //MessageBox.Show(parse_text(clean_lw_text(fileContent), fileInfo.DirectoryName, fileInfo.Name));
                    parse_text(clean_lw_text(fileContent), fileInfo.Name);
                    //richTextBox1.Text = parse_text(clean_lw_text(fileContent), fileInfo.Name);
                }
                MessageBox.Show("created " + filePaths.Length + " concept files");
            }
            catch
            {
                MessageBox.Show("LW ERROR");
                InitializeComponent();
            }
            
        }

        private string parse_text(string raw_text, string fileName)
        {
            try
            {
                List<string> test_list = new List<string>();

                System.Text.StringBuilder sb = new System.Text.StringBuilder();
                char[] fileChars = raw_text.ToCharArray();

                int i = 0;

                // drop all characters up to sofaString="
                for (; i < fileChars.Length; i++)
                {
                    if (fileChars[i] == 's' && fileChars[i + 1] == 'o' && fileChars[i + 2] == 'f' && fileChars[i + 3] == 'a' &&
                        fileChars[i + 4] == 'S' && fileChars[i + 5] == 't' && fileChars[i + 6] == 'r' && fileChars[i + 7] == 'i' &&
                        fileChars[i + 8] == 'n' && fileChars[i + 9] == 'g' && fileChars[i + 10] == '=' && fileChars[i + 11] == '\"')
                    {
                        i += 12;
                        break;
                    }
                }
                // add all characters up to "/>
                for (; i < fileChars.Length; i++)
                {
                    if (fileChars[i] == '\"' && fileChars[i + 1] == '/' && fileChars[i + 2] == '>')
                    {
                        break;
                    }
                    else
                    {
                        sb.Append(fileChars[i]);
                    }
                }

                //MessageBox.Show(sb.ToString());

                // add PersonName begin and end to list
                List<pos> testTagsList = new List<pos>();
                string begin = "", end = "";

                for (; i < fileChars.Length; i++)
                {
                    // create temp storage for begin and end
                    //pos tempTag = new pos();

                    // once begin=" is found
                    if (fileChars[i] == 'b' && fileChars[i + 1] == 'e' && fileChars[i + 2] == 'g' && fileChars[i + 3] == 'i' &&
                        fileChars[i + 4] == 'n' && fileChars[i + 5] == '=' && fileChars[i + 6] == '\"')
                    {
                        i += 7;
                        // add characters until " is found
                        while (fileChars[i] != '\"')
                        {
                            begin += fileChars[i];
                            i++;
                        }
                        i++;
                        //MessageBox.Show("found begin: " + begin);
                    }

                    // once end=" is found
                    if (fileChars[i] == 'e' && fileChars[i + 1] == 'n' && fileChars[i + 2] == 'd' && fileChars[i + 3] == '=' &&
                        fileChars[i + 4] == '\"')
                    {
                        i += 5;
                        // add characters until " is found
                        while (fileChars[i] != '\"')
                        {
                            end += fileChars[i];
                            i++;
                        }
                        //MessageBox.Show("found end: " + end);

                        // create annotation position storage
                        // convert begin and end into integers
                        pos temp = new pos();
                        temp.setBeg(Convert.ToInt32(begin));
                        begin = "";
                        temp.setEnd(Convert.ToInt32(end));
                        end = "";

                        //MessageBox.Show("Begin: " + temp.getBeg().ToString() + " End: " + temp.getEnd().ToString());

                        // add annotation position to list
                        testTagsList.Add(temp);

                        i++;
                    }
                }

                //foreach (pos tag in testTagsList)
                //{
                //    MessageBox.Show("List Begin: " + tag.getBeg().ToString() + " List End: " + tag.getEnd().ToString());
                //}

                // convert string builder back to string
                string textContent = sb.ToString();

                // create storage to named entities refered to by annotations
                List<string> entities = new List<string>();

                // remove the first annotation since it marks the boundries
                // for the entire document
                testTagsList.RemoveAt(0);

                //foreach (pos tag in testTagsList)
                //{
                //    MessageBox.Show("List Begin: " + tag.getBeg().ToString() + " List End: " + tag.getEnd().ToString());
                //}

                // add each referenced entity to list
                foreach (pos j in testTagsList)
                {
                    //MessageBox.Show("char begin: " + j.getBeg().ToString() + " char end: " + j.getEnd().ToString());
                    string temp = "";
                    for (i = j.getBeg(); i < j.getEnd(); i++)
                    {
                        temp += textContent[i];
                        //MessageBox.Show(textContent[i].ToString());
                    }
                    entities.Add(temp);
                }

                //foreach (string ent in entities)
                //{
                //    MessageBox.Show("Entity: " + ent);
                //}

                // tokenize text
                string[] sentences = Regex.Split(textContent, @"\r\n|\n");
                //MessageBox.Show("sentence size: " + sentences.Length);
                string[][] document = new string[sentences.Length][];

                for (int k = 0; k < sentences.Length; k++)
                {
                    string[] temp = Regex.Split(sentences[k], @"\s+");
                    document[k] = new string[temp.Length];
                    for (int l = 0; l < temp.Length; l++)
                    {
                        document[k][l] = temp[l];
                        //MessageBox.Show(document[k][l]);
                    }
                }

                // create coref annotation file

                // remove duplicates in entity file
                //string[] _entities = entities.Distinct().ToArray();
                string[] _entities = entities.ToArray();

                //MessageBox.Show("_entities length: " + _entities.Length.ToString());
                //MessageBox.Show("document length: " + document.Length.ToString());


                // for each entity
                for (int ent = 0; ent < _entities.Length; ent++)
                {
                    // for each line in the document
                    for (int line = 0; line < document.Length; line++)
                    {
                        // for each word in the line
                        for (int word = 0; word < document[line].Length; word++)
                        {
                            //MessageBox.Show("line length: " + document[line].Length.ToString());

                            string l_begin = "", w_begin = "", l_end = "", w_end = "";
                            string[] name = Regex.Split(entities[ent], @"\s+");



                            // if the 1st word of the entity matches the current word
                            if (name[0] == document[line][word])
                            {
                                // TODO: even if annotation file has only one named entity, if the above condition is met
                                // multiple time (especially if there is a character offset problem) each match will be written to file
                                // this could be fixed by checking the number of matchs against the size of the entity list and raising
                                // an error message when there is a conflict

                                //MessageBox.Show(" before split: " + entities[ent] + " after split: " + name[1]);
                                //MessageBox.Show("entity: " + name[0] + " word in doc: " + document[line][word]);

                                // so far match is good
                                bool match = true;
                                // record begin l:w
                                l_begin = (line + 1).ToString();
                                w_begin = word.ToString();

                                // for each following word of the entity
                                for (int m = 1, n = 1, p = 0; m < name.Length; m++, p++)
                                {
                                    // try the next word in the line (unless we've reached the ned of the line)
                                    try
                                    {
                                        //MessageBox.Show("name[m] " + name[m] + " document[line][word + m] " + document[line][word + m]);
                                        // if the next word of the entity matches the next word of the document
                                        if (document[line][word + m].Contains(name[m]))
                                        {
                                            // write (or overwrite) the end l:w of the entity
                                            l_end = (line + 1).ToString();
                                            w_end = (word + m).ToString();

                                            //MessageBox.Show("l_begin: " + l_begin + " l_end: " + l_end);
                                            //MessageBox.Show("w_begin: " + w_begin + " w_end: " + w_end);
                                        }
                                        else
                                        {
                                            match = false;
                                            //MessageBox.Show("bad match");
                                        }
                                    }
                                    // if we've reached the end of the line, go to the next line
                                    catch
                                    {
                                        // write (or overwrite) the end l:w of the entity
                                        try
                                        {
                                            if (name[m] == document[line + n][p])
                                            {
                                                l_end = (line + n + 1).ToString();
                                                w_end = p.ToString();
                                            }
                                        }
                                        catch { match = false; }
                                    }
                                }

                                if (match)
                                {
                                    if (l_end == "")
                                    {
                                        test_list.Add("c=\"" + _entities[ent] + "\" " + l_begin + ":" + w_begin + " " + l_begin + ":" + w_begin + "||t=\"person\"\r\n");
                                    }

                                    else
                                    {
                                        test_list.Add("c=\"" + _entities[ent] + "\" " + l_begin + ":" + w_begin + " " + l_end + ":" + w_end + "||t=\"person\"\r\n");
                                    }
                                }
                            }
                        }
                    }
                }

                List<string> _test_list = test_list.Distinct().ToList();

                //MessageBox.Show("_test_list size: " + _test_list.Count);

                string test_return = "";

                foreach (string test in _test_list)
                {
                    using (StreamWriter outfile = new StreamWriter(WorkingDir.root + @"\concepts\" + fileName + ".con", true))
                    {
                        outfile.Write(test);
                    }
                    test_return += test;
                }

                return test_return;
            }
            catch { MessageBox.Show("Parse Text Error"); return "Parse Text Error";}
        }

        public string clean_lw_text(string raw_text)
        {
            System.Text.StringBuilder sb = new System.Text.StringBuilder();
            char[] fileChars = raw_text.ToCharArray();

            for (int i = 0; i < fileChars.Length; i++)
            {
                if (fileChars[i] == '&' && fileChars[i + 1] == 'q' && fileChars[i + 2] == 'u' && fileChars[i + 3] == 'o' &&
                    fileChars[i + 4] == 't' && fileChars[i + 5] == ';')
                {
                    sb.Append('\"');
                    i += 5;
                }

                else if (fileChars[i] == '&' && fileChars[i + 1] == '#' && fileChars[i + 2] == '1' && fileChars[i + 3] == '3' &&
                    fileChars[i + 4] == ';')
                {
                    sb.Append('\r');
                    i += 4;
                }

                else if (fileChars[i] == '&' && fileChars[i + 1] == '#' && fileChars[i + 2] == '1' && fileChars[i + 3] == '0' &&
                    fileChars[i + 4] == ';')
                {
                    sb.Append('\n');
                    i += 4;
                }
                else if (fileChars[i] == '&' && fileChars[i + 1] == 'a' && fileChars[i + 2] == 'm' && fileChars[i + 3] == 'p' &&
                    fileChars[i + 4] == ';')
                {
                    sb.Append('&');
                    i += 4;
                }
                else if (fileChars[i] == '&' && fileChars[i + 1] == '#' && fileChars[i + 2] == '9' && fileChars[i + 3] == ';')
                {
                    sb.Append('\t');
                    i += 3;
                }

                else sb.Append(fileChars[i]);
            }

            string temp = sb.ToString();

            return temp;
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void index_btn_Click(object sender, EventArgs e)
        {
            try
            {
                string[] filePaths = Directory.GetFiles(WorkingDir.root + @"\chains\", "*.chains");

                //foreach (string file in filePaths)
                //{
                //    MessageBox.Show(file);
                //}
                create_index(filePaths);
            }
            catch
            {
                MessageBox.Show("Something's gone wrong");
                InitializeComponent();
            }
          
        }

        private void create_index(string[] filePaths)
        {
            // delete all files in \\doc_root\index
            DirectoryInfo directory = new System.IO.DirectoryInfo(WorkingDir.root + @"\index\");
            Empty(directory);
            //MessageBox.Show("list size: " + filePaths.Length.ToString());
            foreach (string file in filePaths)
            {
                FileInfo info = new FileInfo(file);
                System.IO.StreamReader conceptFile = new System.IO.StreamReader(file);
                string fileContent = conceptFile.ReadToEnd();


                using (StringReader reader = new StringReader(fileContent))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        string numbers = "", names = "";
                        string[] corefs = { "I", "I'm", "I'll", "I'd", "me", "My", "my", "mine",
                                              "He","He'd", "He's", "He'll", "he", "he'd", "he's",
                                              "he'll","him", "His", "his", "She", "She'd", "She'll",
                                              "She's","she", "she'd", "she'll", "she's","Her", "her", "hers" };
                        List<string> coref_list = corefs.ToList();
                        List<string> name_list = new List<string>();
                        List<string> number_list = new List<string>();

                        Regex locationRegex = new Regex(@"[0-9]+\:[0-9]+ [0-9]+\:[0-9]+");
                        foreach (Match match in locationRegex.Matches(line))
                        {
                            //MessageBox.Show("location match: " + match);
                            numbers += match.ToString() + "\n";
                            number_list.Add(match.ToString());
                        }

                        Regex nameRegex = new Regex(@"(?<="")[a-z a-z A-Z A-Z]+[^""0-9:]+");
                        foreach (Match match in nameRegex.Matches(line))
                        {
                            //MessageBox.Show("name match: *" + match.ToString() + "*");
                            names += match.ToString() + "\n";
                            name_list.Add(match.ToString());
                        }

                        if (name_list.Count > 0)
                        {
                            //name_list.RemoveAt(name_list.Count - 1);
                            name_list = name_list.Distinct().ToList();
                            name_list.Remove("person");

                            //int num = 0;
                            //foreach (string name in name_list)
                            //{
                            //    MessageBox.Show("name_list[" + num + "]: " + name);
                            //    num++;
                            //}

                            // if name in name list != to a name in coref list, an index will be created in that name
                            for (int i = 0; i < name_list.Count; i++)
                            {
                                if (is_coref(name_list[i]))
                                {
                                    //MessageBox.Show("removed " + name_list[i]);
                                    name_list.RemoveAt(i);
                                    i--;
                                }
                                //else
                                //{
                                //    if (i < name_list.Count) MessageBox.Show("kept " + name_list[i]);
                                //}
                            }

                            //FileInfo info = new FileInfo(openFileDialog2.FileName);
                            // MessageBox.Show(info.Directory + "\\" + "Person Name" + ".txt");

                            foreach (string goodName in name_list)
                            {
                                using (StreamWriter indexfile = new StreamWriter(WorkingDir.root + @"\index\" + goodName + ".txt", true))
                                {
                                    string newname = info.Name;
                                    newname = newname.Replace(".chains", "");
                                    //string newname = path + name;
                                    indexfile.Write(WorkingDir.root + @"\docs\" + newname + "\r\n");
                                    //MessageBox.Show("index file created: " + path + goodName + ".txt");
                                    //MessageBox.Show("path written to index file: " + /*WorkingDir.root + */ "\\docs\\" + name);

                                    foreach (string number in number_list)
                                    {
                                        // string newname = openFileDialog2.FileName.Replace(".chains", "");
                                        indexfile.Write(number + "\r\n");
                                    }
                                    indexfile.Close();
                                }
                            }
                        }
                    }
                }
            }
            int indexCount = Directory.GetFiles(WorkingDir.root + @"\index\", "*.*", SearchOption.TopDirectoryOnly).Length;
            MessageBox.Show("created " + indexCount + " index files");
        }

        public void process_results(List<string> results, string name)
        {

            string search_results = ""; // storage 

            Regex location_reg = new Regex(@"[0-9]+\:[0-9]+ [0-9]+\:[0-9]+");
            Regex line_num_reg = new Regex(@"[0-9]+\:");

            List<int> line_number_list = new List<int>();

            //MessageBox.Show(results.Count.ToString() + " search results");

            // get the first path
            for (int i = 0; i < results.Count; i++)
            {
                //MessageBox.Show("result[" + i.ToString() + "]: " + results[i]);
                // if the current line is a path to a source file
                if (!location_reg.IsMatch(results[i]))
                {
                    List<string> file_line_list = new List<string>();

                    // to use when displaying the search results
                    string source_fileName = results[i];
                    //MessageBox.Show(source_fileName);
                    // open the source file
                    StreamReader source_file = new StreamReader(results[i]);
                    // save it's contents to list
                    while (!source_file.EndOfStream)
                    {
                        //string temp = hit_file.ReadLine();
                        //MessageBox.Show("hit file line: " + temp);
                        // add each line to a list
                        file_line_list.Add(source_file.ReadLine());
                    }
                    i++;

                    // until the next path
                    try
                    {
                        while (location_reg.IsMatch(results[i]) && i < results.Count)
                        {
                            //MessageBox.Show("location match - results[" + i.ToString() + "]: " + results[i]);
                            // 1st remove the word numbers
                            string match = line_num_reg.Match(results[i]).ToString();
                            match = match.Replace(":", "");
                            // add line numbers to list
                            line_number_list.Add(Convert.ToInt32(match));
                            //MessageBox.Show("line number saved to list: " + match);

                            // save the line number of the document to the search results string

                            List<string> words = file_line_list[Convert.ToInt32(match) - 1].Split(' ', ',', '.', ';', ':', '"').ToList();
                            for (int word = 0; word < words.Count; word++)
                            {
                                if (is_coref(words[word]))
                                {
                                    words[word] = name;
                                }
                            }
                            string temp_results = "";
                            foreach (string word in words)
                            {
                                temp_results += word + ' ';
                            }

                            search_results += temp_results + "\r\n";
                            // save the link to the source file to the results string
                            search_results += "\r\nfile:/" + source_fileName + "\r\n\r\n";

                            i++;
                        }
                        i--;
                    }
                    catch { i--; }
                }
            }

            richTextBox1.Clear();
            richTextBox1.Text = search_results;
            

            //MessageBox.Show(search_results);

            Regex nameMatch = new Regex(name, RegexOptions.IgnoreCase);
           // MessageBox.Show(richTextBox1.Text);
            foreach (Match match in nameMatch.Matches(richTextBox1.Text))
            {
                //MessageBox.Show("highlight match: " + match.ToString() + " " + match.Index + " " + match.Length);
                richTextBox1.Select(match.Index, match.Length);
                richTextBox1.SelectionBackColor = Color.Yellow;
            }
        }

        public System.Diagnostics.Process p = new System.Diagnostics.Process();

        private void richTextBox1_LinkClicked(object sender,
        System.Windows.Forms.LinkClickedEventArgs e)
        {
            // Call Process.Start method to open a browser
            // with link text as URL.
            p = System.Diagnostics.Process.Start("EXPLORER.EXE", e.LinkText);
        }

        private void chain_btn_Click(object sender, EventArgs e)
        {
            create_chains();
        }

        public void create_chains()
        {
            // delete all files in \\doc_root\chains
            DirectoryInfo directory = new System.IO.DirectoryInfo(WorkingDir.root + @"\chains\");
            Empty(directory);
            // store each file in /concepts
            string[] conceptPaths = Directory.GetFiles(WorkingDir.root + @"\concepts\", "*.con");
            // process each file
            //int fileNum = 1;
            foreach (string conceptFile in conceptPaths)
            {
                List<Tuple<string, int, int, string>> entity_list = new List<Tuple<string, int, int, string>>();
                List<Tuple<string, int, int, string>> coref_list = new List<Tuple<string, int, int, string>>();
                // get the file name (for creating the .chains file)
                FileInfo info = new FileInfo(conceptFile);
                // open the concept file
                System.IO.StreamReader annotationFile = new System.IO.StreamReader(conceptFile);
                // store file contents into new string
                string fileContent = annotationFile.ReadToEnd();
                // process each line of the file
                using (StringReader reader = new StringReader(fileContent))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        //MessageBox.Show(line);
                        var con = parse_concept(line);
                        //MessageBox.Show(con.Item1 + " " + con.Item2 + " " + con.Item3 + " " + con.Item4);
                        // if concept is an entity
                        if (!is_coref(con.Item1))
                        {
                            // add to entity list
                            //MessageBox.Show(con.Item1 + " is an entity");
                            entity_list.Add(con);

                        }
                        // if concept is a cofrefernce
                        else
                        {
                            // add to coreference list
                            //MessageBox.Show(con.Item1 + " is a corefernece");
                            coref_list.Add(con);
                        }
                    }

                    // sort lists by line number
                    entity_list = entity_list.OrderBy(a => a.Item2).ThenBy(a => a.Item3).ToList();
                    coref_list = coref_list.OrderBy(a => a.Item2).ThenBy(a => a.Item3).ToList();

                    //foreach (Tuple<string, int, int, string> ent in entity_list)
                    //{
                    //    MessageBox.Show("file number " + fileNum + ": " + ent.Item1 + " " + ent.Item4);
                    //}
                    //fileNum++;

                    int entityCount = entity_list.Count;
                    //MessageBox.Show("entity list count: " + entityCount);
                    // match entity to coreference
                    for (int i = 0; i < entity_list.Count; i++)
                    {
                        string chain = "blank due to earlier entity rule";
                        entityCount--;
                        // if the current entity is the last entity on the page
                        if (entityCount == 0)
                        {
                            // build a chain with all remaining coreferences
                            chain = "c=\"" + entity_list[i].Item1 + "\" " + entity_list[i].Item4 + "||";
                            foreach (Tuple<string, int, int, string> coref in coref_list)
                            {
                                chain += "c=\"" + coref.Item1 + "\" " + coref.Item4 + "||";
                            }
                        }
                        // if there's more than one entity remaining on the page
                        else
                        {
                            chain = "c=\"" + entity_list[i].Item1 + "\" " + entity_list[i].Item4 + "||";
                            // if the current coref is located after the current entity but before the next entity
                            for (int j = 0; j < coref_list.Count; j++ )
                            {
                                // if the coref is on a later line
                                if ((coref_list[j].Item2 > entity_list[i].Item2 ||
                                    // or the same line but a later word
                                    (coref_list[j].Item2 == entity_list[i].Item2 && coref_list[j].Item3 > entity_list[i].Item3)) &&
                                    // and if the coref is on an earlier line than the next entity
                                    (coref_list[j].Item2 < entity_list[i + 1].Item2 ||
                                    // or is on the same line but an earlier word
                                    (coref_list[j].Item2 == entity_list[i + 1].Item2 && coref_list[j].Item3 < entity_list[i + 1].Item3)))
                                {
                                    chain += "c=\"" + coref_list[j].Item1 + "\" " + coref_list[j].Item4 + "||";
                                    coref_list.Remove(coref_list[j]);
                                    j--;
                                }
                            }
                        }
                        //MessageBox.Show(chain);
                        string goodName = info.Name;
                        goodName = goodName.Replace(".con", "");
                        // write each chain to chain file
                        using (StreamWriter chainFile = new StreamWriter(WorkingDir.root + @"\chains\" + goodName + ".chains", true))
                        {
                            chainFile.Write(chain + "\r\n");
                        }
                    }
                }
            }
            MessageBox.Show("created " + conceptPaths.Length + " chain files");
        }

        public Tuple<string, int, int, string> parse_concept(string concept)
        {
            // parse name from line
            var nameRegex = Reg.nameRegex;
            var lineNumRegex = Reg.lineNumRegex;
            var wordNumRegex = Reg.wordNumRegex;
            var locationRegex = Reg.locationRegex;

            string line = lineNumRegex.Match(concept).ToString();
            line = line.Replace(":", "");
            string word = wordNumRegex.Match(concept).ToString();
            word = word.Replace(":", "");

            return new Tuple<string, int, int, string>(
                nameRegex.Match(concept).ToString(),
                Convert.ToInt32(line),
                Convert.ToInt32(word),
                locationRegex.Match(concept).ToString());
        }

        public bool is_coref(string name)
        {
            string[] corefs = { "I", "I'm", "I'll", "I'd",
                                  "me", "My", "my", "mine",
                                  "He","He'd", "He's", "He'll",
                                  "he", "he'd", "he's", "he'll",
                                  "him", "His", "his",
                                  "She", "She'd", "She'll", "She's",
                                  "she", "she'd", "she'll", "she's",
                                  "Her", "her", "hers" };
            foreach (string coref in corefs)
            {
                if (coref == name)
                {
                    return true;
                }
                //else MessageBox.Show("*" + coref + "!=" + name + "*");
            }
            return false;
        }

        public void Empty(DirectoryInfo directory)
        {
            foreach (FileInfo file in directory.GetFiles()) file.Delete();
            foreach (DirectoryInfo subDirectory in directory.GetDirectories()) subDirectory.Delete(true);
        }

        private void search_box_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void set_dir_btn_Click(object sender, EventArgs e)
        {
            ChooseFolder();
        }

        public void ChooseFolder()
        {
            if (folderBrowserDialog1.ShowDialog() == DialogResult.OK)
            {
                WorkingDir.root = folderBrowserDialog1.SelectedPath;
            }
        }

        private void folderBrowserDialog1_HelpRequest(object sender, EventArgs e)
        {
            this.Text = "Select the root directory for this project";
        }

        private void scoreLW_btn_Click(object sender, EventArgs e)
        {
            parse_gold();
            score();
        }

        private void parse_gold()
        {
            // empty gold folder
            DirectoryInfo directory = new System.IO.DirectoryInfo(WorkingDir.root + @"\gold_converted\");
            Empty(directory);
            // get all files in gold folder
            string[] goldPaths = Directory.GetFiles(WorkingDir.root + @"\gold\", "*.txt");
            // for each gold standard file
            foreach (string path in goldPaths)
            {
                // open file
                System.IO.StreamReader goldFile = new System.IO.StreamReader(path);
                // store file contents into new string
                string fileContent = goldFile.ReadToEnd();
                // process each line of the file

                // tokenize text
                // create storage for sentences and split text into sentences
                string[] sentences = Regex.Split(fileContent, @"\r\n|\n");
                // create storege for all tokens in text
                string[][] document = new string[sentences.Length][];
                // for each sentence
                for (int sentence = 0; sentence < sentences.Length; sentence++)
                {
                    // split sentence into tokens
                    string[] temp = Regex.Split(sentences[sentence], @"\s+");
                    document[sentence] = new string[temp.Length];
                    for (int word = 0; word < temp.Length; word++)
                    {
                        document[sentence][word] = temp[word];
                    }
                }
                // get info belonging to gold file
                FileInfo info = new FileInfo(path);
                // get file name from info
                string fileName = info.Name;
                // remove .txt from file name
                fileName = fileName.Replace(".txt", "");

                // create concept file
                using (StreamWriter conceptFile = new StreamWriter(WorkingDir.root + @"\gold_converted\" + fileName + "_converted.txt", true))
                {
                    for (int sentence = 0; sentence < document.Length; sentence++ )
                    {
                        bool foundPerson = false;
                        int beginLine = 0, beginWord = 0, endLine = 0, endWord = 0;
                        for (int token = 0; token < document[sentence].Length; token++ )
                        {
                            
                            // if token matches <PERSON>some...
                            if (Reg.personBeginRegex.IsMatch(document[sentence][token]))
                            {
                                foundPerson = true;
                                // save the location of the 1st word of the name
                                beginLine = sentence; beginWord = token;
                                // remove the tag from the token
                                document[sentence][token] = document[sentence][token].Replace("<PERSON>", ""); 
                                // write concept mention to file
                                conceptFile.Write("c=\"" + document[sentence][token].Replace("</PERSON>", ""));
                                //MessageBox.Show("person begin: " + "document[" + sentence + "][" + token + "]" + document[sentence][token]);
                            }
                            // if token matches ...name</PERSON>
                            if (Reg.personEndRegex.IsMatch(document[sentence][token]))
                            {
                                //MessageBox.Show("person end: " + document[sentence][token]);
                                foundPerson = false;
                                // save the location of the last word of the name
                                endLine = sentence; endWord = token;
                                // remove the tag from the token
                                document[sentence][token] = document[sentence][token].Replace("</PERSON>", "");
                                //MessageBox.Show(document[sentence][token]);
                                // write concept mention to file
                                // if the entity name is only one token
                                if (beginLine == endLine && beginWord == endWord)
                                {
                                    conceptFile.Write("\" " + (beginLine + 1) + ":" + beginWord + " " + (endLine + 1) + ":" + endWord + "||t=\"person\"\r\n");
                                }
                                // if the entity name is multilpe tokens
                                else
                                {
                                    conceptFile.Write(" " + document[sentence][token] + "\" " + (beginLine + 1) + ":" + beginWord + " " + (endLine + 1) + ":" + endWord + "||t=\"person\"\r\n");
                                }
                            }
                            // if a name has been found but the end of the name hasn't been reached
                            else if (foundPerson && !(sentence == beginLine && token == beginWord))
                            {
                                //MessageBox.Show("person middle: " + document[sentence][token]);
                                conceptFile.Write(" " + document[sentence][token]);
                            }

                                    
                        }
                    }
                }
            }
        }

        private void score()
        {
            // get document paths from gold directory
            string[] goldPaths = Directory.GetFiles(WorkingDir.root + @"\gold_converted", "*.txt");
            string[] lwPaths = Directory.GetFiles(WorkingDir.root + @"\concepts", "*.con");

            int total_gold_entites = 0, total_lw_entities = 0;

            //MessageBox.Show("gold: " + goldPaths.Length + " lw " + lwPaths.Length);

            // sort each folder so that each corresponding file will be matched
            Array.Sort(goldPaths);
            Array.Sort(lwPaths);

            // make sure that there are the same number of files in each folder
            if (goldPaths.Length == lwPaths.Length)
            {
                int total_gold = 0, total_lw = 0, correct = 0;
                for (int i = 0; i < goldPaths.Length; i++)
                {
                    List<Tuple<int, int, int, int>> gold_entities = get_entities(goldPaths[i]);
                    List<Tuple<int, int, int, int>> lw_entities = get_entities(lwPaths[i]);

                    // add entity count for metric tracking
                    total_gold_entites += gold_entities.Count;
                    total_lw_entities += lw_entities.Count;

                    //string gold = "", lw = "";
                    //for (int d = 0; d < gold_entities.Count; d++)
                    //{
                    //    gold += gold_entities[d].ToString() + "\r\n";
                    //}
                    //for (int d = 0; d < lw_entities.Count; d++)
                    //{
                    //    lw += lw_entities[d].ToString() + "\r\n";
                    //}

                    //MessageBox.Show("GOLD:\r\n" + gold + "\r\n\r\nLW:\r\n" + lw);

                    // get totals for each file
                    total_gold += gold_entities.Count;
                    total_lw += lw_entities.Count;

                    // get correct count
                    for (int j = 0; j < lw_entities.Count; j++)
                    {
                        for (int k = 0; k < gold_entities.Count; k++)
                        {
                            if (lw_entities[j].Equals(gold_entities[k]))
                            {
                                correct++;
                            }
                        }
                    }

                    // add results from current file pair to metrics
                    // create storage for scoring metrics
                    // Tuple < total gold entities , total lw entities , correct lw entities >
                    //Tuple<int, int, int> metrics = new Tuple<int, int, int>(total_gold, total_lw, correct);
                    //MessageBox.Show("total gold: " + total_gold + " total lw: " + total_lw + " correct: " + correct);
                }

                float precision = (float)correct / total_lw_entities;
                float recall = (float)correct / total_gold_entites;
                float f1 = 2 * (precision * recall) / (precision + recall);

                richTextBox1.Font = new System.Drawing.Font("Times New Roman", 12);
                richTextBox1.Text = goldPaths.Length.ToString() + " files scored:\r\n\r\n" +
                "Gold standard entities:\t" + total_gold_entites + "\r\n" +
                "LanguageWare entities:\t" + total_lw_entities + "\r\n" +
                "Correct LW entities:\t\t" + correct + "\r\n\r\n" +
                "Precision:\t\t" + precision.ToString() + "\r\n" +
                "Recall:\t\t\t" + recall.ToString() + "\r\n" +
                "F1:\t\t\t" + f1.ToString();
            }
            // if there are different number of files in the gold and concepts folder
            else
            {
                MessageBox.Show("ERROR: all files in concepts folder must correspond with a file in gold folder\r\n" +
                "gold standrd files: " + goldPaths.Length + "\r\nconcept files: " + lwPaths.Length);
            }
        }

        private List <Tuple<int, int, int, int>> get_entities(string path)
        {
            // create storage for entity locations
            List<Tuple<int, int, int, int>> entities = new List<Tuple<int,int,int,int>>();
            // open current document
            System.IO.StreamReader documentText = new System.IO.StreamReader(path);

            // read each line in file
            while (!documentText.EndOfStream)
            {
                string line = documentText.ReadLine();
                if (Reg.lineNumRegex.IsMatch(line) && Reg.wordNumRegex.IsMatch(line))
                {
                    // locations will be in the form: ll:ww ll:ww
                    // extract both line and word locations
                    if (Reg.lineNumRegex.Matches(line).Count != 2 || Reg.wordNumRegex.Matches(line).Count != 2)
                    {
                        MessageBox.Show("Concept file formatting error: " + path);
                    }
                    else
                    {
                        int count = 0, beginLine = 0, beginWord = 0, endLine = 0, endWord = 0;
                        foreach (Match match in Reg.lineNumRegex.Matches(line))
                        {
                            if (count == 0)
                            {
                                // remove non integers
                                string temp = match.ToString();
                                temp = temp.Replace(":", "");
                                beginLine = Convert.ToInt32(temp);
                                count++;
                            }
                            else
                            {
                                // remove non integers
                                string temp = match.ToString();
                                temp = temp.Replace(":", "");
                                endLine = Convert.ToInt32(temp);
                                count = 0;
                            }
                        }

                        foreach (Match match in Reg.wordNumRegex.Matches(line))
                        {
                            if (count == 0)
                            {
                                // remove non integers
                                string temp = match.ToString();
                                temp = temp.Replace(":", "");
                                beginWord = Convert.ToInt32(temp);
                                count++;
                            }
                            else
                            {
                                // remove non integers
                                string temp = match.ToString();
                                temp = temp.Replace(":", "");
                                endWord = Convert.ToInt32(temp);
                                count = 0;
                            }
                        }

                        // save the extracted entity locations in entity list
                        entities.Add(new Tuple<int, int, int, int>(beginLine, beginWord, endLine, endWord));
                    }
                }
            }
            return entities;
        }
    }
}
