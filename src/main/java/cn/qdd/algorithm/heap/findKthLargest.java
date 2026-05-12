package cn.qdd.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @Author: qdd
 * @Description: findKthLargest
 * @DateTime: 2026/5/10 15:53
 **/
public class findKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int kthLargest = new findKthLargest().findKthLargest1(nums, 2);
        System.out.println(kthLargest);
    }
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if (nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer((nums[i]));
            }
        }
        return minHeap.peek();
    }
}
