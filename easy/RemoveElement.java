//Solution 1

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


//Solution 2
//由于不需要元素顺序一致，遍历数组时，每遇到一个目标数，就和当前数组结尾交换，并把数组大小减1。这样可以减少很多赋值操作。
public class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length, i = 0;
        while(i < size){
            if(nums[i] == val){
                nums[i]=nums[size-1];
                size--;
            } else {
                i++;
            }
        }
        return size;
    }
}
