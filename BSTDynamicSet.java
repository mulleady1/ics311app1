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
        return this.size;
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
        this.nodeDelete(k);
    }

    // Same concept from the book.
    private void nodeDelete(KeyType k) {
        Node n = this.nodeSearch(k);
        // If the search was unsuccessful, we're done.
        if (n == null)
            return;
        // If n has no left child, replace it with its right child, which may be null.
        if (n.getLeft() == null) {
            this.transplant(n, n.getRight());
        }
        // If n has no right child, replace it with its left child.
        else if (n.getRight() == null) {
            this.transplant(n, n.getLeft());
        }
        // Otherwise, move n's successor's right child into n's successor's spot, and
        // n's successor into n's spot, then rearrange pointers.
        else {
            Node y = this.nodeMinimum(n.getRight());
            if (y.getP() != n) {
                this.transplant(y, y.getRight());
                y.setRight(n.getRight());
                y.getRight().setP(y);
            }
            this.transplant(n, y);
            y.setLeft(n.getLeft());
            y.getLeft().setP(y);
        }
        this.size--;
    }

    // Straight from the book.
    private void transplant(Node oldNode, Node newNode) {
        if (oldNode.getP() == null)
            this.root = newNode;
        else if (oldNode == oldNode.getP().getLeft())
            oldNode.getP().setLeft(newNode);
        else 
            oldNode.getP().setRight(newNode);
        if (newNode != null)
            newNode.setP(oldNode.getP());
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



