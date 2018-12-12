package s0101;
/*
101. Symmetric Tree
Easy

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.
 */
import sutil.*;

public class ST0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) {
            return true;
        }
        return verify(root.left, root.right);
    }

    private boolean verify(TreeNode a, TreeNode b) {
        if (a==null && b==null) {
            return true;
        }
        if (a==null || b==null || a.val!=b.val) {
            return false;
        }
        return verify(a.left, b.right) && verify(a.right, b.left);
    }
}
