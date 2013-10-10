public class DLLNode extends Node {
    public DLLNode(String s) { super(s); }
    public DLLNode(KeyType k) { super(k); }

    // These methods are used in QuadNode and BSTNode only.
    public Node getAbove() { throw new UnsupportedOperationException(); }
    public Node getBelow() { throw new UnsupportedOperationException(); }
    public void setAbove(Node n) { throw new UnsupportedOperationException(); }
    public void setBelow(Node n) { throw new UnsupportedOperationException(); }
    public Node getP() { throw new UnsupportedOperationException(); }
    public void setP(Node n) { throw new UnsupportedOperationException(); }
}
