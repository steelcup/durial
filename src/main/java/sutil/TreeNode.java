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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        this.toString(sb);
        sb.append("]\n");
        return sb.toString();
    }

    private void toString(StringBuilder sb) {
        if (sb.length() > 1) {
            sb.append(", ");
        }
        sb.append(this.val);
        if (this.left == null) {
            sb.append(", null");
        } else {
            this.left.toString(sb);
        }
        if (this.right == null) {
            sb.append(", null");
        } else {
            this.right.toString(sb);
        }
    }
}
