package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/2/9 10:07 下午
 */

//就是找到左边第一个偶数和右边第一个奇数然后交换,如果左右指针重叠了证明全检查完了
public class offer_21 {
    public int[] exchange(int[] nums) {
        if (nums.length<=1){
            return nums;
        }

        int l=0,r= nums.length-1;
        while (l<r){
            while (l<nums.length&&nums[l]%2==1){
                l++;
            }
            while (r>=0&&nums[r]%2==0){
                r--;
            }
            if (l>=r){
                break;
            }
            swap(nums,l,r);
            l++;
            r--;
        }

        return nums;
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;

    }

}
