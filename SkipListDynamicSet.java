import java.util.List;
import java.util.ArrayList;

public class SkipListDynamicSet implements DynamicSet {

    private Node head;
    private int size;
    private int numLevels;
    // Sentinel values.
    private final String MIN_VALUE = "Negative Infinity";
    private final String MAX_VALUE = "Positive Infinity";
    
    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public SkipListDynamicSet() {
        this.head = new Node(MIN_VALUE);
        this.head.setRight(new Node(MAX_VALUE));
        this.size = 0;
        this.numLevels = 1;
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.size;
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object e) {
        // Start at top left, work our way right and down.
        Node currentNode = head;
        int currentLevel = this.numLevels;
        // If we insert a tower of nodes, we need to keep track of who the left 
        // and right will be of each node in the tower.
        List<List<Node>> tempRows = new ArrayList<List<Node>>(this.numLevels);
        while (true) {
            // If the next node is greater than the key, move down.
            System.out.println(currentNode.getKey().getValue());
            if (currentNode.getRight().getKey().getValue().equals(MAX_VALUE) || (currentNode.getRight().getKey().compareTo(k) >= 0)) {
                // If we can't move down any farther, we found our insert point.
                if (currentLevel == 1) {
                    // Create new node, assign/rearrange pointers.
                    Node n = new Node(k);
                    n.setLeft(currentNode);
                    n.setRight(currentNode.getRight());
                    currentNode.setRight(n);
                    currentNode = n;
                    // Keep track of where we are in the tempRows list.
                    int i = 0;
                    // Flip coin to see if we're creating a tower.
                    while (Math.random() <= 0.5) {
                        Node aboveNode = new Node(k);
                        currentNode.setAbove(aboveNode);
                        aboveNode.setBelow(currentNode);
                        if (tempRows.isEmpty()) {
                            aboveNode.setLeft(head);
                            aboveNode.setRight(head.getRight());
                            head.setRight(aboveNode);
                            head.getRight().setLeft(aboveNode);
                        }
                        else {
                            aboveNode.setLeft(tempRows.get(i).get(0));
                            aboveNode.setRight(tempRows.get(i).get(1));
                            tempRows.get(i).get(0).setRight(aboveNode);
                            tempRows.get(i).get(1).setLeft(aboveNode);
                        }
                        currentNode = aboveNode;
                        currentLevel++;
                        i++;
                        // If we're at the top level, add a new level, set pointers and new head.
                        if (currentLevel == this.numLevels) {
                            Node newHead = new Node(MIN_VALUE);
                            Node newHeadRight = new Node(MAX_VALUE);
                            newHead.setBelow(head);
                            newHead.setRight(newHeadRight);
                            this.head.setAbove(newHead);
                            this.head = newHead;
                            this.numLevels++;
                        }
                    }
                    return;
                }
                else {
                    // Store the potential left and right nodes of our node of interest.
                    List<Node> tempNodes = new ArrayList<Node>(2);
                    tempNodes.add(0, currentNode);
                    tempNodes.add(1, currentNode.getRight());
                    tempRows.add(tempNodes);
                    currentNode = currentNode.getBelow();
                    currentLevel--;
                }
            }
            // Otherwise, move right.
            else {
                currentNode = currentNode.getRight();
            }
        }
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
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
}
