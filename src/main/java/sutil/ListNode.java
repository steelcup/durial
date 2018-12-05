package sutil;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int v) {
        this.val = v;
    }

    public ListNode addNext(int v) {
        ListNode node = new ListNode(v);
        this.next = node;
        return node;
    }

    public void print() {
        ListNode n = this;
        do {
            System.out.print(n.val);
            System.out.print(" ");
            n = n.next;
        } while (n != null);
        System.out.println();
    }
}