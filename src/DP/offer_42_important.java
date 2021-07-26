package DP;

import java.util.Arrays;

public class offer_42_important {

//dp[i−1]≤0 ，说明 dp[i - 1]dp[i−1] 对 dp[i]dp[i] 产生负贡献，即 dp[i-1] + nums[i]还不如nums[i] 本身大。

    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 1; i <nums.length ; i++) {
            if (dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }
            else {
                dp[i]=nums[i];
            }

            if (dp[i]>max){
                max=dp[i];
            }
        }

        return max;
    }

}
