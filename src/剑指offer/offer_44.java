package 剑指offer;

import java.nio.charset.Charset;

/**
 * @author polarisChen
 * @create 2021/3/5 3:46 下午
 */
public class offer_44 {
    public int findNthDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int size;
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            size=stringBuilder.length()+String.valueOf(i).length();

            if (size<0){
                break;
            }
            stringBuilder.append(i);
            System.out.println(stringBuilder.toString());
        }
        return Integer.parseInt(String.valueOf(stringBuilder.charAt(n)));

    }
}
