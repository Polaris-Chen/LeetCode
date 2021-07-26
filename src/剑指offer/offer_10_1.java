package 剑指offer;
//斐波那契 没啥好说的
import java.math.BigInteger;

public class offer_10_1 {
    class Solution {
        BigInteger[] dp;
        public int fib(int n) {
            if (n==0){
                return 0;
            }
            else if (n==1){
                return 1;
            }
            aux_fib(n);
            int result=dp[n].mod(new BigInteger("1000000007")).intValue();
            return result;
        }
        public void aux_fib(int n){
            dp=new BigInteger[n+1];
            dp[1]=new BigInteger("1");
            for(int i=2;i<n+1;i++){
                dp[i]=dp[i-1].add(dp[i-2]);
            }

        }
    }
}
