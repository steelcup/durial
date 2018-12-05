package s0000;

/*
21. Merge Two Sorted Lists
Easy

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */
import sutil.*;


public class ST0021 {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode n;
        if (a.val < b.val) {
            n = a;
            n.next = mergeTwoLists(a.next, b);
        } else {
            n = b;
            n.next = mergeTwoLists(b.next, a);
        }
        return n;
    }
}
