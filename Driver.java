import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

public class Driver implements Const {

    private static String[] names;
    private static Map<String, List> dict;

    public static void main(String[] args) {
        if (args.length != 1) {
            log("Usage: java Driver <inputfile>");
            System.exit(1);
        }
        // Load names into array.
        loadData(args[0]);
        // Create a map for organizing output.
        dict = new HashMap<String, List>();
        Scanner scan = new Scanner(System.in);
        try {
            // App interface.
            while (true) {
                log("\nAvailable commands: runtest insert search delete pred succ min max");
                log("Press q <Enter> to quit.");
                System.out.print("Enter a command: ");
                // Execute command.
                runCommand(scan.nextLine().trim());
            }
        }
        catch (NoSuchElementException e) {
            quit();
        }
    }

    private static void runCommand(String input) {
        Scanner scan = new Scanner(System.in);
        if (input.equals("q")) {
            quit();
        }
        else if (input.equals(RUNTEST)) {
            runtest();
        }
        else if (input.equals(INSERT)) {
            System.out.print("Enter key to be inserted: ");
            insert(scan.nextLine());
        }
        else if (input.equals(SEARCH)) {
            System.out.print("Enter key to be searched: ");
            search(scan.nextLine());
        }
        else if (input.equals(DELETE)) {
            System.out.print("Enter key to be deleted: ");
            delete(scan.nextLine());
        }
        else if (input.equals(PRED)) {
            System.out.print("Enter key to find predecessor of: ");
            pred(scan.nextLine());
        }
        else if (input.equals(SUCC)) {
            System.out.print("Enter key to find successor of: ");
            succ(scan.nextLine());
        }
        else if (input.equals(MIN)) {
            min();
        }
        else if (input.equals(MAX)) {
            max();
        }
        else {
            log("Unknown command.");
        }

    }

    private static void runtest() {
        // List for storing returned keys.
        List<Object> keyTypes = new ArrayList<Object>();
        // long variables for timing method calls.
        long start, runtime;
        // List for storing runtimes.
        List<Long> insertTimes = new ArrayList<Long>();
        // First DynamicSet is the linked list implementation.
        DynamicSet ds = new DLLDynamicSet();
        // For loop for 'insert'.
        for (int i = 0; i < names.length; i++) {
            KeyType k = new KeyType(names[i]);
            start = System.nanoTime();
            ds.insert(k, null);
            runtime = System.nanoTime() - start;
            insertTimes.add(runtime);
        }
        // Add 'insert' runtimes to map.
        dict.put(INSERT, insertTimes);
        Random rand = new Random();
        List<Long> searchTimes = new ArrayList<Long>();
        // For loop for 'search'.
        for (int i = 0; i < LIMIT; i++) {
            int randomInt = rand.nextInt(names.length);
            KeyType k = new KeyType(names[randomInt]);
            start = System.nanoTime();
            Object o = ds.search(k);
            runtime = System.nanoTime() - start;
            searchTimes.add(runtime);
            keyTypes.add(o);
        }
        // Add 'search' runtimes to map.
        dict.put(SEARCH, searchTimes);
        List<Long> predTimes = new ArrayList<Long>();
        // For loop for 'pred'.
        for (int i = 0; i < keyTypes.size(); i++) {
            KeyType k = (KeyType)keyTypes.get(i);
            start = System.nanoTime();
            ds.predecessor(k);
            runtime = System.nanoTime() - start;
            predTimes.add(runtime);
        }
        // Add 'pred' runtimes to map.
        dict.put(PRED, predTimes);
        List<Long> succTimes = new ArrayList<Long>();
        // For loop for 'succ'.
        for (int i = 0; i < keyTypes.size(); i++) {
            KeyType k = (KeyType)keyTypes.get(i);
            start = System.nanoTime();
            ds.successor(k);
            runtime = System.nanoTime() - start;
            succTimes.add(runtime);
        }
        // Add 'succ' runtimes to map.
        dict.put(SUCC, succTimes);
        // Run min.
        List<Long> minTimes = new ArrayList<Long>();
        start = System.nanoTime();
        ds.minimum();
        runtime = System.nanoTime() - start;
        minTimes.add(runtime);
        dict.put(MIN, minTimes);
        // Run max.
        List<Long> maxTimes = new ArrayList<Long>();
        start = System.nanoTime();
        ds.maximum();
        runtime = System.nanoTime() - start;
        maxTimes.add(runtime);
        dict.put(MAX, maxTimes);

        printResults();
    }

    private static void insert(String key) {
        log("Inserting...");
    }

    private static void search(String key) {
    }

    private static void delete(String key) {
    }

    private static void pred(String key) {
    }

    private static void succ(String key) {
    }

    private static void min() {
    }

    private static void max() {
    }

    private static void quit() {
        log("\nBye.");
        System.exit(0);
    }

    private static void loadData(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            if (br == null) {
                log("File error.");
                System.exit(1);
            }
            List<String> lines = new ArrayList<String>();
            String line;
            // Load input file into a list.
            while ((line = br.readLine()) != null)
                lines.add(line);

            // Load global 'names' array.
            names = new String[lines.size()];
            for (int i = 0; i < lines.size(); i++)
                names[i] = lines.get(i);

            if (br != null) br.close();
            if (fr != null) fr.close();
        }
        catch (IOException e) {
            log("IO error.");
            System.exit(1);
        }
    }

    private static long[] computeResults(String functionName, boolean loopEntireArray) {
        List runTimes = dict.get(functionName);
        long min, max, avg = 0;
        min = max = (long)runTimes.get(0);
        int limit = loopEntireArray ? runTimes.size() : LIMIT;
        for (int i = 1; i < limit; i++) {
            long time = (long)runTimes.get(i);
            if (time < min)
                min = time;
            if (time > max)
                max = time;
            avg += time;
        }
        avg /= runTimes.size();
        // Bad practice here: put min, max, & avg in an array and return it.
        return new long[] { min, max, avg };
    }

    private static void printResults() {
        long[] insertResults = computeResults(INSERT, true);
        long[] searchResults = computeResults(SEARCH, false);
        long[] predResults   = computeResults(PRED, false);
        long[] succResults   = computeResults(SUCC, false);

        String insert = insertResults[0] + " / " + insertResults[1]  + " / " + insertResults[2];
        String search = searchResults[0] + " / " + searchResults[1] + " / " + searchResults[2];
        String pred   = predResults[0]   + " / " + predResults[1]    + " / " + predResults[2];
        String succ   = succResults[0]   + " / " + succResults[1]    + " / " + succResults[2];
        String min    = dict.get(MIN).get(0).toString();
        String max    = dict.get(MAX).get(0).toString();

        log("Size: " + names.length);
        log("---------------------------------------------------------");
        log("            | LL       |  SK      |  BST     | RBT      |");
        log("---------------------------------------------------------");
        log("insert      | "+insert+"  |          |          |          |");
        log("---------------------------------------------------------");
        log("search      | "+search+" |          |          |          |");
        log("---------------------------------------------------------");
        log("predecessor | "+pred+" |          |          |          |");
        log("---------------------------------------------------------");
        log("successor   | "+succ+" |          |          |          |");
        log("---------------------------------------------------------");
        log("minimum     | "+min+"  |          |          |          |");
        log("---------------------------------------------------------");
        log("maximum     | "+max+"  |          |          |          |");
        log("---------------------------------------------------------");

        dict.clear();
    }

    private static void log(Object o) {
        System.out.println(String.valueOf(o));
    }
}
