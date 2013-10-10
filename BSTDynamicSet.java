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
        
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
        // Start at the root. 
        Node currentNode = this.root;
        // Make comparisons and move down the tree as necessary.
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(k) == 0) {
                return currentNode.getKey();
            }
            else if (currentNode.getKey().compareTo(k) > 0) {
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    // Finds an Object that has the smallest key, and returns a pointer to it,
    // or null if the set is empty. 
    public Object minimum() {
        return null;
    }
                                                                                         
    // Finds an Object that has the largest key, and returns a pointer to it,
    // or null if the set is empty.
    public Object maximum() {
        return null;
    }
                                                                                                         
    // Finds an Object that has the next larger key in the set above k, 
    // and returns a pointer to it, or null if k is the maximum element.
    public Object successor(KeyType k) {
        return null;
    }

    // Finds an Object that has the next smaller key in the set below k,
    // and returns a pointer to it, or null if k is the minimum element.
    public Object predecessor(KeyType k) {
        return null;
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



