//Solution 1 
/*
  细节注意：
  当 needle 是空字符串时，我们应当返回什么值呢？
  对于本题而言，当 needle 是空字符串时我们应当返回0。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
  可以这样解释：空字符串可以存在于任何位置，e.g. ""+str==str，空字符串在最开头的话便可以返回0。
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int m=needle.length();
        int n=haystack.length();
        if(m==0) return 0;        //被比较的字符串为空串，则返回0
        if(m>n) return -1;        //主字符串的长度不得短于被比较的字符串
        
        //i<=n-m避免溢出
        for(int i=0;i<=n-m;i++){
            if(haystack.substring(i,i+m).equals(needle))
                return i;
        }
        return -1;
    }
}


//Solution 2 (不使用系统函数)

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(needle.length()>haystack.length()) return -1;
        int index=0;
        int j=0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            index=i;
            for(j=0;j<needle.length();j++){
                //haystack.charAt(i+j)语句可以自增haystack元素
                if(haystack.charAt(i+j)!=needle.charAt(j)){break;}
            }
            if(j==needle.length()) return index;
        }
        return -1;
    }
}
