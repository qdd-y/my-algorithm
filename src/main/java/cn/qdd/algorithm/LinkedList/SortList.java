package cn.qdd.algorithm.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: qdd
 * @Description: SortList
 * @DateTime: 2026/4/11 14:55
 **/
public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode listNode = new SortList().sortList(head);
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        cur = dummy;
        cur.next = head;
        for (int i = 0; i < list.size(); i++){
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return dummy.next;
    }
}
