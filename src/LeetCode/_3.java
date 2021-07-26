package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author polarisChen
 * @create 2021/3/10 9:06 下午
 */
public class _3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        map.put(s.charAt(0),0);

        int max=1;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for (int i = 1; i < s.length(); i++) {
            char x=s.charAt(i);
            if (!map.containsKey(x)||i-dp[i-1]>map.get(x)){
                dp[i]=dp[i-1]+1;
            }
            else {
                dp[i]=i-map.get(x);
            }
            map.put(x,i);
            if (dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
