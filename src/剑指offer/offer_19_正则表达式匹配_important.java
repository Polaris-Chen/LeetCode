package 剑指offer;

public class offer_19_正则表达式匹配_important {
//非常折磨的一道题,主要还是要捋清关系  dp[i][j]的含义是s的前i个字符和p的前j个字符是否匹配
//因为需要用0表示空串,所以在charAt的时候要用i-1 j-1
/*
   共有一下这些情况
   正则表达式空:
        字符串空-->true
        字符串不空-->false
   正则表达式不空:
        字符串空:
            判断,如果是例如a*b*这样的就可以为true  <---------------------|
        字符串不空:                                                    |
            最后一位不是*:                                             |
                看最后一位s和p相不相同,相同直接返回前一个dp,不相同直接false |
            最后一位是*:                                               |
                直接删掉最后两位,看看匹不匹配   可以解决这里的判断----------
                匹配*号前的一位和s的最后一位,然后s往前一个

*/
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {//空正则的情况
                    if (i == 0) {//字符串和正则都空
                        dp[i][j] = true;
                    } else {//字符串不空
                        dp[i][j] = false;
                    }
                } else {//不空正则的情况
                    if (p.charAt(j - 1) != '*') {//这一位不是*号
                        //如果这一位能匹配上,就直接用之前的结果
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
         /***************最难的就是这里的逻辑*****************/
                    } else {//这一位是*号,就把*号和前一位看成一个整体
                        //这里只有三种情况  1.*号和前一位都不要 2.*号前一位和s最后一位匹配 3. 2.*号前一位和s最后一位不匹配

                        //情况1 j>=2是确保至少*号前还有一个字符
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];//如果这里行了,那就肯定匹配了
                        }
                        //情况2 i>=1是为了保证字符串非空 j>=2是确保至少*号前还有一个字符 后面的条件则是满足*号前一位和s最后一位匹配
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];  //|=就是dp[i][j]=dp[i][j]|dp[i - 1][j]
                            //如果上面的if满足,那就算dp[i-1][j]是false也没事
                        }
                        //情况3 不用管 dp默认就是false
                    }
                }
            }
        }
        return dp[n][m];
    }


}
