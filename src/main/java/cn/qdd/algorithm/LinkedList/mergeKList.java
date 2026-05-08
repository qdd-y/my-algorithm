package cn.qdd.algorithm.LinkedList;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: qdd
 * @Description: mergeKList
 * @DateTime: 2026/4/11 15:04
 **/
public class mergeKList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {l1,l2,l3};
        ListNode listNode = new mergeKList().mergeKLists1(lists);
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] list, int left, int right){
        if (left == right) return list[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(list,left,mid);
        ListNode l2 = merge(list,mid+1,right);
        return mergeTwoLists(l1,l2);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                minHeap.offer(node.val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            cur.next = new ListNode(minHeap.poll());
            cur = cur.next;
            if (cur.next != null) {
                minHeap.offer(cur.next.val);
            }
        }
        return dummy.next;
    }
    ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

}
