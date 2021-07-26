package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author polarisChen
 * @create 2021/3/4 12:15 下午
 */
/*
*
* 动态规划问题,到第i个字符为止的串中,最长不含重复字符的子串长度为dp[i]
* 而dp[i]和dp[i-1]的关系有三种,取决于这第i个字符之前出现的位置
* 1.这第i个字符之前没出现过,那就直接加上这个字符,dp[i]=dp[i-1]+1
* 2.这个字符出现过,但是隔得很远,无所谓,也就是 i-dp[i-1] > 这个字符之前出现的位置 之前确实出现过,但反正也不在我的子串里,那也直接dp[i]=dp[i-1]+1
* 3.这个字符出现过,还就在我的子串里,那没办法了,dp[i]=i-这个字符之前出现的位置,只能要后半段了
* 用一个map记录每个字符最后出现的位置
* */
public class offer_48_最长不含重复字符的子字符串_important {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int[] dp=new int[s.length()];
        //先初始化,一定要把第一个字符加进map里
        int max=1;
        dp[0]=1;
        HashMap<Character, Integer> map= new HashMap();
        map.put(s.charAt(0),0);
        //从第二个字符开始
        for (int i = 1; i <s.length() ; i++) {
            char now=s.charAt(i);
            //情况1.2
            if (!map.containsKey(now)||map.get(now)<i-dp[i-1]){
                map.put(now,i);
                dp[i]=dp[i-1]+1;
            }
            //情况3
            else {
                dp[i]=i-map.get(now);
                map.put(now,i);
            }
            //找到dp里的最大值
            if (dp[i]>max){
                max=dp[i];
            }

        }
        return max;
    }
}
