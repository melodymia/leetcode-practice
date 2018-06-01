//Solution 1
class Solution {
    public int lengthOfLastWord(String s) {
        int lastwordlength=0;
        int count=0;   //统计当前单词的长度
        if(s.length()==0) return 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                count=0;
            }
            else{
                ++count;
                lastwordlength=count;
            }
        }
        return lastwordlength;
    }
}

//Solution 2 
/*
    split()函数
    public String[] split(String regex, int limit)
    regex：分割符
    limit：分割的份数
    
    注意：
    如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");
    "|" 和 "*" 等转义字符类似，也必须得加 \\。
    多个分隔符，可以用“|”作为连字符。
*/

class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] aa = s.split(" ");
        if(aa.length == 0){
            return 0;
        }
        return aa[aa.length-1].length();
    }
}
