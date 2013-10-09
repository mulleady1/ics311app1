import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SkipListDynamicSet implements DynamicSet, Const {

    private Node head;
    private int size;
    private int numLevels;
    
    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public SkipListDynamicSet() {
        this.head = new QuadNode(MIN_VALUE);
        this.head.setRight(new QuadNode(MAX_VALUE));
        this.size = 0;
        this.numLevels = 1;
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.size;
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object e) {
        //log("Inserting into skip list.");
        // Start at top left, work our way right and down.
        Node currentNode = head;
        int currentLevel = this.numLevels;
        // If we insert a tower of nodes, we need to keep track of who the left and right will be of each node in the tower.
        Map<Integer, List<Node>> rows = new HashMap<Integer, List<Node>>();
        while (true) {
            // If the currentNode's right node is less than k, move right.
            if (currentNode.getRight().getKey().compareTo(k) < 0 && !currentNode.getRight().getKey().getValue().equals(MAX_VALUE)) {
                //log("Moving right.");
                currentNode = currentNode.getRight();
            }
            // If the currentNode's right node is >= k, move down.
            else {
                // If we're not at the bottom level, move down.
                if (currentLevel > 1) {
                    //log("Moving down.");
                    // Store the left and right nodes of the current level in case we make a tower.
                    List<Node> nodes = new ArrayList<Node>(2);
                    nodes.add(LEFT, currentNode);
                    nodes.add(RIGHT, currentNode.getRight());
                    rows.put(currentLevel, nodes);
                    currentNode = currentNode.getBelow();
                    currentLevel--;
                }
                // If we can't move down any further, we've found our insert point.
                else {
                    //log("At bottom level.");
                    // Create new node and set appropriate left and right pointers.
                    Node n = new QuadNode(k);
                    n.setLeft(currentNode);
                    n.setRight(currentNode.getRight());
                    currentNode.getRight().setLeft(n);
                    currentNode.setRight(n);
                    currentNode = n;
                    //log("Added new node and set pointers.");
                    // When the first element is inserted, we need to add a new level.
                    if (this.numLevels == 1) {
                        //log("Adding a level.");
                        addLevel();
                        // Store the nodes of the new level in case we make a tower.
                        rows.put(currentLevel+1, getTopNodes());
                    }
                    int i = 1;
                    // Flip coin to see if we're creating a tower.
                    while (Math.random() <= 0.5) {
                        //log("Adding node number " + ++i + ".");
                        // Create a tower by setting appropriate above and below pointers.
                        Node aboveNode = new QuadNode(k);
                        currentNode.setAbove(aboveNode);
                        aboveNode.setBelow(currentNode);
                        // Also set appropriate left and right pointers.
                        aboveNode.setLeft(rows.get(currentLevel+1).get(LEFT));
                        aboveNode.setRight(rows.get(currentLevel+1).get(RIGHT));
                        rows.get(currentLevel+1).get(LEFT).setRight(aboveNode);
                        rows.get(currentLevel+1).get(RIGHT).setLeft(aboveNode);
                        // Move up one level.
                        currentNode = aboveNode;
                        currentLevel++;
                        // If we're at the top level, add a new one.
                        if (currentLevel == this.numLevels) {
                            addLevel();
                            // Store the nodes of the new level in case we continue the tower.
                            rows.put(currentLevel+1, getTopNodes());
                        }
                    }
                    this.size++;
                    return;
                }
            }
        }
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
        Node currentNode = this.head;
        int currentLevel = this.numLevels;
        // Loop until we find the node we're looking for or until we reach the bottom.
        while (true) {
            if (currentNode.getKey().compareTo(k) == 0) {
                return currentNode.getKey();
            }
            // If the currentNode's right node is greater than k, try and move down one level.
            else if (currentNode.getRight().getKey().getValue().equals(MAX_VALUE) || (currentNode.getRight().getKey().compareTo(k) > 0)) {
                // If we make it here and we're at the bottom level, return null.
                if (currentLevel == 1) {
                    return null;
                }
                // If we're not at the bottom level, move down and keep searching.
                else {
                    currentNode = currentNode.getBelow();
                    currentLevel--;
                }
            }
            // If the currentNode's right node is less than k, move right.
            else {
                currentNode = currentNode.getRight();
            }
        }
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

    private void addLevel() {
        Node newHead = new QuadNode(MIN_VALUE);
        Node newHeadRight = new QuadNode(MAX_VALUE);
        newHead.setBelow(this.head);
        newHead.setRight(newHeadRight);
        this.head.setAbove(newHead);
        this.head = newHead;
        this.numLevels++;
    }

    private List<Node> getTopNodes() {
        List<Node> nodes = new ArrayList<Node>(2);
        nodes.add(LEFT, this.head);
        nodes.add(RIGHT, this.head.getRight());
        return nodes;
    }

    // Print space-separated values of the keys of the bottom row only.
    public String toString() {
        String s = "";
        Node currentNode = this.head;
        while (currentNode.getBelow() != null) {
            currentNode = currentNode.getBelow();
        }
        while (currentNode != null) {
            s += currentNode.getKey().getValue() + " ";
            currentNode = currentNode.getRight();
        }
        return s;
    }

    private void log(Object o) {
        System.out.println(String.valueOf(o));
    }
}
