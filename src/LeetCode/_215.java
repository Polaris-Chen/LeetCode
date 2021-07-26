package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author polarisChen
 * @create 2021/3/10 4:25 下午
 */
public class _215 {
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (priorityQueue.size() >= k && priorityQueue.peek() >= nums[i]) {
                continue;
            }
            priorityQueue.add(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

        }
        return priorityQueue.peek();

    }

    public int findKthLargest(int[] nums, int k) {
        return quickChoose(nums,0,nums.length-1,k);
    }
    public int quickChoose(int[] nums,int l,int r,int k){
        int flag=nums[l];
        int min=l;
        int max=r;

        while (min<max){
            while (min<max&&nums[max]>flag){
                max--;
            }
            nums[min]=nums[max];
            while (min<max&&nums[min]<=flag){
                min++;
            }
            nums[max]=nums[min];

        }
        nums[min]=flag;
        if (min==nums.length-k){
            return nums[min];
        }
        else if (min<nums.length-k){
            return quickChoose(nums,min+1,r,k);
        }
        else {
            return quickChoose(nums,l,min-1,k);
        }
    }
}
