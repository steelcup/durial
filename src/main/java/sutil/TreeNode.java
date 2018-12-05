package sutil;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode addLeft(int v) {
        TreeNode n = new TreeNode(v);
        this.left = n;
        return n;
    }

    public TreeNode addRight(int v) {
        TreeNode n = new TreeNode(v);
        this.right = n;
        return n;
    }

    public void addLeftRight(int vl, int vr) {
        this.addLeft(vl);
        this.addRight(vr);
    }
}
