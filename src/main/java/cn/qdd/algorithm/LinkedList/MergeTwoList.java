package cn.qdd.algorithm.LinkedList;

/**
 * @Author: qdd
 * @Description: MergeTwoList
 * @DateTime: 2026/4/1 16:01
 **/
public class MergeTwoList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(4, null);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1, null);
        ListNode node5 = new ListNode(3, null);
        ListNode node6 = new ListNode(4, null);
        node4.next = node5;
        node5.next = node6;

        MergeTwoList mergeTwoList = new MergeTwoList();
        ListNode head = mergeTwoList.mergeTwoLists(node1, node4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumy = new ListNode(-1);
        ListNode cur = dumy;
        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dumy.next;
    }
}
