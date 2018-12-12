package s0051;
/*
82. Remove Duplicates from Sorted List II
Medium

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:

Input: 1->1->1->2->3
Output: 2->3


 */
import sutil.*;
public class ST0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead, cur = head;
        boolean dup = false;
        //must use pre because may need to remove cur
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                dup = true;
            } else {
                if (dup) {
                    //remove cur;
                    pre.next = cur.next;
                    cur = pre.next;
                    dup = false;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        //remove the last dup if exist
        if (dup) {
            pre.next = cur.next;
        }
        return preHead.next;
    }
}
