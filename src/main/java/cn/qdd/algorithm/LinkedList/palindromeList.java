package cn.qdd.algorithm.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qdd
 * @Description: palindromeList
 * @DateTime: 2026/3/31 15:31
 **/
public class palindromeList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(2,node2);
        ListNode node4 = new ListNode(1,node3);
        System.out.println(new palindromeList().isPalindrome(node4));
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int r = list.size()-1;
        int l = 0;
       while (l < r){
           if (list.get(l).equals(list.get(r))){
               l++;
               r--;
           }else {
               return false;
           }
       }
       return true;
    }
}
