using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LW_COREF
{
    class pos
    {
        private int begin;
        private int end;

        public void setBeg(int beg)
        {
            begin = beg;
        }
        public void setEnd(int _end)
        {
            end = _end;
        }
        public int getBeg()
        {
            return begin;
        }
        public int getEnd()
        {
            return end;
        }
    }
}
