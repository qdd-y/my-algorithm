package cn.qdd.algorithm.LinkedList;

/**
 * @Author: qdd
 * @Description: SumAndTwo
 * @DateTime: 2026/4/1 16:32
 **/
public class SumAndTwo {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, null);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5, null);
        ListNode node5 = new ListNode(6, null);
        ListNode node6 = new ListNode(4, null);
        ListNode node7 = new ListNode(9, null);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        SumAndTwo sumAndTwo = new SumAndTwo();
        ListNode head = sumAndTwo.addTwoNumbers(node1, node4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int y = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null || l2 != null || y != 0){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + y;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            y = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
