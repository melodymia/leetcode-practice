/*
  解题思路：
  简单来看分成2种情况，一种是数组大小扩大1（最高位进位），另一种是数组大小不变（中间位数进位或不进位只加1）
  最高位进位的一定是每一位数字都是9，因此进位后最高位为1，其他位为0。
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;   //判断是否进位 1-进位 0-不进位
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp % 10;
        }
        
        //最高位进位情况
        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
