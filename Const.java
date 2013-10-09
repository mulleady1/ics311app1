public interface Const {
    static final String RUNTEST = "runtest";
    static final String INSERT  = "insert";
    static final String SEARCH  = "search";
    static final String DELETE  = "delete";
    static final String PRED    = "pred";
    static final String SUCC    = "succ";
    static final String MAX     = "max";
    static final String MIN     = "min";
    static final int LIMIT = 10;
    static final int NUM_DATA_STRUCTURES = 2;
    // Sentinel values.
    final String MIN_VALUE = "NEGATIVE_INFINITY";
    final String MAX_VALUE = "POSITIVE_INFINITY";
    // Constants used when prepping a tower of nodes in the skip list.
    final int LEFT = 0;
    final int RIGHT = 1;
}
