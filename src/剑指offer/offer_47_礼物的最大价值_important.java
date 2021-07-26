package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/16 10:14 下午
 */
/*
* 某单元格只可能从上边单元格或左边单元格到达。
先把第一行和第一列处理一下
设 f(i, j)f(i,j) 为从棋盘左上角走至单元格 (i ,j)(i,j) 的礼物最大累计价值，
* 易得到以下递推关系：f(i,j)f(i,j) 等于 f(i,j-1)f(i,j−1) 和 f(i-1,j)f(i−1,j) 中的较大值加上当前单元格礼物价值  。

* */
public class offer_47_礼物的最大价值_important {
    public int maxValue(int[][] grid) {
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
