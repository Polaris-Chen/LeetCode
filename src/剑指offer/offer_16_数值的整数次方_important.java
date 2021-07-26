package 剑指offer;
/*实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
* */
public class offer_16_数值的整数次方_important {
    //思路就是,x的4次方等于 x^2的平方 ,x的5次方等于  x*(x^2的平方)  也就是不断让x变大来减少n,避免了过多的循环次数
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            if (i % 2 != 0) {
                //i是奇数
                result *= x;
            }
        }
        return n < 0 ? 1.0 / result : result;
    }

}
