//Longest Common Prefix Solution 1
/*
该题有2种思路，一种是横向扫描，一种是纵向扫描
此处使用的是纵向扫描，即对所有字符串，从第0位开始比较
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int num = strs.length; //字符串数组中的字符串个数
        String res = "";
        
        //处理特殊情况，即字符串数组为空时，直接输出“”
        if(num==0)
            return res;
            
        int mincharnum = strs[0].length(); //所有字符串中最短长度
        for(int i=1;i<num;i++){
            if(strs[i].length()<mincharnum)
                mincharnum = strs[i].length();
        }
        
        //纵向扫描
        for(int j=0;j<mincharnum;j++){
            for(int i=0;i<num-1;i++){
                if(strs[i].charAt(j)==strs[i+1].charAt(j))
                    continue;
                else
                    return res;
            }
            res = res + strs[0].charAt(j);
        }
        return res;
    }
}


//Solution 2 更加高效！！！
/*
此处是横向扫描，即遍历所有字符串，每次和当前得到的最大公共前缀进行比对，不断修正。
indexOf(String str)函数：返回指定字符串str在此字符串中第一次出现位置的索引
substring(int beginIndex, int endIndex)函数：返回字符串的子字符串，其中索引包括beginIndex,不包括endIndex
compareTo(type variable)函数：用于比较两者是否相等，返回0则相等，返回-1则指定的数小于variable，返回1则指定的数大于variable
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
       
        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++){
        //当strs[i].indexOf(prefix) == 0时，表明从头部开始有相同字符，所以返回的index是0
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1); //逐渐缩短字符串
                if(prefix.compareTo("") == 0)
                    return "";
            }
        }
        return prefix;
    }
}
