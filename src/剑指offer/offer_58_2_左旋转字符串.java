package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/9 8:43 下午
 */
public class offer_58_2_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        StringBuilder pre=new StringBuilder(s.substring(n));
        pre.append(s, 0, n);
        return pre.toString();
    }
}
