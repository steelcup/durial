package s0001;

/*
23. Merge k Sorted Lists
Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


 */
import java.util.*;
import sutil.*;


public class ST0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b)->a.val-b.val);
        for (ListNode n : lists) {
            if (n!=null) {
                q.add(n);
            }
        }
        ListNode preHead = new ListNode(0), cur = preHead;
        while (!q.isEmpty()) {
            ListNode n = q.remove();
            cur.next = n;
            cur = n;
            if (n.next !=null) {
                q.add(n.next);
            }
        }
        return preHead.next;
    }
}
