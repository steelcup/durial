package s0101;
/*
111. Minimum Depth of Binary Tree
Easy

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.

 */
import sutil.*;
import java.util.*;

public class ST0111 {
    public int minDepth(TreeNode root) {
        int level=0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            int len = q.size();
            level++;
            while (len > 0) {
                TreeNode n = q.remove();
                if (n.left==null && n.right==null) {
                    return level;
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
                len--;
            }
        }
        return 0;
    }
}
