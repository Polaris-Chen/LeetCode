package DP;

/**
 * @author polarisChen
 * @create 2021/7/25 6:50 下午
 */
public class _08_11 {
    public int waysToChange(int n) {
        int[] coins=new int[]{1,5,10,25};
        int mod=1000000007;
        int[][] dp=new int[4][n+1];
        for (int i = 1; i <n+1 ; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <4 ; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j]=dp[i-1][j];
                for (int k = 1; k*coins[i]<=j ; k++) {
                    dp[i][j]+=k*coins[i]==j?1:dp[i-1][j-k*coins[i]];
                }
            }
        }
        System.out.println(dp[3][n]);
        return dp[3][n]%mod;
    }
}
