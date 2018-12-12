package sutil;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

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
