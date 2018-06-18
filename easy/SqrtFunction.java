//Solution 1
//牛顿迭代法求平方根
/*
  牛顿迭代法的迭代关系式：X0=X0−F(X0)/F′(X0)
  
  开根号本质上是求一个X0,使得X0^2=a,也就是求函数F(x)=x^2−a的根 
  因为F′(x)=2x,故每次迭代，x的变化值为： 
  x=x−(x^2−a)/(2x)=(x+a/x)/2
*/

class Solution {
    public int mySqrt(int x) {
        if(x<0) return Integer.MIN_VALUE;
        double err = 1e-15;      
        double t = x;      
        while (Math.abs(t - x/t) > err * t) //等价于while(Math.abs(x-t*t)>err)
            t = (x/t + t) / 2.0;  //迭代关系式
        return (int)t;
    }
}


//Solution 2
//二分法求平方根

class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
    long high=x,low=0;
       long mid,square;
       while(high-low>1){
           mid=(high+low)/2;
           square=mid*mid;
           if(square>x) high=mid;
           else if(square==x) break;
           else low=mid;
       }
       return (int)(high+low)/2;
    }
}
