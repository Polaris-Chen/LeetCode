package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author polarisChen
 * @create 2021/2/15 3:30 下午
 */
public class offer_29_顺时针打印矩阵_important {
    //其实逻辑都一样 我的画蛇添足了
    //就是一个个遍历就行了
    public int[] spiralOrder1(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }




    ArrayList<Integer> result = new ArrayList<>();

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        insert(n, m, 0, matrix);
        int[] finalresult = new int[n * m + 1];
        for (int i = 0; i < result.size(); i++) {
            finalresult[i] = result.get(i);
        }

        return finalresult;
    }
//我自己的想法就是简单的分割子问题,递归的处理每个n*m矩阵,获得最外面一圈,然后再把里面的矩阵递归处理
    //n和m分别是要处理矩阵的长度 start是开始的点,因为每次必定是从0,0 1,1 2,2这样开始,不管什么类型

    public void insert(int n, int m, int start, int[][] matrix) {
        //共分三类
        //1.mn中有一个值是0,那就没必要算
        //2.mn有一个是1,那就直接整条加入,然后返回
        //3.mn均大于1,就是说可以跑完一圈,那就从start开始绕一圈


        /*情况1*/
        if (n == 0 || m == 0) {
            return;
        }
        //这两个是当前的坐标
        int nowm = start;
        int nown = start;

        /*情况2*/
        if (n == 1) {
            while (m > 0) {
                result.add(matrix[nown][nowm]);
                nowm++;
                m--;
            }
            return;
        }
        if (m == 1) {
            while (n > 0) {
                result.add(matrix[nown][nowm]);
                nown++;
                n--;
            }
            return;
        }
        /*情况3*/
        //wall就是到哪个位置停下来
        //第一次是横着走,wall就在从start开始第m+1个位置
        int wall = nowm + m;
        while (nowm < wall) {
            result.add(matrix[nown][nowm]);
            nowm++;
        }
        //因为最后等于wall了,所以先把nowm拉回来
        //  ***^   现在就在^位置
        //  ***
        //  ***
        nowm--;
        //因为右上角的*其实已经访问过了,因此竖的这一栏从第二个*开始,所以要++
        nown++;
        //下面也同理走完全部流程
        wall = nown + n - 1;
        while (nown < wall) {
            result.add(matrix[nown][nowm]);
            nown++;
        }
        nown--;
        nowm--;

        wall = start - 1;
        while (nowm > wall) {
            result.add(matrix[nown][nowm]);
            nowm--;
        }
        nowm++;
        nown--;

        wall = start;
        while (nown > wall) {
            result.add(matrix[nown][nowm]);
            nown--;
        }
        //再把里面的矩阵迭代计算
        insert(n - 2, m - 2, start + 1, matrix);

    }

}
