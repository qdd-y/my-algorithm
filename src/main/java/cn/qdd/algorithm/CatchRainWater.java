package cn.qdd.algorithm;

/**
 * @Author: qdd
 * @Description: CathchRainWater
 * @DateTime: 2026/3/16 16:34
 **/
public class CatchRainWater {
    public static void main(String[] args) {
        int[] height = {};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        //获取数组长度
        int n = height.length;
        if (n==0){
            return 0;
        }
        //构建左数组，左数组的每个元素是当前元素和左边元素的最大值
        int[] lMax =new int[n];
        lMax[0] = height[0];
        int ans = 0;
        for (int i =1; i<n; i++){
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
        //构建右数组，右数组的每个元素是当前元素和右边元素的最大值
        int[] rMax = new int[n];
        rMax[n-1] = height[n-1];
        for (int i=n-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1],height[i]);
        }
        //计算每个元素能接多少水，取左边最大值和右边最大值的最小值减去当前元素的高度
        for (int i=1;i<n-1;i++){
            ans = ans+Math.min(lMax[i],rMax[i])-height[i];
        }
        return ans;
    }
}
