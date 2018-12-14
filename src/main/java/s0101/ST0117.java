package s0101;
/*
117. Populating Next Right Pointers in Each Node II
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

Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

 */
import sutil.*;
import java.util.*;

public class ST0117 {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        if (root!=null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            int len = q.size();
            TreeLinkNode pre = null;
            for (int i = 0; i < len; i++) {
                TreeLinkNode cur = q.remove();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                if (i > 0) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
    }
}
