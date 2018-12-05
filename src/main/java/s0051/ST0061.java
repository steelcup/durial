package s0051;

/*
61. Rotate List
Medium

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL


 */
import sutil.*;

public class ST0061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode fast = head;
        int count = 1;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        k = k % count;
        int n = count-k;
        ListNode preK = head;
        while (n > 1) {
            preK = preK.next;
            n--;
        }
        fast.next = head;
        ListNode newHead = preK.next;
        preK.next = null;
        return newHead;
    }
}
