package s0101;
/*
145. Binary Tree Postorder Traversal
Hard

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?
 */
import org.junit.jupiter.api.Test;
import sutil.*;
import java.util.*;

public class ST0145 {
    @Test
    public void test() {
        TreeNode r = new TreeNode(1);
        r.addRight(2).addLeft(3);
        System.out.println(postorderTraversal(r).toString());
        r = new TreeNode(1);
        r.addRight(2).addLeft(3);
        System.out.println(postorderTraversa2(r).toString());
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //travel(list, root);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //try don't push all the way. :)
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n.left == null && n.right == null) {
                list.add(n.val);
            } else {
                stack.push(n);
                if (n.right != null) {
                    stack.push(n.right);
                    n.right = null;
                }
                if (n.left != null) {
                    stack.push(n.left);
                    n.left = null;
                }
            }
        }
        return list;
    }

    public List<Integer> postorderTraversa2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        travel(list, root);
        return list;
    }

    private void travel(List<Integer> list, TreeNode n) {
        if (n == null) {
            return;
        }
        travel(list, n.left);
        travel(list, n.right);
        list.add(n.val);
    }
}
