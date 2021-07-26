package DP;

/**
 * @author polarisChen
 * @create 2021/4/29 1:24 下午
 * <p>
 * 就是从终点开始,一步步往回推
 * 先把边上两条都填入1
 * 然后dp[i][j]的含义就是从这个点到终点有几种路径
 * 因为只能向下和向右 所以dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
 */
public class _62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
