package s0051;
/*
94. Binary Tree Inorder Traversal
Medium

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively

 */
import java.util.*;
import sutil.*;
public class ST0094 {
    /*
     public List<Integer> inorderTraversal(TreeNode root) {
         //try recursive
         List<Integer> list = new ArrayList<>();
         travel(list, root);
         return list;
     }
    private void travel(List<Integer> list, TreeNode n) {
        if (n==null) {
            return;
        }
        travel(list, n.left);
        list.add(n.val);
        travel(list, n.right);
    }
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        addNode(stack, root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            list.add(n.val);
            addNode(stack, n.right);
        }
        return list;
    }

    private void addNode( Stack<TreeNode> stack, TreeNode n) {
        while (n != null) {
            stack.push(n);
            n = n.left;
        }
    }
}
