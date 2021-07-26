package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/8 9:59 下午
 */

//很简单 就是二分找到目标数字然后左右扩展
public class offer_53_1_在排序数组中查找数字 {
    public static int search(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int l=0;int r=nums.length-1;
        int loc=-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (nums[mid]>target){
                r=mid-1;
            }
            else if (nums[mid]<target){
                l=mid+1;
            }
            else {
                loc=mid;
                break;
            }
        }
        if (loc==-1){
            return 0;
        }
        int sum=0;
        r=loc;
        while (r<nums.length&&nums[r]==target){
            sum++;
            r++;
        }
        l=loc-1;
        while (l>=0&&nums[l]==target){
            sum++;
            l--;
        }
        return sum;
    }

//    public int aux_search(int[] nums, int target,int l,int r){
//
//    }
}
