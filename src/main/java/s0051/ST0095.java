package s0051;
/*
95. Unique Binary Search Trees II
Medium

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
import org.junit.jupiter.api.Test;
import sutil.*;
import java.util.*;

public class ST0095 {

    @Test
    public void test() {
        System.out.println(this.generateTrees(3).toString());
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = generate(1, n);
        return list;
    }

    private List<TreeNode> generate(int from, int to) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            List<TreeNode> lefts = generate(from, i-1);
            List<TreeNode> rights = generate(i+1, to);
            if (lefts.size()==0) lefts.add(null); //or can do the check at the beginning of this func
            if (rights.size()==0) rights.add(null);
            for (TreeNode left : lefts) {
                for (TreeNode right: rights) {
                    TreeNode ln = new TreeNode(i);
                    ln.left = left;
                    ln.right = right;
                    list.add(ln);
                }
            }
        }
        return list;
    }
}
