package cn.qdd.algorithm;

/**
 * @Author: qdd
 * @Description: ArrayProduct
 * @DateTime: 2026/3/25 15:10
 **/
public class ArrayProduct {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = new ArrayProduct().productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 1;
        for (int i = 1; i < n; i++){
            l[i] = l[i-1] * nums[i-1];
        }
        r[n-1] = 1;
        for (int i = n-2; i>=0; i--){
            r[i] = r[i+1] * nums[i+1];
        }
        int[] ans = new int[n];
        for (int i =0; i < n; i++){
            ans[i] = l[i] * r[i];
        }

        return ans;
    }
}
