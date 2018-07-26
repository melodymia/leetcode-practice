//Solution 1 暴力解法
//bad time complexity O(N^3)

class Solution {
    public String longestPalindrome(String s) {
        int maxlength = 0;
        String result = "";
        for(int i=0;i<s.length();i++){
            for(int j=s.length();j>i;j--){
                String test=s.substring(i,j);
                if(palindrome(test)==true && test.length()>=maxlength){
                    maxlength = test.length();
                    result=test;
                }
                if(palindrome(test)==false) continue;
            }    
        }
        return result;
    }
    
    public boolean palindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)==s.charAt(s.length()-i-1)) continue;
            else return false;
        }
        return true;
    }
}


//Solution 2 动态规划

//Solution 3 中心扩展

//Solution 4 Manacher Algorithms
