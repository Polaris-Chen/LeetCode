package DP;



/**
 * @author polarisChen
 * @create 2021/5/5 12:24 下午
 * 就是转换成打家劫舍问题 因为你拿了一个就不能拿前后两个了,和打家劫舍非常类似
 * 所以就把所有相同的数字都加起来,当做第i个房子的价值
 *
 */
public class _740_important {

        public int deleteAndEarn(int[] nums) {
            int[] temp=new int[10001];
            for (int i=0;i<nums.length;i++){
                temp[nums[i]]+=nums[i];
            }

            int[] dp=new int[10001];
            dp[0]=0;dp[1]=temp[1];
            for (int j=2;j<dp.length;j++){
                dp[j]=Math.max(dp[j-2]+temp[j],dp[j-1]);
            }

            return dp[10000];
        }

}
