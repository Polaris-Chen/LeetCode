package DP.Bag;

public class Full_Bag {
    //https://www.cnblogs.com/mfrank/p/10803417.html
    public static void main(String[] args) {

        int[] value=new int[]{0,1,3,5,9};
        int[] weight=new int[]{0,2,3,4,7};
        int MaxW=10;
        System.out.println(find(value,weight,MaxW));
    }
    //就是01背包的进阶版,在考虑所有重量情况下的最大价值这一循环中再加入一个循环
    //找到在背包容量为j时,面对i号物品,拿k个i号物品能使价值最大化
    //本质还是暴力迭代,其实就是考虑了这个问题所有可能的情况找到最优解
    public static int find(int[] value,int[] weight,int MaxW){
        int n=value.length-1;
        int[][] dp=new int[n+1][MaxW+1];

        //面对i号物品
        for (int i=1;i<=n;i++){
            //考虑所有重量的情况
            for (int j=0;j<=MaxW;j++){
                //考虑所有可能的i号物品数量,其实这三个循环就是包含了这个问题所有的可能解,然后找到最优解
                for (int k=0;k*weight[i]<=j;k++){
                    //这里为什么不是dp[i-1][j]呢,因为其实k=0时就是dp[i-1][j]了
                    //已经考虑过了,其实就是dp[i][j]应该等于所有dp[i-1][j-k*weight[i]]+k*value[i])中的最大值
                   dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*weight[i]]+k*value[i]);
                }

            }

        }
        return dp[n][MaxW];
    }

}
