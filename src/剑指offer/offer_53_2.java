package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/3/9 12:35 下午
 */
public class offer_53_2 {
//就二分去找是否num[i]=i,最后只剩两个元素的时候再分情况判断
    public int missingNumber(int[] nums) {
        int l=0;int r=nums.length-1;
        while (r-l>1){
            int mid=(l+r)/2;
            if (nums[mid]>mid){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        if (nums[l]==l&&nums[r]==r){
            return nums[r]+1;
        }
        else if (nums[l]==l&&nums[r]!=r){
            return nums[l]+1;
        }
        else {
            return nums[r]-1;
        }


    }

}
