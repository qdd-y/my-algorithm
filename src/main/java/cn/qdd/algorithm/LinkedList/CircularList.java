package cn.qdd.algorithm.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: qdd
 * @Description: CircularList
 * @DateTime: 2026/3/31 17:15
 **/
public class CircularList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        CircularList circularList = new CircularList();
        System.out.println(circularList.hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (!set.contains(cur)){
                set.add(cur);
                cur = cur.next;
            }else {
                return true;
            }
        }
        return false;
    }
}
