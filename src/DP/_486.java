package DP;

/**
 * @author polarisChen
 * @create 2021/6/14 8:28 下午
 */

/*
* 此题dp的定义就是对于从i到j这一段数组,双方都使用最优策略的情况下,先手能比后手多多少分
* 例如[1,24,6]这一段,先手能获得的就是6-24+1=-17分
* 因此只要知道dp[0][nums.length-1]就知道先手能不能赢了
* */
public class _486 {

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];

        for (int i = 0; i <nums.length ; i++) {
            dp[i][i]=nums[i];
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            for (int j = i+1; j < nums.length; j++) {
                dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>0;
    }
}
