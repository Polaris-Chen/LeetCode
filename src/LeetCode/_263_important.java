package LeetCode;

/**
 * @author polarisChen
 * @create 2021/5/5 10:37 下午
 * 其实就是一直除,直到不能除2,3,5为止,看看剩下的是不是1
 */
public class _263_important {

    public boolean isUgly(int n) {
        if (n<=0){
            return false;
        }
        int[] x=new int[]{2,3,5};
        for (int y:x){
            while (n%y==0){
                n=n/y;
            }
        }
        return n==1;
    }
}
