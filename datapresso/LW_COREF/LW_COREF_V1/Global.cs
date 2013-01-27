using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace LW_COREF
{
    public static class WorkingDir
    {
        public static string root = "";
        public static string GlobalValue
        {
            get
            {
                return root;
            }
            set
            {
                root = value;
            }
        }
    }

    public static class Reg
    {
        public static Regex lineNumRegex = new Regex(@"[0-9]+\:");
        public static Regex ln
        {
            get
            {
                return lineNumRegex;
            }
        }

        public static Regex wordNumRegex = new Regex(@":[0-9]+");
        public static Regex wn
        {
            get
            {
                return wordNumRegex;
            }
        }

        public static Regex locationRegex = new Regex(@"[0-9]+\:[0-9]+ [0-9]+\:[0-9]+");
        public static Regex location
        {
            get
            {
                return locationRegex;
            }
        }

        public static Regex nameRegex = new Regex(@"(?<="")[a-z a-z A-Z A-Z]+[^""0-9:]+");
        public static Regex name
        {
            get
            {
                return nameRegex;
            }
        }

        public static Regex personBeginRegex = new Regex(@"<PERSON>");
        public static Regex personBegin
        {
            get
            {
                return personBeginRegex;
            }
        }

        public static Regex personEndRegex = new Regex(@"</PERSON>");
        public static Regex personEnd
        {
            get
            {
                return personEndRegex;
            }
        }
    }

    //public static class Corefs
    //{
    //    public static string[] corefs = { "I", "I'm", "I'll", "I'd", "me", "My", "my", "mine",
    //                                          "He","He'd", "He's", "He'll", "he", "he'd", "he's",
    //                                          "he'll","him", "His", "his", "She", "She'd", "She'll",
    //                                          "She's","she", "she'd", "she'll", "she's","Her", "her", "hers" };
    //    public static bool GlobalValue (string name)
    //    {
    //        get
    //        {

    //        }
    //    }
    //}
}
