package s0101;
/*
116. Populating Next Right Pointers in Each Node
Medium

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 */
import sutil.*;

public class ST0116 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        travel(root);
    }

    private void travel(TreeLinkNode n) {
        if (n==null) {
            return;
        }
        if (n.left != null) {
            n.left.next = n.right;
        }
        if (n.right != null && n.next != null) {
            n.right.next = n.next.left;
        }
        travel(n.left);
        travel(n.right);
    }
}
