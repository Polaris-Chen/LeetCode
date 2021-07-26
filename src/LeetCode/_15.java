package LeetCode;

import java.util.*;

/**
 * @author polarisChen
 * @create 2021/7/9 5:33 下午
 *
 * 逻辑就是固定一个左指针,然后用双指针遍历
 */
public class _15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k <nums.length-2 ; k++) {
            if (nums[k]>0) break;
            if (k>0&&nums[k-1]==nums[k])continue;
            int i=k+1;
            int j=nums.length-1;
            while (i<j){
                int sum=nums[k]+nums[i]+nums[j];
                 if (sum<0){
                    while(i < j && nums[i] == nums[++i]);
                }
                else if (sum>0){
                    while(i < j && nums[j] == nums[--j]);
                }
                else {
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                    result.add(temp);
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }
}
