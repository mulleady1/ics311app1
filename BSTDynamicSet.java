public class BSTDynamicSet implements DynamicSet {
     
    private int size;
    private Node root;

    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public BSTDynamicSet() {
        this.size = 0;
        this.root = null;
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.size();
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object e) {
        // If the tree is empty, insert at the root.
        if (this.size == 0) {
            this.root = new BSTNode(k);
            this.size++;
            return;
        }
        // Move down the tree until we find a null node to be our insertion point.
        Node currentNode = this.root;
        Node previousNode = this.root;
        while (currentNode != null) {
            // Keep track of parent node as we move down.
            previousNode = currentNode;
            // If the current node's key is larger than k, move left.
            if (currentNode.getKey().compareTo(k) > 0) {
                currentNode = currentNode.getLeft();
            }
            // Otherwise, move right.
            else {
                currentNode = currentNode.getRight();
            }
        }
        // Insert new node.
        currentNode = new BSTNode(k);
        currentNode.setP(previousNode);
        // Determine whether currentNode will be the left or right child of its parent.
        if (previousNode.getKey().compareTo(k) > 0)
            previousNode.setLeft(currentNode);
        else
            previousNode.setRight(currentNode);
        this.size++;
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
        Node n = this.nodeSearch(k);
        // If the search was unsuccessful, we're done.
        if (n == null)
            return;
        // If n has no children, just remove it.
        if (n.getLeft() == null && n.getRight() == null) {
            // Find out if n is a left or a right child.
            if (n.getP().getLeft() == n)
                n.getP().setLeft(null);
            else
                n.getP().setRight(null);
            n.setP(null);
            n = null;
        }
        // If n has children, replace it with its successor.
        else {
            // Get n's successor and the child that will take the successor's place.
            KeyType yKey = (KeyType)this.successor(k);
            Node y = this.nodeSearch(yKey);
            KeyType zKey = (KeyType)this.successor(yKey);
            Node z = this.nodeSearch(zKey);

        }
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
        Node n = this.nodeSearch(k);
        return n != null ? n.getKey() : null;
    }

    // Returns the node of interest.
    private Node nodeSearch(KeyType k) {
        if (this.size == 0)
            return null;
        // Start at the root. 
        Node currentNode = this.root;
        // Make comparisons and move down the tree as necessary.
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(k) == 0) {
                return currentNode;
            }
            else if (currentNode.getKey().compareTo(k) > 0) {
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        // If we made it here, the search was unsuccessful.
        return null;
    }
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    // Finds an Object that has the smallest key, and returns a pointer to it,
    // or null if the set is empty. 
    public Object minimum() {
        Node n = this.nodeMinimum(this.root);
        return n != null ? n.getKey() : null;
    }

    private Node nodeMinimum(Node n) {
        if (this.size == 0)
            return null;
        // Move to the very bottom left of n's subtree.
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }
                                                                                         
    // Finds an Object that has the largest key, and returns a pointer to it,
    // or null if the set is empty.
    public Object maximum() {
        Node n = this.nodeMaximum(this.root);
        return n != null ? n.getKey() : null;
    }

    private Node nodeMaximum(Node n) {
        if (this.size == 0)
            return null;
        // Move to the very bottom right of n's subtree.
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
    }
                                                                                                         
    // Finds an Object that has the next larger key in the set above k, 
    // and returns a pointer to it, or null if k is the maximum element.
    public Object successor(KeyType k) {
        Node n = this.nodeSuccessor(k);
        return n != null ? n.getKey() : null;
    }

    private Node nodeSuccessor(KeyType k) {
        Node n = this.nodeSearch(k);
        if (n == null)
            return null;
        if (n.getRight() != null) {
            Node max = this.nodeMinimum(n.getRight());
            return max != null ? max : null;
        }
        Node y = n.getP();
        while (y != null && n == y.getRight()) {
            n = y;
            y = y.getP();
        }
        return y;
    }

    // Finds an Object that has the next smaller key in the set below k,
    // and returns a pointer to it, or null if k is the minimum element.
    public Object predecessor(KeyType k) {
        Node n = this.nodePredecessor(k);
        return n != null ? n.getKey() : null;
    }

    private Node nodePredecessor(KeyType k) {
        Node n = this.nodeSearch(k);
        if (n == null)
            return null;
        if (n.getLeft() != null) {
            Node min = this.nodeMaximum(n.getLeft());
            return min != null ? min : null;
        }
        Node y = n.getP();
        while (y != null && n == y.getLeft()) {
            n = y;
            y = y.getP();
        }
        return y;
    }

    public String toString() {
        this.inOrder(this.root);
        return "";
    }

    private void inOrder(Node n) {
        if (n != null) {
             this.inOrder(n.getLeft());
             log(n.getKey().getValue() + " ");
             this.inOrder(n.getRight());
        }
    }

    private void log(Object o) {
        System.out.print(String.valueOf(o));
    }
}



