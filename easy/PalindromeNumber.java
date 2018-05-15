//Palindrome Number（回文数）Solution 1

/*
若为负数，直接false。然后从两头开始向中间逐一比较头尾数字是否相同。

【int与string类型相互转化方法】
a) int->string
1. Integer.toString(int)
2. String.valueOf(int)
3. ""+int

b) string->int
1. Integer.parseInt(string)
2. Integer.valueOf(string).intValue()
*/

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        
        char[] num = (Integer.toString(x)).toCharArray();
        for(int i=0;i<num.length/2;i++){
            if(num[i]==num[num.length-1-i])
                continue;
            else
                return false;
        }
        return true;
    }
}




// Solution 2
/*
利用reverseInteger求余方法
*/

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{
            int temp=x;
            int result=0;
            while(x>0)
            {
                result = result * 10 + x % 10;
                x /= 10; 
            }
            if(result==temp)
                return true;
            else
                return false;
        }   
    }
}
