package cn.qdd.algorithm.LinkedList;

/**
 * @Author: qdd
 * @Description: SwapNode
 * @DateTime: 2026/4/4 16:22
 **/
public class SwapNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        node1.next = node2;
        node2.next = node3;

        SwapNode swapNode = new SwapNode();
        ListNode head = swapNode.swapPairs(node1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;

    }
}
