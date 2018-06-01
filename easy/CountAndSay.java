/*
  Count and say(报数序列)
  报数序列的第n项是基于第n-1项的，会统计每个数字出现的频数。
  e.g. 1->11（1个1）->21（2个1）->1211（1个2，1个1）->111221（1个1，1个2，2个1）->312211（3个1，2个2，1个1）
*/
//Solution 1

class Solution {
    public String countAndSay(int n) {
        String res = "";
        String str = "1";
        if(n==1) return "1";
        while(n>1){
            res="";
            char num = str.charAt(0);
            int count = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==num){
                    count++;
                }
                else{
                    res=res+count+num;
                    count=1;            //注意赋值为1，因为进入该条件语句表明该数字至少出现了一次。
                    num=str.charAt(i);
                    continue;
                }
            }
            res=res+count+num;
            str=res;
            --n;
        }
        return res;
    }
}



//Solution 2
//迭代思想！！！减少一层循环。

class Solution {
    public String countAndSay(int n) {
          if(n <= 0){
            return "";
        }
        if(n == 1){
            return "1";
        }
        else{
            String result = countAndSay(n-1);     //巧用迭代
            StringBuilder stringBuilder = new StringBuilder("");
            int count = 0;
            char temp = result.charAt(0);
            for(int i = 0;i<result.length();i++){
                if(temp == result.charAt(i)){
                    count++;
                }
                if(temp != result.charAt(i)){
                    stringBuilder.append(count).append(temp);
                    temp = result.charAt(i);
                    count = 1;
                }
                if(i == result.length()-1){
                    stringBuilder.append(count).append(temp);
                }
            }
            return stringBuilder.toString();
      }
  }
}
