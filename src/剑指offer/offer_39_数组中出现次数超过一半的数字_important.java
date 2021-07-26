package 剑指offer;

import java.util.HashMap;

/**
 * @author polarisChen
 * @create 2021/2/18 11:50 上午
 */

/*
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
 * 这个题解的思路讲的很好 摩尔排序
 * 摩尔排序的核心思路有点类似于下面的话
 * 核心就是对拼消耗。玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，
 * 并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。那就大混战呗，
 * 最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），
 * 但是只要你们不要内斗，最后肯定你赢。最后能剩下的必定是自己人。
 *
 * */

public class offer_39_数组中出现次数超过一半的数字_important {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int sign = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int x = map.get(nums[i]);
                map.put(nums[i], x + 1);
                if (max < x) {
                    max = x;
                    sign = nums[i];
                }

            } else {
                map.put(nums[i], 1);
            }

        }

        return sign;
    }
}
