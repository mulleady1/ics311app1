import java.util.List;
import java.util.LinkedList;

public class DLLDynamicSet implements DynamicSet {

    private LinkedList<KeyType> nodes;

    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public DLLDynamicSet() {
        this.nodes = new LinkedList<KeyType>();
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.nodes.size();
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object o) {
        for (int i = 0; i < this.nodes.size(); i++) {
            KeyType key = this.nodes.get(i);
            if (key.compareTo(k) > 0) {
                this.nodes.add(i, k);
                break;
            }
        }
        if (!this.nodes.contains(k))
            this.nodes.add(k);
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
        this.nodes.remove(k);
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
        if (this.nodes.contains(k))
            return k;
        else
            return null;
    }
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    // Finds an Object that has the smallest key, and returns a pointer to it,
    // or null if the set is empty. 
    public Object minimum() {
        return this.nodes.getFirst();
    }
                                                                                         
    // Finds an Object that has the largest key, and returns a pointer to it,
    // or null if the set is empty.
    public Object maximum() {
        return this.nodes.getLast();
    }
                                                                                                         
    // Finds an Object that has the next larger key in the set above k, 
    // and returns a pointer to it, or null if k is the maximum element.
    public Object successor(KeyType k) {
        int i = this.nodes.indexOf(k);
        return this.nodes.get(i+1);
    }

    // Finds an Object that has the next smaller key in the set below k,
    // and returns a pointer to it, or null if k is the minimum element.
    public Object predecessor(KeyType k) {
        int i = this.nodes.indexOf(k);
        return this.nodes.get(i-1);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.nodes.size(); i++)
            s += this.nodes.get(i).getValue() + " ";
        return s;
    }
}

