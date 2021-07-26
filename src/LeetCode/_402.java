package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author polarisChen
 * @create 2021/7/21 4:29 下午
 */
public class _402 {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        //用这个代替栈
        StringBuilder stack = new StringBuilder();
        for (int i=0;i<num.length();i++) {
            char c = num.charAt(i);
            //只要栈里小于当前值的全退出
            while(k>0&&stack.length()!=0 && stack.charAt(stack.length()-1) > c) {
                stack.setLength(stack.length() -1);
                k--;
            }
            //去掉前置0
            if (c == '0' && stack.length()==0 )continue;
            stack.append(c);
        }
        //如果栈的长度够减k,那就减,不够就是0
        String result = stack.substring(0,stack.length()-k <1 ?0:stack.length()-k);
        return result.length() ==0 ? "0":result ;
    }





}
