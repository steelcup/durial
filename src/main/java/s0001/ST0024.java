package s0001;

/*
24. Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

Note:

    Your algorithm should use only constant extra space.
    You may not modify the values in the list's nodes, only nodes itself may be changed.


 */
import sutil.*;


public class ST0024 {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        //swap
        ListNode next = head.next;
        ListNode nextNext = head.next.next;
        next.next = head;
        head.next = swapPairs(nextNext);
        return next;
    }
}
