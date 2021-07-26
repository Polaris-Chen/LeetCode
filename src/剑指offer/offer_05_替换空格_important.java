package 剑指offer;

/*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。*/
//最简单肯定是s.replaceAll,但是要考算法的话就不能这么做,就设一个三倍长的char类型数组,一个now指针,如果是
//空格就换成"%20",如果不是空格就照抄
public class offer_05_替换空格_important {

    public static String replaceSpace(String s) {

        char[] result = new char[s.length() * 3];
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result[now] = '%';
                result[now + 1] = '2';
                result[now + 2] = '0';
                now += 3;
            } else {
                result[now] = s.charAt(i);
                now++;
            }

        }
        return new String(result,0,now);
    }
}

