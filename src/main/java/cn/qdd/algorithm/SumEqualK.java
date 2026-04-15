package cn.qdd.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qdd
 * @Description: SumEqualK
 * @DateTime: 2026/3/18 16:14
 **/
public class SumEqualK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,count =0;
        for (int i=0; i<nums.length; i++){
            sum = sum+nums[i];
            if (map.containsKey(sum-k)){
                count = count+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //初始值，和为0的情况出现一次
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum+nums[i];
            if(map.containsKey(sum-k)){
                count = count +map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
