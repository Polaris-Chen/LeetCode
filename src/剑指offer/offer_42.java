package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/16 10:02 下午
 */
public class offer_42 {
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
