package s0101;
/*
113. Path Sum II
Medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
import sutil.*;
import java.util.*;

public class ST0113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listList = new ArrayList<>();
        travel(listList, new ArrayList<>(), root, sum);
        return listList;
    }

    private void travel(List<List<Integer>> listList, List<Integer> buf, TreeNode n, int target) {
        if (n == null) {
            return;
        }
        if (n.left==null && n.right==null && n.val==target) {
            List<Integer> list = new ArrayList<>(buf);
            list.add(n.val);
            listList.add(list);
            return;
        }
        buf.add(n.val);
        travel(listList, buf, n.left, target-n.val);
        travel(listList, buf, n.right, target-n.val);
        buf.remove(buf.size()-1);
    }
}
