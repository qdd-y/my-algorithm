package cn.qdd.algorithm;

import java.util.HashMap;

/**
 * @Author: qdd
 * @Description: SumAndTwo
 * @DateTime: 2026/3/10 14:01
 **/
public class SumAndTwo {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ints = twoSum(nums, 9);
        System.out.println(ints[0]+" "+ints[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i<nums.length ;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
