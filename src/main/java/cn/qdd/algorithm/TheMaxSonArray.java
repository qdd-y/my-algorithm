package cn.qdd.algorithm;

/**
 * @Author: qdd
 * @Description: TheMaxSonArray
 * @DateTime: 2026/3/22 15:53
 **/
public class TheMaxSonArray {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3};
        System.out.println(maxSubArray1(nums));
    }
    public static int maxSubArray(int[] nums) {
        //定义前缀和以及ans
        int preSum = 0;
        int ans = Integer.MIN_VALUE;
        //遍历数组
        for (int num : nums) {
            //计算前缀和
            preSum = preSum + num;
            //得到最大值
            ans = Math.max(ans, preSum);
            //如果前缀和小于0那么后续不管加什么都是跟加小的值了 所以需要重新计算前缀和
            if (preSum < 0) {
                preSum = 0;
            }
        }
        return ans;
    }

    public static int maxSubArray1(int[] nums){
        int preSum = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums){
            preSum = preSum +num;
            ans = Math.max(ans,preSum);
            if (preSum<0){
                preSum = 0;
            }
        }
        return ans;
    }
}
