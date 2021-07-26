package DP;

/**
 * @author polarisChen
 * @create 2021/5/12 10:01 下午
 * dp[i][j]代表s1的前i个 s2的前j个能否组成s3的前i+j个
 * 逻辑就是如果s1的第i个和s3的第i+j个一样 就等价于dp[i-1][j]
 * s2的第j个和s3的第i+j个一样 就等价于dp[i][j-1]  因为肯定是s1s2中某一个的最后一位嘛
 * 如果都不同就刚好直接false
 */
public class _97_important {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int n=s1.length();
        int m=s2.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m; j++) {
                if (i>0){
                    dp[i][j]=dp[i][j]||(s1.charAt(i-1)==s3.charAt(i+j-1)&&dp[i-1][j]);
                }

                if (j>0){
                    dp[i][j]=dp[i][j]||(s2.charAt(j-1)==s3.charAt(i+j-1)&&dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
