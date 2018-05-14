// Reverse Integer Solution 1
/* Description:
Integer MAX_VALUE = 2147483647(2^31-1), MIN_VALUE = -2147483648(-2^31)

_463847412 -> 214748364_
Only x=1463847412 meet Integer's definition and will get normal output.
So if the first 9 digits of the result is out of range, then do overflow processing. 
*/

class Solution {
    public int reverse(int x) {
        
        int res = 0;
      
        while (x != 0) {
          //overflow processing
            if (res>Integer.MAX_VALUE/10||res<Integer.MIN_VALUE/10){
                return 0;
            } 
          //reverse integer
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
