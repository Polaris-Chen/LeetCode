package DP;

/**
 * @author polarisChen
 * @create 2021/4/29 2:33 下午
 * 和62同理 没啥区别 就是如果碰到障碍物就不加就行了
 */
public class _63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 0) {
                dp[i][n - 1] = 1;
            } else {
                break;
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            if (obstacleGrid[m - 1][j] == 0) {
                dp[m - 1][j] = 1;
            } else {
                break;
            }

        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (obstacleGrid[i + 1][j] != 1) {
                    dp[i][j] += dp[i + 1][j];
                }
                if (obstacleGrid[i][j + 1] != 1) {
                    dp[i][j] += dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
