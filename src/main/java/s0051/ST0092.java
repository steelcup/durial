package s0051;
/*
92. Reverse Linked List II
Medium

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */

import sutil.*;
public class ST0092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode preM = preHead;
        for (int i = 0; i < m-1; i++) {
            preM = preM.next;
        }
        ListNode cur = preM.next;
        //move cur.next node to after preM
        for (int i = m; i < n; i++) { //move n-m times
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preM.next;
            preM.next = next;
            //cur still cur
        }
        return preHead.next;
    }
}
