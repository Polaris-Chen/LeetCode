package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author polarisChen
 * @create 2021/2/16 10:34 下午
 */

/*
* 思路就是一个个固定,所有字符轮流在首位,然后后面就变成了一个规模更小的子问题, 比如问abc共有几种,先确定a在首位,然后就变成了bc共有几种
* 这个思路其实和二叉树的很像
* 最后全部确定好后就放入结果中.
* 然后重复的没有意义,因为如果两个都是a开头后面的都是重复计算的,因此用一个set去掉重复
* */
public class offer_38_字符串的排列_important {
    ArrayList<String> result;

    public String[] permutation(String s) {
        result = new ArrayList<>();
        aux_permutation(s.toCharArray(), 0);
        return result.toArray(new String[result.size()]);
    }
    //i表示现在在考虑第i位,i位前的字符都已经确定,i以及后面的字符还是未确定的
    public void aux_permutation(char[] s, int i) {
        //如果到底了就把s加入结果集
        if (i == s.length) {
            result.add(String.valueOf(s));
            return;
        }
        Set<Character> set = new HashSet<>();
        //从i开始一个个轮流当首位
        for (int j = i; j < s.length; j++) {
            //如果重复了就不用再看了
            if (set.contains(s[j])) {
                continue;
            }
            //j来当首位
            swap(s, i, j);
            set.add(s[i]);
            //那么前i位也都确定好了,下一步就是去确定i+1位
            aux_permutation(s, i + 1);
            swap(s, j, i);
        }
    }

    public void swap(char[] temp, int a, int b) {
        char x = temp[a];
        temp[a] = temp[b];
        temp[b] = x;
    }

    public static void main(String[] args) {
        offer_38_字符串的排列_important s = new offer_38_字符串的排列_important();
        for (String x : s.permutation("aabc")) {
            System.out.println(x);
        }
//        String x="abc";
//        char[] s=x.toCharArray();
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }
//        System.out.println(String.valueOf(s));
    }
}
