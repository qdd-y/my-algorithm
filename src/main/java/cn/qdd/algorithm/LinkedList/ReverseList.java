package cn.qdd.algorithm.LinkedList;

/**
 * @Author: qdd
 * @Description: ReverseList
 * @DateTime: 2026/3/29 17:23
 **/
public class ReverseList {

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
        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.reverseList(node1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
