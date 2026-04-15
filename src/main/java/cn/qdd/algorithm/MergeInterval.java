package cn.qdd.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: qdd
 * @Description: MergeInterval
 * @DateTime: 2026/3/23 14:38
 **/
public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge1(intervals);
        System.out.println(Arrays.deepToString(merge));
    }


    public static int[][] merge(int[][] intervals) {
        //判断边界值
        if (intervals == null || intervals.length < 2){
            return intervals;
        }
        //数组排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        //初始化一个list
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            //得到当前的一元数组
            int[] cur = intervals[i];
            //得到之前初始化的数组
            int[] pre = list.get(list.size()-1);
            if (cur[0] <= pre[1]){
                pre[1] = Math.max(cur[1],pre[1]);
            }else {
                list.add(intervals[i]);
            }
         }
        return list.toArray(new int[list.size()][]);
    }

    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++){
            int[] cur = intervals[i];
            int[] pre = list.get(list.size()-1);
            if (cur[0] <= pre[1]){
                pre[1] = Math.max(pre[1],cur[1]);
            }else {
                list.add(cur);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
