package s0101;
/*
110. Balanced Binary Tree
Easy

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

 */
import sutil.*;
public class ST0110 {
    public boolean isBalanced(TreeNode root) {
        return findDepth(root, Integer.MAX_VALUE)!=-1;
    }

    //return -1 if not balanced
    /*
    private int findDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left==null && root.right==null) {
            return 1;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        if (left==-1 || right==-1 || Math.abs(left-right)>1) {
            return -1;
        }
        return 1+Math.max(left, right);
    }
    */
    //improve the performance by adding limit
    private int findDepth(TreeNode n, int limit) {
        if (limit<=0) {
            return -1;
        }
        if (n==null) {
            return 0;
        }
        if (n.left==null && n.right==null) {
            return 1; //1 + max(0, 0) = 1
        }
        int left = findDepth(n.left, limit-1);
        if (left == -1) {
            return -1;
        }
        int right = findDepth(n.right, Math.min(limit-1, left+1)); //allow delta one
        if (right==-1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return 1+ Math.max(left, right);
    }
}
