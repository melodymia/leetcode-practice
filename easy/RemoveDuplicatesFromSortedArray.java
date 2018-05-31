/*
  In-place Algorithms(原地算法)
  Transforming input using no auxiliary data structure. (用输出结果覆盖算法的输入，而不占用额外的数据存储空间)
  However a small amount of extra storage space is allowed for auxiliary variables. 
  The input is usually overwritten by the output as the algorithm executes.
  Usually updating input sequence through replacement or swapping of elements.
*/

//Solution 1

class Solution {
    public int removeDuplicates(int[] nums) {
        int arraysize=nums.length;
        if(nums==null) return 0;
        if(arraysize==1) return 1;  //此句可省略
        
        for(int i=0;i<arraysize-1;i++){
            if(nums[i]==nums[i+1]){
                for(int j=i;j<arraysize-1;j++) {nums[j]=nums[j+1];}  //元素前移覆盖
                arraysize=arraysize-1;
                i=i-1;     //前移后循环变量也需减1！！！
            }
        }
        return arraysize;
    }
}


//Solution 2

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        if (nums.length > 0) {
            int lastNum = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if (nums[i] != lastNum) {
                    nums[++index] = nums[i];       //++index,先自增1
                    lastNum = nums[i];             //更新成下一个不同的数字
                }
            }
        } 
        return ++index;
    }
}
