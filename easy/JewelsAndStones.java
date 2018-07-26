//Solution 1 
//O(N^2)
class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for(int i=0;i<J.length();i++){
            for(int j=0;j<S.length();j++){
                if(J.charAt(i)==S.charAt(j)) sum++;
            }
        }
        return sum;
    }
}


//Solution 2
//O(N)
class Solution {
    public int numJewelsInStones(String J, String S) {
        int n=0;
        for (int i = 0; i < S.length(); i++){  
            if(J.contains(S.charAt(i)+"")){            //contains函数
                  n++;
            }               
        }
       return n;
    }
}
