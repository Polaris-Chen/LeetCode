package 剑指offer;

import java.util.HashMap;

public class offer_50_important {

    //哈希数组是无无序的没有关系 因为我有一个s,我每次都在s的顺序下进行 所以得到的一定是第一个没有重复的字母
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> hashMap=new HashMap<>();
        for (char x:s.toCharArray()) {
           hashMap.put(x,!hashMap.containsKey(x));
        }
        for (char x:s.toCharArray()){
            if (hashMap.get(x)){
                return x;
            }
        }
        return ' ';
    }
//大佬的解法,用数组会比哈希更快
//字符按照扩展的ASCII码也就256个 所以可以准备好足够大小的数组代替hash表
    public char firstUniqChar1(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c]++;
        for(char c : chars){
            if(count[c] == 1)
                return c;
        }
        return ' ';
    }
}
