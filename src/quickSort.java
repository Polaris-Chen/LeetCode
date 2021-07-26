import java.util.Arrays;

/**
 * @author polarisChen
 * @create 2021/3/10 8:34 下午
 */
public class quickSort {
    public static void quickSort1(int[] nums) {
        aux_quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void aux_quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int flag = nums[l];
        int low = l ;
        int high = r;
        while (low < high) {
            while (low < high&& nums[high] > flag) {
                high--;
            }
            nums[low]=nums[high];
            while (low < high && nums[low] <= flag) {
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=flag;
        aux_quickSort(nums, l, low - 1);
        aux_quickSort(nums, low+1, r);
    }
}
