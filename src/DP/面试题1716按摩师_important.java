package DP;

/**
 * @author polarisChen
 * @create 2021/4/27 8:41 下午
 */
public class 面试题1716按摩师_important {

    public int massage(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        if (dp.length>1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i <nums.length ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
