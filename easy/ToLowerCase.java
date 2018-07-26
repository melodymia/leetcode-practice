//Solution 1
class Solution {
    public String toLowerCase(String str) {
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z')
                str=str.replace(str.charAt(i),(char)(str.charAt(i)+'a'-'A'));
        }
        return str;
    }
}

//Solution 2 toLowerCase() method
class Solution {
    public String toLowerCase(String str) {
        String result = str.toLowerCase();
        return result;
    }
}
