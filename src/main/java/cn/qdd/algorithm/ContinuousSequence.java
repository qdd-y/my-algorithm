package cn.qdd.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qdd
 * @Description: ContinuousSequence
 * @DateTime: 2026/3/12 13:02
 **/
public class ContinuousSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int i = new ContinuousSequence().longestConsecutive(nums);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if(nums ==null || nums.length ==0){
            return 0;
        }
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int num :nums){
            map.put(num,true);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (!map.containsKey(key - 1)) {
                int currentNum = key;
                int currentStatck = 1;
                while (map.containsKey(currentNum + 1)) {
                    currentStatck++;
                    currentNum++;
                }
                res = Math.max(res,currentStatck);
            }
        }
        return res;
    }
}
