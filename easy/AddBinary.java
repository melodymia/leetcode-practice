//Solution 1

class Solution {
    public String addBinary(String a, String b) {
        //比较两字符串的长度，规定a比b长，不满足则交换
        if(a.length() < b.length()){
            String temp = a;  
            a =b;  
            b = temp;  
        }  
        
        int la = a.length()-1;  
        int lb = b.length()-1;  
        int carries = 0;   //进位
        String res = "";
        
        //先从较短的字符串算起
        while(lb >= 0){
            int sum = (int)(a.charAt(la)-'0')+(int)(b.charAt(lb)-'0')+carries;  
            res = String.valueOf(sum%2)+res;    //字符串拼接，按加号前后顺序拼接。
            carries =sum/2;  
            la--;  
            lb--;  
        }  
        while(la>=0){
            int sum = (int)(a.charAt(la)-'0')+carries;  
            res = String.valueOf(sum%2)+res;  
            carries =sum/2;  
            la--;  
        }  
          
        if (carries==1){  
            res ="1"+res;
        }  
        return res;  
    }
}


//Solution 2

class Solution {
    public String addBinary(String a, String b) {
        //将两字符串变成同样长度，不足的高位补0
        while(a.length()!=b.length()){
            if(a.length()>b.length()){
                b = "0" + b;
            }else{
                a = "0"+ a;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int ta = 0;
        int tb = 0;
        int sum = 0;
        
        for(int i = a.length()-1;i>-1;i--){
            ta = a.charAt(i)-'0';
            tb = b.charAt(i)-'0';
            sum = (ta+tb+carry);
            if(sum>1){
                sb.append(sum-2);
                carry = 1;
            }else{
                sb.append(sum);
                carry = 0;
            } 
        }
        if(carry ==1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }

}


//Solution 3
//三目运算符的使用
class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int m = a.length() - 1, n = b.length() - 1, carry = 0;
        while (m >= 0 || n >= 0) {
            //巧妙利用字符的ASCII码计算
            int p = m >= 0 ? a.charAt(m--) - '0' : 0;
            int q = n >= 0 ? b.charAt(n--)- '0' : 0;
            int sum = p + q + carry;
            //巧妙利用取商和取余运算，分别得到本位的二进制结果以及跃进位的结果
            res = Integer.toString(sum % 2) + res;
            carry = sum / 2;
        }
        return carry == 1 ? "1" + res : res;
    }
}
