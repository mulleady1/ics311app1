// Convenient place to store constants.
public interface Const {
    final String RUNTEST = "runtest";
    final String INSERT  = "insert";
    final String SEARCH  = "search";
    final String DELETE  = "delete";
    final String PRED    = "pred";
    final String SUCC    = "succ";
    final String MAX     = "max";
    final String MIN     = "min";
    // Constants used in Driver.java.
    final int LIMIT = 10;
    final int NUM_DATA_STRUCTURES = 2;
    // Sentinel values.
    final String MIN_VALUE = "NEGATIVE_INFINITY";
    final String MAX_VALUE = "POSITIVE_INFINITY";
    // Constants used when prepping a tower of nodes in the skip list.
    final int LEFT = 0;
    final int RIGHT = 1;
}
