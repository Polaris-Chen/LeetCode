package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/9 5:05 下午
 */
public class offer_57_1 {
    public int[] twoSum(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<r){
            if (nums[l]+nums[r]==target){
                return new int[]{nums[l],nums[r]};
            }
            else if (nums[l]+nums[r]<target){
                l++;
            }
            else {
                r--;
            }
        }
        return new int[2];
    }
}
