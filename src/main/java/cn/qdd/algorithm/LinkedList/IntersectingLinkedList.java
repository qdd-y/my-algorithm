package cn.qdd.algorithm.LinkedList;


/**
 * @Author: qdd
 * @Description: IntersectingLinkedList
 * @DateTime: 2026/3/30 15:41
 **/
public class IntersectingLinkedList {
    public static void main(String[] args) {
            ListNode c1 = new ListNode(8,null);
            ListNode c2 = new ListNode(4,c1);
            ListNode c3 = new ListNode(5,c2);

            ListNode a1 = new ListNode(4,null);
            ListNode a2 = new ListNode(1,a1);
            a1.next = c3;

            ListNode b1 = new ListNode(5,null);
            ListNode b2 = new ListNode(6,b1);
            ListNode b3 = new ListNode(1,b2);
            b1.next = c3;

            System.out.println(new IntersectingLinkedList().getIntersectionNode(a2,b3).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
