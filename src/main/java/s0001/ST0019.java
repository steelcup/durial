package s0001;

/*
19. Remove Nth Node From End of List
Medium

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

 */

import sutil.*;

public class ST0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead, slow = preHead;
        int count = 0;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        int slowMove = count-n;
        while (slowMove > 0) {
            slowMove--;
            slow = slow.next;
        }
        //move pre.next
        slow.next = slow.next.next;
        return preHead.next;
    }
}
