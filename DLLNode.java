public class DLLNode extends Node {
    public DLLNode(String s) { super(s); }
    public DLLNode(KeyType k) { super(k); }

    // These methods are only used in QuadNode.java.
    public Node getAbove() { throw new UnsupportedOperationException(); }
    public Node getBelow() { throw new UnsupportedOperationException(); }
    public void setAbove(Node n) { throw new UnsupportedOperationException(); }
    public void setBelow(Node n) { throw new UnsupportedOperationException(); }
}
