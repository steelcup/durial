package s0101;
/*
138. Copy List with Random Pointer
Medium

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
import org.junit.jupiter.api.Test;
import sutil.*;
public class ST0138 {
    @Test
    public void test() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = n1.addNext(2);
        RandomListNode n3 = n2.addNext(3);
        RandomListNode n4 = n3.addNext(4);
        n1.random = n4;
        n2.random = n3;
        n3.random = n3;
        n4.random = null;
        RandomListNode cn = copyRandomList(n1);
        System.out.println(cn.label);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode cur = head;
        //dupe and link after each node
        // 1->1'->2->2'->3->3'
        while (cur != null) {
            RandomListNode n = new RandomListNode(cur.label);
            n.next = cur.next;
            cur.next = n;
            cur = n.next;
        }
        cur = head;
        //hook the random
        while (cur != null) {
            RandomListNode cur2 = cur.next;
            if (cur.random != null) {
                cur2.random = cur.random.next;
            }
            cur = cur2.next;
        }
        //separate both link list out
        cur = head;
        RandomListNode head2 = head.next;
        RandomListNode cur2 = head2;
        while (cur != null) {
            cur.next = cur.next.next;
            if (cur2.next != null) {
                cur2.next = cur2.next.next;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
        return head2;
    }
}
