package 剑指offer;

import java.util.ArrayList;

/**
 * @author polarisChen
 * @create 2021/3/9 7:40 下午
 */

/*
* 我的方法就是根据等差数列求和公式
* 不断用不同的n尝试计算a1,如果a1是整数那就加入结果
*
* 还有一种办法就是滑动窗口算法,大了就移动左边界,小了就移动右边界
*
* */
public class offer_57_2_和为s的连续正数序列_important {

    public static void main(String[] args) {
        offer_57_2_和为s的连续正数序列_important o=new offer_57_2_和为s的连续正数序列_important();
        o.findContinuousSequence(15);
    }
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> arrayList=new ArrayList<>();
        int sum=target*2;
        for (int n = 2; n < Math.pow(sum,0.5)  ; n++) {
            Double a1=(((sum-Math.pow(n,2))/n)+1)/2;

            if (a1.intValue()==a1){
                arrayList.add(caculate(a1.intValue(),n));
            }
        }

        int[][] x= new int[arrayList.size()][];
        int j=0;
        for (int i = arrayList.size()-1; i >=0 ;i--) {
            x[j]=arrayList.get(i);
            j++;
        }
        return x;
    }

    public int[] caculate(int a1,int n){
        int[] x=new int[n];
        x[0]=a1;
        for (int i = 1; i <n ; i++) {
            x[i]=++a1;
        }
        return x;
    }
}
