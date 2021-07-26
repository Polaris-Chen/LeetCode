package DP;

/**
 * @author polarisChen
 * @create 2021/4/28 4:33 下午
 */
public class _746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        //dp[1]=cost[0];
        for (int i = 2; i <cost.length+1 ; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
            System.out.println(dp[i]);
        }
        return dp[cost.length];
    }
}
