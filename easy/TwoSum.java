//Two Sum Solution 1

/* Description
nums[0]->nums[length-1],nums[length-2],...,nums[1]
nums[1]->nums[length-1],nums[length-2],...,nums[2]
nums[2]->nums[length-1],nums[length-2],...,nums[3]
...
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=nums.length-1;j>i;j--)
            {
                if(nums[i]+nums[j]==target)
                {
                    result[0]=i;
                    result[1]=j;
                }
                else continue;
            }
        }
        return result;
    }
}



