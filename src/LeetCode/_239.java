package LeetCode;

import java.util.LinkedList;


/**
 * @author polarisChen
 * @create 2021/7/21 2:12 下午
 *
 * 滑动窗口需要维护一个双端队列,里面保存的是数组的索引
 * 每次R往右一步,就从队列右边开始弹,如果右边的小于等于新的值,就弹出
 * 每次L往右一步,看看最左边的是不是小于最新的索引,如果小于就弹出,注意,一个是比较值,一个是比较索引
 */
public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList();
        int[] r=new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            AddRight(linkedList,i,nums);
        }
        r[0]=nums[linkedList.getLast()];
        for (int i = 1; i <=nums.length-k ; i++) {
            AddRight(linkedList,i+k-1,nums);
            RemoveLeft(linkedList,i);
            r[i]=nums[linkedList.getLast()];
        }
        return r;
    }
    public void AddRight(LinkedList<Integer> linkedList,int index,int[] nums){
        while (!linkedList.isEmpty()){
            if (nums[index]>=nums[linkedList.peekFirst()]){
                linkedList.pollFirst();
                continue;
            }
            break;
        }
        linkedList.addFirst(index);
    }
    public void RemoveLeft(LinkedList<Integer> linkedList,int index){
        if (linkedList.getLast()<index){
            linkedList.pollLast();
        }
    }
}
