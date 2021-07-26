package LeetCode;

import java.util.HashMap;

/**
 * @author polarisChen
 * @create 2021/7/21 3:25 下午
 */
public class _76 {
    HashMap<Character, Integer> tMap=new HashMap<>();
    HashMap<Character, Integer> sMap=new HashMap<>();
    public String minWindow(String s, String t) {
        for (int i = 0; i <t.length() ; i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0,r=0;
        int min=Integer.MAX_VALUE;
        String result="";
        while (r<s.length()){
            while (r<s.length()&&!check()){
                r++;
                sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);
            }
            if (r==s.length()&&!check()){

            }
            while (check()&&l<r){
                l++;
                sMap.put(s.charAt(r),sMap.get(s.charAt(r))-1);
            }
            if (r-l+2<min){
                result=s.substring(l-1,r+1);
                min=r-l+2;
            }
        }
        return result;
    }
    public boolean check(){
return true;
    }

}
