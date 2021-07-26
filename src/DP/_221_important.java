package DP;

/**
 * @author polarisChen
 * @create 2021/5/5 3:34 下午
 * 核心思路就是 dp[i][j]是matrix[i][j]为右下角能组成的最大的正方形的边长
 * 任意一个点的dp值为其上下 左上三个位置dp的最小值加一,因为木桶原理  假如上面的最多只能组成边长为2的正方形
 * 那其他两个就算能组成更大的也没用
 * 如果是在最左边和最顶上,就只能组成边长为1的
 */
public class _221_important {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (matrix[i][j]=='1'){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                    }

                    max= Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
