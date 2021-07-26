package LeetCode;

/**
 * @author polarisChen
 * @create 2021/4/27 8:08 下午
 */
public class 面试题0801 {
    public int waysToStep(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i = 1; i < n+1; i++) {
            int a=0,b=0;
            if (i-2>=0){
                a=dp[i-2];

            }
            if (i-3>=0){
                b=dp[i-3];
            }
            dp[i]=dp[i-1]+a+b;
        }
        return dp[n]%1000000007;
    }
}
