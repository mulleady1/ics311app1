import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class SkipListDynamicSet implements DynamicSet {

    private List<LinkedList<KeyType>> rows;
    private final String MIN_VALUE = "Negative Infinity";
    private final String MAX_VALUE = "Positive Infinity";
    
    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public SkipListDynamicSet() {
        this.rows = new ArrayList<LinkedList<KeyType>>();
        this.rows.add(new LinkedList<KeyType>());
        this.rows.get(0).add(new KeyType(MIN_VALUE));
        this.rows.get(0).add(new KeyType(MAX_VALUE));
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.rows.get(0).size() - 2;
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object e) {
        for (LinkedList<KeyType> row : rows) {

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
