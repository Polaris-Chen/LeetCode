package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author polarisChen
 * @create 2021/5/4 11:11 下午
 * 和矩阵找最小路径是一个思路,就是自底向上逐步dp,最后尖尖的值就是最小路径
 */
public class _120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp=new ArrayList<>();
        dp.add(triangle.get(triangle.size()-1));
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }

        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp=Math.min(dp.get(i+1).get(j),dp.get(i+1).get(j+1));
                dp.get(i).add(temp+triangle.get(i).get(j));
            }
        }
        return dp.get(0).get(0);
    }
}
