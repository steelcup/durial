package s0101;
/*
146. LRU Cache
Hard

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */
import java.util.*;
public class ST0146 {
    Map<Integer, MyListNode> map = new HashMap<>();
    MyListNode head = new MyListNode(-1, -1);
    MyListNode tail = new MyListNode(-1, -1);

    int cap;

    public ST0146(int c) {
        this.cap = c;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        MyListNode n = map.get(key);
        if (n == null) {
            return -1;
        }
        moveToHead(n);
        return n.val;
    }

    public void put(int key, int value) {
        MyListNode n = map.get(key);
        if (n != null) {
            n.val = value;
            moveToHead(n);
        } else {
            //adding new
            if (map.size() == cap) {
                MyListNode tailN = removeTail();
                map.remove(tailN.key);
            }
            MyListNode tempN = new MyListNode(key, value);
            map.put(key, tempN);
            addToHead(tempN);
        }
    }

    private void moveToHead(MyListNode n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
        this.addToHead(n);
    }

    private void addToHead(MyListNode n) {
        n.next = head.next;
        n.pre = head;
        n.next.pre = n;
        head.next = n;
    }

    private MyListNode removeTail() {
        if (tail.pre == head) {
            return null;//not allowed
        }
        MyListNode n = tail.pre;
        n.pre.next = tail;
        tail.pre = n.pre;
        return n;
    }
}
class MyListNode {
    int val;
    int key;
    public MyListNode pre, next;

    MyListNode(int k, int v) {
        this.val = v;
        this.key = k;
    }
}
