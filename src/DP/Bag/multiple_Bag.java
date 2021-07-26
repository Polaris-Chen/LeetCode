package DP.Bag;

public class multiple_Bag {
    public static void main(String[] args) {
        int[] value=new int[]{0,2,3,4};
        int[] weight=new int[]{0,3,4,5};
        int[] m=new int[]{0,4,3,2};
        int MaxW=15;
        System.out.println(find(value,weight,MaxW,m));
    }
    public static int find(int[] value,int[] weight,int MaxW,int[] m){
        int n=value.length-1;
        int[][] dp=new int[n+1][MaxW+1];

        //面对i号物品
        for (int i=1;i<=n;i++){
            //考虑所有重量的情况
            for (int j=0;j<=MaxW;j++){
                //考虑所有可能的i号物品数量,其实这三个循环就是包含了这个问题所有的可能解,然后找到最优解
                //相比完全背包只要多一个k<m[i]的条件就行了
                for (int k=0;k*weight[i]<=j&&k<m[i];k++){
                    //这里为什么不是dp[i-1][j]呢,因为其实k=0时就是dp[i-1][j]了
                    //已经考虑过了,其实就是dp[i][j]应该等于所有dp[i-1][j-k*weight[i]]+k*value[i])中的最大值
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*weight[i]]+k*value[i]);
                }

            }

        }
        return dp[n][MaxW];
    }
}
