package DP;

/**
 * @author polarisChen
 * @create 2021/5/7 7:47 下午
 * dp[i]代表以第i个字符结尾的最长子序列的长度
 * 所以需要两个循环
 * 第一个循环从头看到尾
 * 第二个循环分别从0开始 如果第j个字符大于等于第i个字符 就不用看了
 * 然后如果小于 就看看从前j个字符加第i个字符组成的子序列的长度 也就是dp[j]+1
 * 取其中的最大值
 *
 */
public class _300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
        }
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <i; j++) {
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
