package LeetCode;

/**
 * @author polarisChen
 * @create 2021/4/28 3:08 下午
 * 动态规划的思路就是设置一个大小为n的数组,dp[n]就是当数为n时先手的人能不能赢
 * 然后从小到大递归,对于每个数i,都找他的因数,然后去数组里找减掉这个因数后的数字 后手能不能赢,也就是!dp[i-j]
 * 然后|=就是只要这些里面有一个能赢那就能赢
 * 然后其实可以直接判断奇偶,偶数先手一定赢,奇数先手一定输
 */
public class _1025 {
    public boolean divisorGame(int n) {
        if (n==1){
            return false;
        }
        boolean[] dp=new boolean[n+1];
        dp[2]=true;
        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j <i ; j++) {
                if (i%j==0){
                    dp[i]|=!dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
