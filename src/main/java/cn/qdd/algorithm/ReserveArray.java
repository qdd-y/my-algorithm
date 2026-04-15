package cn.qdd.algorithm;

import java.util.Arrays;

/**
 * @Author: qdd
 * @Description: ReserveArray
 * @DateTime: 2026/3/24 15:37
 **/
public class ReserveArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new ReserveArray().rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n =nums.length;
        k = k % n;
        reserve(nums,0,n-1);
        reserve(nums,0,k-1);
        reserve(nums,k,n-1);
    }

    public void reserve(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
