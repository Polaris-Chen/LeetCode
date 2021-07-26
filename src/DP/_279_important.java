package DP;

/**
 * @author polarisChen
 * @create 2021/5/5 9:53 下午
 *
 * 别人的解法更快速
 * 同样是两个循环 第二个循环不需要每个去看 只要看完全平方数的就行了
 */
public class _279_important {
    //快速的解法
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1]; // 默认初始化值都为0
            for (int i = 1; i <= n; i++) {
                dp[i] = i; // 最坏的情况就是每次+1
                for (int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
                }
            }
            return dp[n];
        }
    }
//自己的解法 慢的不行
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i = 2; i <= n ; i++) {
            if (judge(i)){
                dp[i]=1;
                //System.out.println(i);
                continue;
            }
            int min=Integer.MAX_VALUE;
            for (int j = 1; j < i ; j++) {
                min=Math.min(min,dp[j]+dp[i-j]);
            }
            dp[i]=min;
        }
        return dp[n];
    }
    public boolean judge(int x){
        int y=(int)Math.pow(x,0.5);
        int z=y*y;
        return z==x;
    }
}
