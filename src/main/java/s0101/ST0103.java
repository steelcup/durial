package s0101;
/*
103. Binary Tree Zigzag Level Order Traversal
Medium

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
 */
import java.util.*;
import sutil.*;

public class ST0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        boolean leftToRight = true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode tmp;
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                tmp = q.remove();
                if (leftToRight) {
                    list.add(tmp.val);
                } else {
                    list.add(0, tmp.val);
                }
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            listList.add(list);
            leftToRight = !leftToRight;
        }
        return listList;
    }
}
