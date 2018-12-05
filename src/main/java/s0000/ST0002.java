package s0000;

/**
 * 2. Add Two Numbers
 * Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
import sutil.*;
public class ST0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        int tmp, v1, v2;
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        while (l1 != null || l2 != null || carry > 0) {
            v1 = l1 != null?l1.val:0;
            v2 = l2 != null?l2.val:0;
            tmp = v1+v2+carry;
            ListNode n = new ListNode(tmp%10);
            carry = tmp/10;
            cur.next = n;
            cur = n;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }

        return preHead.next;
    }
}
