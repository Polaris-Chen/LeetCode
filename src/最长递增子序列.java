//求连续最长递增子序列
//分治思想
//从中间分成两段,最长递增子序列要么在左半边,要么在右半边,要么横跨中间
//递归算出这三个值,返回最大值

import java.lang.reflect.Array;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] nums=new int[]{10,9,2,5,3,7,101,18,7};
        lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        int x=aux_lengthOfLIS(nums,0,nums.length-1);
        System.out.println(x);
        return x;

    }

    public static int aux_lengthOfLIS(int[] nums,int left,int right){
        if (left==right){
            return 1;
        }
        else if (left+1==right){
            if (nums[left]<nums[right]){
                return 2;
            }
            else {
                return 0;
            }
        }
        int mid=(left+right)/2;
        int leftMax=0;
        int rightMax=0;

        leftMax=aux_lengthOfLIS(nums,left,mid);
        rightMax=aux_lengthOfLIS(nums,mid+1,right);
        int i=mid;int j=mid;
        int leftLength=1;
        int rightLength=0;
        while(i>left){
            if (nums[i-1]<nums[i]){
                leftLength++;
                i--;
            }
            else {
                break;
            }
        }
        while (j<right){
            if (nums[j+1]>nums[j]){
                rightLength++;
                j++;
            }
            else {
                break;
            }
        }
        int midMax=leftLength+rightLength;
        System.out.println("left:"+left+"  right:  "+right+"  leftMax:  "+leftMax+"  rightMax:  "+rightMax+"  midMax:  "+midMax);
        return Math.max(Math.max(leftMax,rightMax),midMax);
    }


}
