package DP;

/**
 * @author polarisChen
 * @create 2021/5/5 3:06 下午
 * dp[i][j]的含义就是这个字符串从第i个位置到第j个位置的子串是否是回文
 * 就是遍历所有的长度,从长度为2开始看有没有回文串,然后逐步增加长度
 * 在每个长度里,都从头到尾一个个看,但是不用每个都去判断是否回文,只需要看前后两个字符是否相同就可以
 * 如果不相同,直接false,如果相同,但长度总共只有2或3,那肯定是true,如果长度大于3,那么直接等于dp[i+1][j-1]
 */
public class _5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2){
            return s;
        }
        boolean[][] dp=new boolean[len][len];
        for (int i = 0; i <len ; i++) {
            dp[i][i]=true;
        }
        char[] x=s.toCharArray();
        int maxlen=1;
        int begin=0;
        for (int L = 2; L <= len ; L++) {
            for (int i = 0; i < len ; i++) {
                int j=L-1+i;
                if (j>=len){
                    break;
                }
                if (x[i]!=x[j]){
                    dp[i][j]=false;
                }
                else {
                    if (L<=3){
                        dp[i][j]=true;
                    }
                    else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if (dp[i][j]&&maxlen<L){
                    maxlen=L;
                    begin=i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }
}
