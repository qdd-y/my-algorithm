package cn.qdd.algorithm.LinkedList;

import java.util.List;

/**
 * @Author: qdd
 * @Description: ReserveAllList
 * @DateTime: 2026/4/5 15:36
 **/
public class ReserveAllList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new ReserveAllList().reverseKGroup(head, 2);
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        //计算链表长度
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //反转次数
        int m = count / k;
        for(int i = 0; i < m; i++){
            for(int j = 1; j < k; j++){
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}

