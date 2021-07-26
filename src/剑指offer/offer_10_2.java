package 剑指offer;

import java.math.BigInteger;
//一模一样的斐波那契
public class offer_10_2 {
    class Solution {
        BigInteger[] dp;
        public int numWays(int n) {
            if (n==0){
                return 1;
            }
            else if (n==1){
                return 1;
            }

            aux_numWays(n);
            int result=dp[n].mod(new BigInteger("1000000007")).intValue();
            return result;
        }
        public void aux_numWays(int n){
            dp=new BigInteger[n+1];
            dp[1]=new BigInteger("1");
            for(int i=2;i<n+1;i++){
                dp[i]=dp[i-1].add(dp[i-2]);
            }

        }
    }
}
