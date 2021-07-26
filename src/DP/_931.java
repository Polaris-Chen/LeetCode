package DP;

/**
 * @author polarisChen
 * @create 2021/5/4 3:03 下午
 *
 * 和有几种路径的问题思路都一样的 就是自底向上填充每个格子的值
 */
public class _931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                int a = dp[i + 1][j];
                if (j - 1 >= 0) {
                    b = dp[i + 1][j - 1];
                }
                if (j + 1 < m) {
                    c = dp[i + 1][j + 1];
                }
                dp[i][j] = matrix[i][j] + Math.min(Math.min(a, b), c);

            }
        }
        int min = dp[0][0];
        for (int i = 1; i < m; i++) {
            System.out.println(dp[0][i]);
            if (dp[0][i] < min) {
                min = dp[0][i];
            }
        }
        return min;
    }
}
