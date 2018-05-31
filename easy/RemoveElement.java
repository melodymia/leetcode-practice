class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null) return 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val) continue;
            nums[j++]=nums[i];
        }
        return j;
    }
}
