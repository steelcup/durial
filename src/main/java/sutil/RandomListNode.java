package sutil;

public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) {
        this(x, null);
    }

    public RandomListNode(int x, RandomListNode rnode) {
        this.label = x;
        this.random = rnode;
    }

    public RandomListNode addNext(int x) {
        return addNext(x, null);
    }

    public RandomListNode addNext(int x, RandomListNode rnode) {
        RandomListNode n = new RandomListNode(x, rnode);
        this.next = n;
        return n;
    }
}
