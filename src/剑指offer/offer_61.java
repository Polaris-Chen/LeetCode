package 剑指offer;

import java.util.Arrays;

public class offer_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int number0=0;
        int i=0;
        for (; i <5 ; i++) {
            if (nums[i]==0){
                number0++;
            }
            else {
                break;
            }
        }
        while (i!=5){
            if (i+1<5&&nums[i]+1==nums[i+1]){
                i++;
            }
            else if (number0>0){
                number0--;
                nums[i]++;
            }
            else {
                break;
            }
        }
        return i==4;
    }
}
