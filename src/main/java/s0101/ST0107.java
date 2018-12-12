package s0101;
/*
107. Binary Tree Level Order Traversal II
Easy

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 */
import java.util.*;
import sutil.*;

public class ST0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> listList = new LinkedList<>();
        if (root == null) {
            return listList;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode tmp;
        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                tmp = q.remove();
                list.add(tmp.val);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            listList.addFirst(list); //or just add, and then reverse the listList before return
        }
        return listList;
    }
}
