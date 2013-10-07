public class Node {
    private Node left;
    private Node right;
    private Node above;
    private Node below;
    private KeyType key;
    public Node() { }
    public Node(String s)  { this.key = new KeyType(s); }
    public Node(KeyType k) { this.key = k; }
    public Node getLeft()   { return this.left; }
    public Node getRight()  { return this.right; }
    public Node getAbove()  { return this.above; }
    public Node getBelow()  { return this.below; }
    public KeyType getKey() { return this.key; }
    public void setLeft(Node n)   { this.left = n; }
    public void setRight(Node n)  { this.right = n; }
    public void setAbove(Node n)  { this.above = n; }
    public void setBelow(Node n)  { this.below = n; }
    public void setKey(KeyType k) { this.key = k; }
}
