package cn.qdd.algorithm;

/**
 * @Author: qdd
 * @Description: FirstMissingPositiveNumber
 * @DateTime: 2026/3/27 15:48
 **/
public class FirstMissingPositiveNumber {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new FirstMissingPositiveNumber().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]){
                int pos = nums[i] -1;
                int val = nums[i];
                nums[i] = nums[pos];
                nums[pos] = val;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
