package DP.Bag;

public class zero_one_Bag {
//https://blog.csdn.net/xp731574722/article/details/70766804
    public static void main(String[] args) {

        int[] value=new int[]{0,8,10,6,3,7,2};
        int[] weight=new int[]{0,4,6,2,2,5,1};
        int MaxW=12;
        System.out.println(find(value,weight,MaxW));
    }
    //dp[i][j] 表示 在面对第i件物品，且背包容量为j时所能获得的最大价值
    //其实就是暴力遍历,只不过加了备忘录所以快一点,就是对于每一个物品,把所有重量情况下的最大价值都算出来,就是j那个循环
    //后面不管用到什么都可以直接取
    public static int find(int[] value,int[] weight,int MaxW){
        int n=value.length-1;
        int[][] dp=new int[n+1][MaxW+1];
        dp[0][MaxW]=0;

        //物品从1开始
        for (int i=1;i<=n;i++){

            //对于物品i,算出所有重量情况下的最大价值
            for (int j=1;j<=MaxW;j++) {
                if (weight[i]>j){

                    //如果大于当前背包剩余的重量,则直接抛弃
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    //如果能放进去,就考虑要不要
                   dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }

        return dp[n][MaxW];
    }
}
