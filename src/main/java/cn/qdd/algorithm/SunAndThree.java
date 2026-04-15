package cn.qdd.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: qdd
 * @Description: SunAndThree
 * @DateTime: 2026/3/13 14:29
 **/
public class SunAndThree {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum3(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        //-1, 0, 1, 2, -1, -4
        // -4 -1 -1 0 1 2
        for(int i =0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1;j<nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k=j+1; k<nums.length; k++){
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if(nums[i]+nums[j]+nums[k] ==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        //排序数组方便跳过重复元素
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            //去除需要重复的元素
            if(i>0&&nums[i]==nums[i-1]) continue;
            int r = n-1;
            for(int j=i+1;j<n;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int target = -nums[i];
                while(j<r&&nums[j]+nums[r]>target){
                    r--;
                }
                if(j==r){
                    break;
                }
                if(nums[j]+nums[r] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[r]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    //双指针算法
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //排序方便去除重复元素和使用指针
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            //寻找重复的数
            if(i>0&&nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            int r = nums.length-1;
            for (int j=i+1; j<nums.length;j++){
                if (j>i+1&&nums[j] ==nums[j-1]) continue;
                while(j<r&&nums[j]+nums[r]>target){
                    r--;
                }
                if (j == r) {
                    break;
                }
                if (nums[j]+nums[r] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[r]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
