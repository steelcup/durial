package sutil;

import java.util.*;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
    public UndirectedGraphNode addNeighbor(int v) {
        UndirectedGraphNode n = new UndirectedGraphNode(v);
        this.neighbors.add(n);
        n.neighbors.add(this);
        return n;
    }
}
