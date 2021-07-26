package LeetCode;

/**
 * @author polarisChen
 * @create 2021/5/5 10:41 下午
 * 和剑指offer49一样
 */
public class _264_important {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        dp[0]=1;
        int a=0,b=0,c=0;
        for (int i = 1; i <n; i++) {
            int n1=dp[a]*2,n2=dp[b]*3,n3=dp[c]*5;
            int nn=Math.min(Math.min(n1,n2),n3);
            dp[i]=nn;
            if (dp[i]==n1){
                a++;
            }
            if (dp[i]==n2){
                b++;
            }
            if (dp[i]==n3){
                c++;
            }

        }
        return dp[n-1];
    }
}
