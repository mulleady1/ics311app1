public class DLLDynamicSet implements DynamicSet, Const {

    private Node head;
    private int size;

    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public DLLDynamicSet() {
        this.head = new DLLNode(MIN_VALUE);
        this.head.setRight(this.head);
        this.head.setLeft(this.head);
        this.size = 0;
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.size;
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object o) {
        // Start at the first node, moving right until we find our insert point.
        Node currentNode = this.head.getRight();
        // While the current node's key is less than k, move right.
        while (!currentNode.getKey().getValue().equals(MIN_VALUE) && currentNode.getKey().compareTo(k) < 0) {
            currentNode = currentNode.getRight();
        }
        // Create a new node and set pointers.
        Node n = new DLLNode(k);
        n.setLeft(currentNode.getLeft());
        n.setRight(currentNode);
        currentNode.getLeft().setRight(n);
        currentNode.setLeft(n);
        this.size++;
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
        // Start at the first node, moving right until we find k.
        Node currentNode = this.head.getRight();
        // While the current node's key is not k, move right.
        while (currentNode.getKey().compareTo(k) != 0) {
            // If we make it back to the head, k is not in the list.
            if (currentNode.getKey().getValue().equals(MIN_VALUE)) {
                return;
            }
            currentNode = currentNode.getRight();
        }
        // Found k. Rearrange pointers, removing it from the list.
        currentNode.getRight().setLeft(currentNode.getLeft());
        currentNode.getLeft().setRight(currentNode.getRight());
        currentNode.setLeft(null);
        currentNode.setRight(null);
        currentNode = null;
        this.size--;
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
        // Start at the first node, moving right until we find k.
        Node currentNode = this.head.getRight();
        // While the current node's key is not k, move right.
        while (currentNode.getKey().compareTo(k) != 0) {
            // If we make it back to the head, return null.
            if (currentNode.getKey().getValue().equals(MIN_VALUE)) {
                return null;
            }
            currentNode = currentNode.getRight();
        }
        return currentNode.getKey();
    }
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    // Finds an Object that has the smallest key, and returns a pointer to it,
    // or null if the set is empty. 
    public Object minimum() {
        if (this.size > 0)
            return this.head.getRight().getKey();
        else
            return null;
    }
                                                                                         
    // Finds an Object that has the largest key, and returns a pointer to it,
    // or null if the set is empty.
    public Object maximum() {
        if (this.size > 0)
            return this.head.getLeft().getKey();
        else
            return null;
    }
                                                                                                         
    // Finds an Object that has the next larger key in the set above k, 
    // and returns a pointer to it, or null if k is the maximum element.
    public Object successor(KeyType k) {
        // If the head's left node is k, then k is the max element.
        if (this.head.getLeft().getKey().compareTo(k) == 0) {
            return null;
        }
        // Otherwise, iterate over list to find k.
        else {
            Node currentNode = this.head.getRight();
            // Move right until we find k.
            while (currentNode.getKey().compareTo(k) != 0) {
                // If we make it back to the head, return null.
                if (currentNode.getKey().getValue().equals(MIN_VALUE)) {
                    return null;
                }
                currentNode = currentNode.getRight();
            }
            // Found k. Return its right element's key.
            return currentNode.getRight().getKey();
        }
    }

    // Finds an Object that has the next smaller key in the set below k,
    // and returns a pointer to it, or null if k is the minimum element.
    public Object predecessor(KeyType k) {
        // If the head's right node is k, then k is the min element.
        if (this.head.getRight().getKey().compareTo(k) == 0) {
            return null;
        }
        // Otherwise, iterate over list to find k.
        else {
            Node currentNode = this.head.getRight();
            // Move right until we find k.
            while (currentNode.getKey().compareTo(k) != 0) {
                // If we make it back to the head, return null.
                if (currentNode.getKey().getValue().equals(MIN_VALUE)) {
                    return null;
                }
                currentNode = currentNode.getRight();
            }
            // Found k. Return its left element's key.
            return currentNode.getLeft().getKey();
        }
    }

    public String toString() {
        String s = "";
        // Start at the first node, print space-separated keys of all nodes.
        Node currentNode = this.head.getRight();
        while (!currentNode.getKey().getValue().equals(MIN_VALUE)) {
            s += currentNode.getKey().getValue() + " ";
            currentNode = currentNode.getRight();
        }
        return s;
    }
}
