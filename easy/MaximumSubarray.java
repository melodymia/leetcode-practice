
//Solution 1    复杂度O(N^2)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return Integer.MIN_VALUE;
        int sum=0;
        int maxsum=nums[0];
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(maxsum<sum) maxsum=sum;
            }
        }
        return maxsum;
    }
}


//Solution 2    复杂度O(N)
//对于含有正数的序列而言,最大子序列肯定是正数,所以头尾肯定都是正数。
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0],sum=0;  
        for(int i=0;i<nums.length;i++){  
            sum+=nums[i];  
            if(sum>maxSum){  
                maxSum=sum;  
            }
            if(sum<0){    //归零，从后一个元素开始寻找最大和。
                sum=0;
            }  
        }  
    return maxSum; 
    }
}


//Solution 3  复杂度O(NlogN)
/*
  divide and conquer（分治法）
  分--将问题分解为规模更小的子问题；
  治--将这些规模更小的子问题逐个击破；
  合--将已解决的子问题合并，最终得出“母”问题的解；
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return maxSubArray(0,nums.length - 1,nums);
    }
    
    public int maxSubArray(int start, int end, int[] nums){
        if (end - start == 0) return nums[start];
        
        int middle = (end + start) / 2;
        int leftMax = maxSubArray(start, middle, nums);
        int rightMax = maxSubArray(middle + 1, end, nums);
        
        int _leftMax = nums[middle];
        int temp = 0;
        for (int i = middle; i >= start; i-- ){
            temp = nums[i] + temp;
            if(temp > _leftMax) _leftMax = temp;
        }
        int _rightMax = nums[middle + 1];
        temp = 0;
        for (int i = middle + 1; i <= end; i++ ){
            temp = temp + nums[i];
            if (temp > _rightMax) _rightMax = temp;
        }
        int max = _leftMax + _rightMax;
        if (leftMax > max) max = leftMax;
        if (rightMax > max) max = rightMax;
        return max;
    }
}
