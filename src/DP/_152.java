package DP;

/**
 * @author polarisChen
 * @create 2021/5/7 8:37 下午
 * 我自己的思路是两层循环 其实就是暴力搜索 只不过加了一点dp
 * 更好的思路是记录一个最大值和最小值 
 */
public class _152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1;
            for(int i=0; i<nums.length; i++){
                if(nums[i] < 0){
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                imax = Math.max(imax*nums[i], nums[i]);
                imin = Math.min(imin*nums[i], nums[i]);

                max = Math.max(max, imax);
            }
            return max;
        }
    }
    public int maxProduct(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=1;
        dp[1]=nums[0];
        int max=Integer.MIN_VALUE;
        for (int i = 2; i < nums.length+1 ; i++) {
            int temp=1;
            int tempMax=Integer.MIN_VALUE;
            for (int j = i; j >0 ; j--) {
                temp*=nums[j-1];
                tempMax=Math.max(Math.max(dp[j-1],temp),tempMax);
            }
            System.out.println(dp[i]);
            dp[i]=tempMax;
            if (dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
