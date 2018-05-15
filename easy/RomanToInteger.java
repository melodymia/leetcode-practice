//Roman to Integer Solution 1
/*
罗马数字一般小的在大的右侧，若小的在大的左侧，则需将大的数减小的数
e.g. IX = 5-1 = 4
关键在于判断相邻两位数字的大小关系。

回顾switch用法
*/

class Solution {
    public int romanToInt(String s) {
        int res = toNum(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(toNum(s.charAt(i))>toNum(s.charAt(i-1)))
               res = res + toNum(s.charAt(i)) - 2*toNum(s.charAt(i-1));
            else
               res = res + toNum(s.charAt(i));      
        }
        return res;
        
    }
    
    public int toNum(char ch)
    {
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
