package s0101;
/*
109. Convert Sorted List to Binary Search Tree
Medium

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
import sutil.*;

public class ST0109 {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }
    //has to use middle node as the root, so...
    //tail excluded
    private TreeNode build(ListNode head, ListNode tail) {
        if (head==null || head == tail) { //tail excluded
            return null;
        }
        ListNode fast = head, slow = head;
        //while(fast != null && fast.next != null) {
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode n = new TreeNode(slow.val);
        n.left = build(head, slow);
        n.right = build(slow.next, tail);
        return n;
    }
}
