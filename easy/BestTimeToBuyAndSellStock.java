//Solution 1
//复杂度O(n^2)
class Solution {
    public int maxProfit(int[] prices) {
        int diff = 0;
        int maxprof = 0;
        for(int i=0;i<prices.length;i++){
             diff=0;
             for(int j=i+1;j<prices.length;j++){
                 if(prices[j]<prices[i]) continue;
                 diff = prices[j]-prices[i];
                 if(diff>maxprof) maxprof=diff;
             }
         }
        return maxprof;
    }
}

//Solution 2  时间复杂度O(n)
/*
  思路：首先确定后一个数大于前一个数，若满足前述条件，则计算两者之差，最终保留最大值。
*/
class Solution {
    public int maxProfit(int[] prices) {
       if(prices==null||prices.length==0){
            return 0;
        }
        
       int min = prices[0];
       int result = 0; 
       for(int i=0;i<prices.length;i++) {
           if(prices[i] < min){
              min =prices[i];     //找到相对最小的起始值
           }else if(prices[i] - min > result){
              result = prices[i] - min ;   //找到最大差值(最大利润)
           }
      }
        return result;
    }
}


//Solution 3
class Solution {
    public int maxProfit(int[] prices) {
        int temp = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length ; i++) {
                sum = Math.min(sum,prices[i]);
                temp = Math.max(temp,prices[i]-sum);
        }
        return temp;
    }
}
