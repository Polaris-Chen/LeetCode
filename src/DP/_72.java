package DP;

/**
 * @author polarisChen
 * @create 2021/6/19 8:39 下午
 */
public class _72 {
    //不太懂思路 但是可以记住
    //dp[i][j]就是指word1的前i个字符需要最少几步变成Word2的前j个字符
    //转换公式可以记住一下  就是要么是前i-1个先变成j个,然后再加一个 要么是前i个先变成j-1个再加一,
    //要么就是前i-1个变成前j-1个然后看最后一个字符是否相同,如果相同就省了一步

    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        //边界初始化 空字符串变成任意字符串的步数都是等于任意字符串的长度
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=m ; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                int flag=1;
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    flag=0;
                }
                dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),
                        dp[i-1][j-1]+flag);
                System.out.println(dp[i][j]);
                System.out.println("i="+i);
                System.out.println("j="+j);
            }
        }
        return dp[n][m];
    }
}
