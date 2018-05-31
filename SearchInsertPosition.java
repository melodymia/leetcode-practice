
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target) return i;
        }
        return nums.length;  //遍历结束表明target比nums数组中所有元素都要大，因此插在最后。
    }
}
