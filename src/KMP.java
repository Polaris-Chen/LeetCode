import java.util.ArrayList;

//KMP介绍  https://blog.51cto.com/acevi/2104820  这里面的next算法好像有问题
//next算法 https://blog.csdn.net/zero9988/article/details/60478388
public class KMP {
    static void getNext(String pattern,int[] next) {
        int j, k;
        next[0] = -1;
        j = 0;  //后串起始位置，一直增加
        k = -1;  //k==-1时，代表j++进入下一轮匹配，k代表前串起始位置，匹配失败回到next[k]
        while (j < pattern.length() - 1) {
            //匹配的情况下
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k))
            {
                ++j;
                ++k;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }

            //aaabaaa
            //-1010123

        }
    }

    static ArrayList<Integer> kmp(String s,String pattern){
        int i = 0;
        int j = 0;
        ArrayList<Integer> arrayList = new ArrayList();


        int slen = s.length();
        int plen = pattern.length();
        int[] next = new int[plen];
        getNext(pattern,next);



        while(i < slen){
            //匹配就都++
            if(s.charAt(i) == pattern.charAt(j)){
                i++;
                j++;

            }
            //如果j=0了就不用动j,直接让i往前走一步就行
            else if(next[j] == -1){
                i++;

            }
            //不匹配就j跳转到新的位置
            else{
                j = next[j];
            }
            //如果j走到底了就是匹配上了,把这个序号加入数组中
            if(j == plen){
                //数组加入匹配的序号
               arrayList.add(i);
               j=0;
            }
        }
        //返回所有匹配的序号
        return arrayList;

    }


    public static void main(String[] args){
        String str1="";
        String Line1="";
        ArrayList<Integer> arrayList= KMP.kmp(Line1,str1);
        System.out.println(arrayList.get(0));


    }

}
