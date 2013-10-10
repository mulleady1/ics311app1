public class QuadNode extends Node {
    private Node above;
    private Node below;
    public QuadNode() { }
    public QuadNode(String s)  { super(s); }
    public QuadNode(KeyType k) { super(k); }
    public Node getAbove() { return this.above; }
    public Node getBelow() { return this.below; }
    public void setAbove(Node n) { this.above = n; }
    public void setBelow(Node n) { this.below = n; }

    // These methods are used in BSTNode only.
    public Node getP() { throw new UnsupportedOperationException(); }
    public void setP(Node n) { throw new UnsupportedOperationException(); }
}
