package 剑指offer;

import java.util.HashSet;
import java.util.Set;

//剑指offer_03
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
public class offer_03_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums=new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }
    //简单解答,只需要用set存下不重复的数字,遇到重复直接返回就行
    public static int findRepeatNumber2(int[] nums){
        Set<Integer> s=new HashSet();
        for (int i:nums){
            if (!s.add(i)){
                return i;
            }
        }
        return -1;
    }


    //自己的想法,排序,遇到重复的返回
    public static int findRepeatNumber1(int[] nums) {
        for (int i=1;i<nums.length;i++){
            for (int j=i;j>0;j--){
                if (nums[j-1]==nums[j]){
                    return nums[j];
                }

                else if (nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }
                else {
                    break;
                }

            }
        }
        return -1;
    }

    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

