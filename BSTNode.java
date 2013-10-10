public class BSTNode extends Node {
    private Node p;

    public BSTNode() { }
    public BSTNode(String s)  { super(s); }
    public BSTNode(KeyType k) { super(k); }
    public Node getP() { return this.p; }
    public void setP(Node n) { this.p = n; }

    // These methods are used in QuadNode only.
    public Node getAbove() { throw new UnsupportedOperationException(); }
    public Node getBelow() { throw new UnsupportedOperationException(); }
    public void setAbove(Node n) { throw new UnsupportedOperationException(); }
    public void setBelow(Node n) { throw new UnsupportedOperationException(); }
}
