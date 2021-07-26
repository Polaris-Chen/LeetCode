package 剑指offer;

import java.util.Arrays;

/**
 * @author polarisChen
 * @create 2021/4/26 4:26 下午
 */
public class offer_60 {

    public double[] dicesProbability(int n) {
        double[] f = new double[6];
        Arrays.fill(f, 1.0 / 6.0);
        //从两个骰子开始
        for (int i = 2; i <= n; i++) {
            double[] temp=new double[5*i+1];
            //就是每个新的骰子来了,就对于原来的概率数组中的每个值都有6种可能
            //也就是要计算f.length*6种情况,但是里面很多情况的值都是一样的,所以概率要加起来
            for (int j = 0; j <f.length; j++) {
                for (int k = 0; k <6 ; k++) {
                    //有六分之一的概率选到这个数
                    temp[j+k]+=f[j]/6.0;
                }
            }
            f = temp;
        }
        System.out.println();
        return f;
    }
}
