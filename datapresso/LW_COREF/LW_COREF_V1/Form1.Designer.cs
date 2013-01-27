namespace LW_COREF
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.opn_lw_btn = new System.Windows.Forms.Button();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.index_btn = new System.Windows.Forms.Button();
            this.chain_btn = new System.Windows.Forms.Button();
            this.search_box = new System.Windows.Forms.ComboBox();
            this.search_label = new System.Windows.Forms.Label();
            this.set_dir_btn = new System.Windows.Forms.Button();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.scoreLW_btn = new System.Windows.Forms.Button();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // opn_lw_btn
            // 
            this.opn_lw_btn.Location = new System.Drawing.Point(119, 3);
            this.opn_lw_btn.Name = "opn_lw_btn";
            this.opn_lw_btn.Size = new System.Drawing.Size(124, 62);
            this.opn_lw_btn.TabIndex = 0;
            this.opn_lw_btn.Text = "Convert LW Files";
            this.opn_lw_btn.UseVisualStyleBackColor = true;
            this.opn_lw_btn.Click += new System.EventHandler(this.opn_lw_btn_Click);
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(35, 86);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(868, 570);
            this.richTextBox1.TabIndex = 1;
            this.richTextBox1.Text = "";
            this.richTextBox1.TextChanged += new System.EventHandler(this.richTextBox1_TextChanged);
            // 
            // index_btn
            // 
            this.index_btn.Location = new System.Drawing.Point(362, 3);
            this.index_btn.Name = "index_btn";
            this.index_btn.Size = new System.Drawing.Size(125, 62);
            this.index_btn.TabIndex = 2;
            this.index_btn.Text = "Create Index Files";
            this.index_btn.UseVisualStyleBackColor = true;
            this.index_btn.Click += new System.EventHandler(this.index_btn_Click);
            // 
            // chain_btn
            // 
            this.chain_btn.Location = new System.Drawing.Point(249, 3);
            this.chain_btn.Name = "chain_btn";
            this.chain_btn.Size = new System.Drawing.Size(105, 62);
            this.chain_btn.TabIndex = 5;
            this.chain_btn.Text = "Create Chains";
            this.chain_btn.UseVisualStyleBackColor = true;
            this.chain_btn.Click += new System.EventHandler(this.chain_btn_Click);
            // 
            // search_box
            // 
            this.search_box.FormattingEnabled = true;
            this.search_box.Location = new System.Drawing.Point(661, 17);
            this.search_box.Name = "search_box";
            this.search_box.Size = new System.Drawing.Size(233, 24);
            this.search_box.TabIndex = 6;
            this.search_box.SelectedIndexChanged += new System.EventHandler(this.search_box_SelectedIndexChanged);
            // 
            // search_label
            // 
            this.search_label.AutoSize = true;
            this.search_label.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.search_label.Location = new System.Drawing.Point(493, 0);
            this.search_label.Name = "search_label";
            this.search_label.Padding = new System.Windows.Forms.Padding(1);
            this.search_label.Size = new System.Drawing.Size(126, 21);
            this.search_label.TabIndex = 7;
            this.search_label.Text = "Search for Names";
            // 
            // set_dir_btn
            // 
            this.set_dir_btn.Location = new System.Drawing.Point(3, 3);
            this.set_dir_btn.Name = "set_dir_btn";
            this.set_dir_btn.Size = new System.Drawing.Size(110, 62);
            this.set_dir_btn.TabIndex = 8;
            this.set_dir_btn.Text = "Change Working Directory";
            this.set_dir_btn.UseVisualStyleBackColor = true;
            this.set_dir_btn.Click += new System.EventHandler(this.set_dir_btn_Click);
            // 
            // folderBrowserDialog1
            // 
            this.folderBrowserDialog1.Description = "Select the working directory for this project";
            this.folderBrowserDialog1.HelpRequest += new System.EventHandler(this.folderBrowserDialog1_HelpRequest);
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 5;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 47.15447F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 52.84553F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 113F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 131F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 134F));
            this.tableLayoutPanel1.Controls.Add(this.set_dir_btn, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.opn_lw_btn, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.chain_btn, 2, 0);
            this.tableLayoutPanel1.Controls.Add(this.index_btn, 3, 0);
            this.tableLayoutPanel1.Controls.Add(this.search_label, 4, 0);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(35, 17);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(625, 68);
            this.tableLayoutPanel1.TabIndex = 9;
            // 
            // scoreLW_btn
            // 
            this.scoreLW_btn.Location = new System.Drawing.Point(786, 56);
            this.scoreLW_btn.Name = "scoreLW_btn";
            this.scoreLW_btn.Size = new System.Drawing.Size(99, 23);
            this.scoreLW_btn.TabIndex = 10;
            this.scoreLW_btn.Text = "Score LW";
            this.scoreLW_btn.UseVisualStyleBackColor = true;
            this.scoreLW_btn.Click += new System.EventHandler(this.scoreLW_btn_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(923, 832);
            this.Controls.Add(this.scoreLW_btn);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Controls.Add(this.search_box);
            this.Controls.Add(this.richTextBox1);
            this.Name = "Form1";
            this.Padding = new System.Windows.Forms.Padding(1);
            this.Text = "Form1";
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button opn_lw_btn;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.Button index_btn;
        private System.Windows.Forms.Button chain_btn;
        private System.Windows.Forms.ComboBox search_box;
        private System.Windows.Forms.Label search_label;
        private System.Windows.Forms.Button set_dir_btn;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Button scoreLW_btn;
    }
}

