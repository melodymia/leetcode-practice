//Solution 1
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            if(!isAlphaNum(s.charAt(left))) ++left;
            else if(!isAlphaNum(s.charAt(right))) --right;
            //注意统一字母大小写
            else if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))) return false;
            else{
                ++left; --right;
            }
        }
        return true;
    }
    
    public boolean isAlphaNum(char c){
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        if(c>='0' && c<='9') return true;
        return false;
    }
}


//Solution 2
/*
  replaceAll()方法：
  public String replaceAll(String regex, String replacement)
  regex---匹配此字符串的正则表达式
  replacement---用来替换每个匹配项的字符串
  
  \p{Punct} 为标点符号的正则表达式，\p{Space} 为空白字符的正则表达式
  正则表达式相关资料：https://www.cnblogs.com/yw0219/p/8047938.html
*/

class Solution {
    public boolean isPalindrome(String s) {
        String str=s.replaceAll("[\\p{Punct}\\p{Space}]+","");
        for(int i=0;i<str.length()/2;i++){
            if(Character.toLowerCase(str.charAt(i))==Character.toLowerCase(str.charAt(str.length()-1-i))) continue;
            else return false;
        }
        return true;
    }
    
}
