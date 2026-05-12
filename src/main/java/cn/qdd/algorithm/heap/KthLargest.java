package cn.qdd.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @Author: qdd
 * @Description: KthLargest
 * @DateTime: 2026/5/10 16:14
 **/
public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
    private PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int x : nums){
            add(x);
        }

    }
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
