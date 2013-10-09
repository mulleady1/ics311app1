abstract class Node {
    protected Node left;
    protected Node right;
    protected KeyType key;
    public Node(String s) { this.key = new KeyType(s); }
    public Node(KeyType k) { this.key = k; }
    public Node getLeft()   { return this.left; }
    public Node getRight()  { return this.right; }
    public KeyType getKey() { return this.key; }
    public void setLeft(Node n)   { this.left = n; }
    public void setRight(Node n)  { this.right = n; }
    public void setKey(KeyType k) { this.key = k; }
    
    // Abstract methods for QuadNode.
    abstract Node getAbove();
    abstract Node getBelow();
    abstract void setAbove(Node n);
    abstract void setBelow(Node n);
}
