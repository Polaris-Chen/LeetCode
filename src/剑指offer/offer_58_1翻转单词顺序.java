package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/9 8:27 下午
 */

/*
*其实就是分割一下就行 如果有空格反正就是割出来的数组有空的,忽略就行
* */
public class offer_58_1翻转单词顺序 {

    public String reverseWords(String s) {
        if (s.isEmpty()){
            return "";
        }
        StringBuilder stringBuilder=new StringBuilder();
        String[] x=s.split(" ");
        for (int i =x.length-1 ;i>=0; i--) {
            if (!x[i].equals("")){
                stringBuilder.append(x[i]).append(" ");
            }
        }
        if (stringBuilder.length()==0){
            return "";
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
