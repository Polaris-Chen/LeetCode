package LeetCode;

/**
 * @author polarisChen
 * @create 2021/3/8 7:30 下午
 */
public class _1539 {
    public int findKthPositive(int[] arr, int k) {
        if (k<arr[0]){
            return k;
        }
        int flag=0;int x=0;
        for (int i = 0; i <arr.length ; i++) {

                while (arr[i]>flag){
                    flag++;
                    x++;
                    if (x==k){
                        return flag;
                    }
                }
        }
        return flag+k-x;

    }
}
