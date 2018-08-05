//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

class Solution {
    public int hammingDistance(int x, int y) {
        int z = x^y;    //异或xor运算符(二进制运算符)，运算规则：1^1=0，0^0=0，1^0=1，0^1=1
        int res = 0;
        while(z != 0) {
            if (z%2 == 1) {
                res++;
            }
            z = z/2;
        }
        return res;
    }
}
