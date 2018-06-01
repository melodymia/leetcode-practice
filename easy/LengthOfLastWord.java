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
