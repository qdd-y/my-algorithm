package cn.qdd.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @Author: qdd
 * @Description: MedianFinder
 * @DateTime: 2026/5/10 16:43
 **/
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        //如果两边元素相等向左边加入元素
        if (left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else { // 不相等就向右边加入元素
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }else {
            return left.peek();
        }
    }
}
