package s0101;
/*
144. Binary Tree Preorder Traversal
Medium

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.*;

import org.junit.jupiter.api.Test;
import sutil.*;

public class ST0144 {
    @Test
    public void test() {
        TreeNode r = new TreeNode(1);
        r.addRight(2).addLeft(3);
        System.out.println(preorderTraversal(r).toString());
        System.out.println(preorderTraversal2(r).toString());
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while(!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            if (node.right != null) {//it is stack so put right first
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        travel(list, root);
        return list;
    }

    private void travel(List<Integer> list, TreeNode n) {
        if (n == null) {
            return;
        }
        list.add(n.val);
        travel(list, n.left);
        travel(list, n.right);
    }
}
