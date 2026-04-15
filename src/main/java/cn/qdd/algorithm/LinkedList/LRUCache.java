package cn.qdd.algorithm.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qdd
 * @Description: LRUCache
 * @DateTime: 2026/4/14 16:43
 **/
public class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        if (map.containsKey(key)){
            remove(map.get(key));
            headInsert(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.value = value;
            headInsert(node);
        }else {
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            headInsert(newNode);
            if (map.size() > capacity){
                Node end = tail.pre;
                remove(end);
                map.remove(end.key);
            }
        }
    }
    void remove(Node node){
        Node node_pre = node.pre;
        Node node_next = node.next;
        node_pre.next = node_next;
        node_next.pre = node_pre;
    }
    void headInsert(Node node){
        Node temp = head.next;
        node.next = temp;
        node.pre = head;
        temp.pre = node;
        head.next = node;
    }

    class Node{
        Node next;
        Node pre;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 3 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回  4
    }
}
