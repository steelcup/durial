package s0101;
/*
102. Binary Tree Level Order Traversal
Medium

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.*;
import sutil.*;

public class ST0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            while (len > 0) { //or use a for loop
                TreeNode n = q.remove();
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right !=null) {
                    q.add(n.right);
                }
                list.add(n.val);
                len--;
            }
            listList.add(list);
        }
        return listList;
    }
}
