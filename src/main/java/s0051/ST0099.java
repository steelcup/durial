package s0051;
/*
99. Recover Binary Search Tree
Hard

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2

Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

Follow up:

    A solution using O(n) space is pretty straight forward.
    Could you devise a constant space solution?

 */
import sutil.*;

public class ST0099 {
    //https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
    private TreeNode first, second, pre;
    public void recoverTree(TreeNode root) {
        travel(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void travel(TreeNode n) {
        if (n==null) {
            return;
        }
        travel(n.left);
        if (pre != null) {
            if (pre.val > n.val) {
                if (first == null) {
                    first = pre;
                    second = n;
                } else {
                    second = n;
                }
            }
        }
        pre = n;
        travel(n.right);
    }
}
