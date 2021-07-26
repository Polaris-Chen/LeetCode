package 剑指offer;
/*
* 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
*/
public class offer_15_二进制中1的个数_important {
    // you need to treat n as an unsigned value
    public static class Solution {

        public static int hammingWeight(int n) {
            int res = 0;
            while(n != 0) {
                //这行的目的就是判断最后一位是不是1
                res += n & 1;//与运算参考https://www.cnblogs.com/ismileboy/p/7241567.html
                n >>>= 1;
                        //算术左移<<和算术右移>>主要用来进行有符号数的倍增、减半 ；
                        //逻辑右移>>>主要用来进行无符号数的倍增、减半 ；
            }
            return res;
        }
    }


}
