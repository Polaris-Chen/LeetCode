package DP;
//别忘了核心就是穷举
//必须要遍历到了所有情况,然后再对这些情况进行剪枝
public class _322 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for (int i = 1; i < amount+1; i++) {
            //先让min为一个不可能到达的值
            int min=amount+1;
            //对所有币值进行遍历
            for (int coin:coins){
                //如果币值超过了总值,那就啥也不干 如果所有都不行 最后dp[i]=amount+1 就证明无法组成这个值
                if (coin<=i) {
                    min = Math.min(min, dp[i - coin] + 1);
                }

            }
            dp[i]=min;
        }
        if (dp[amount]==amount+1){
            return -1;
        }
        else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        System.out.println( coinChange(new int[]{1,2,5},11));
    }
}
