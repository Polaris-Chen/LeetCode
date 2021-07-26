package 剑指offer;
//简单dp
public class offer_14_1 {
    static class Solution {
        public int cuttingRope(int n) {
            int[] dp=new int[n+1];
            dp[1]=1;dp[0]=1;dp[2]=1;
            if (dp.length>2) {
                dp[3] = 2;
            }
            for (int i = 4; i < n+1; i++) {
                for (int j = i; j >i/2-1; j--) {//只要到中间就可以停了,后面都是重复的
                    int temp1=Math.max(dp[j],j);
                    int temp2=Math.max(dp[i-j],i-j);
                    dp[i]=Math.max(dp[i],temp1*temp2);
                }
            }
            return dp[n];
        }

        public static void main(String[] args) {
            Solution s=new Solution();
            System.out.println(s.cuttingRope(5));
        }
    }
}
