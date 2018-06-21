/*
  【经典思想】斐波那契数列
  若要计算到达第n层楼梯有多少方法，则在最后一步不是走1层就是走2层。
  即，我们可以将走到第n-1层和第n-2层的方法数目相加，即为走到第n层的方法数。
*/

class Solution {
    public int climbStairs(int n) {
        if(n<1) return 1;  //leetcode的case认为此情况输出为1
        if(n==1) return 1; 
        int[] ways = new int[n];   //动态分配数组
        ways[0]=1; ways[1]=2;   //注意：n为1时，此处可能会数组越界
        for(int i=2;i<n;i++){
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n-1];
    }
}
