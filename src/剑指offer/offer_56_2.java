package 剑指offer;

import java.util.HashMap;

/**
 * @author polarisChen
 * @create 2021/4/1 4:29 下午
 */
public class offer_56_2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i <nums.length ; i++) {
            if (hashMap.containsKey(nums[i])){
                if (hashMap.get(nums[i])==1){
                    hashMap.put(nums[i], 2);
                }
                else {
                    hashMap.remove(nums[i]);
                }
            }
            else {
                hashMap.put(nums[i],1);
            }
        }
        for (Integer x:hashMap.keySet()){
        return x;
        }
        return -1;
    }
}
