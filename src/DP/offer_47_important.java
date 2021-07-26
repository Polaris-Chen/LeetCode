package DP;
//dp的含义就是在这个位置能获得的最大收益,因为路径必定是连续的,所以要么是从上面走下来的,要么是
//从左边走过来的,递推式就得到了
public class offer_47_important {
    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1]+ grid[i][j]);
                }
                else if (i-1>=0){
                    dp[i][j]=dp[i-1][j];
                }
                else if (j-1>=0){
                    dp[i][j]=dp[i][j-1];
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
//更快速且更省空间的算法,不加一个dp数组,直接在grid数组里操作
    //因为第一行第一列的没有什么变化,不如直接先算好,省的在循环里一直判断
        public int maxValue1(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for(int j = 1; j < n; j++) // 初始化第一行
                grid[0][j] += grid[0][j - 1];
            for(int i = 1; i < m; i++) // 初始化第一列
                grid[i][0] += grid[i - 1][0];
            for(int i = 1; i < m; i++)
                for(int j = 1; j < n; j++)
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            return grid[m - 1][n - 1];
        }
    }

