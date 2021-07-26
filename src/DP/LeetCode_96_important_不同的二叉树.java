package DP;

/*
dp[i]代表的是i个数字能组成多少种二叉搜索树
* 就是分成两层循环 第一层循环代表总长度为i的能组成多少种 第二层循环代表这个长度里面,每个元素当根能产生多少种
* 就是以j为根 左边有j-1个数, 右边有i-j个数,后面这个不需要从0开始 反正有几个数就是dp几
* */

public class LeetCode_96_important_不同的二叉树 {

    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i = 2; i < n + 1; i++)
                for(int j = 1; j < i + 1; j++)
                    dp[i] += dp[j-1] * dp[i-j];

            return dp[n];
        }

    }


}
