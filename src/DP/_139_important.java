package DP;

import java.util.List;

/**
 * @author polarisChen
 * @create 2021/5/5 1:58 下午
 * dp[i]代表的是从0到i组成的字符串能否被完全拆分
 * 然后能否被拆分需要从头到尾看一遍 每个字符作为拆分点都看一下能不能
 * 前半段因为已经算过了,直接用dp[j]就可以,后半段则需要去字典里看一下有没有
 * 如果可以拆分 就直接break
 */
public class _139_important {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
