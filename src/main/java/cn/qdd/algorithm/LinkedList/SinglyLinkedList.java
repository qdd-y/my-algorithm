package cn.qdd.algorithm.LinkedList;

import java.util.Iterator;

/**
 * @Author: qdd
 * @Description: SinglyLinkedList
 * @DateTime: 2026/3/27 16:55
 **/
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head;

    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            Node cur = head;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Integer next() {
                int val = cur.val;
                cur = cur.next;
                return val;
            }
        };
    }

    private static class Node{
        int val;
        Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void addFirst(int val){
        head = new Node(val, head);
    }

    public void loop(){
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }



    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.loop();
    }


}
