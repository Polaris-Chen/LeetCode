package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author polarisChen
 * @create 2021/3/9 9:12 下午
 */
//和59_2思路基本一样
public class offer_59_1_滑动窗口的最大值 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length == 0 || k == 0) return new int[0];
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
                // 删除 deque 中对应的 nums[i-1]
                if(i > 0 && deque.peekFirst() == nums[i - 1])
                    deque.removeFirst();
                // 保持 deque 递减
                while(!deque.isEmpty() && deque.peekLast() < nums[j])
                    deque.removeLast();
                deque.addLast(nums[j]);
                // 记录窗口最大值
                if(i >= 0)
                    res[i] = deque.peekFirst();
            }
            return res;
        }
    }
}
