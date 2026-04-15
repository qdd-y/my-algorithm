package cn.qdd.algorithm.LinkedList;

/**
 * @Author: qdd
 * @Description: RemoveNNode
 * @DateTime: 2026/4/4 15:34
 **/
public class RemoveNNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new RemoveNNode().removeNthFromEnd(head, 2);
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++){
            cur = cur.next;
        }
        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
