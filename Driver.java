import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Driver {

    private static String[] names;

    public static void main(String[] args) {
        if (args.length != 1) {
            log("Usage: java Driver <inputfile>");
            System.exit(1);
        }
        // Load names into array.
        loadData(args[0]);
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
        else if (input.equals("runtest")) {
            runtest();
        }
        else if (input.equals("insert")) {
            System.out.print("Enter key to be inserted: ");
            insert(scan.nextLine());
        }
        else if (input.equals("search")) {
            System.out.print("Enter key to be searched: ");
            search(scan.nextLine());
        }
        else if (input.equals("delete")) {
            System.out.print("Enter key to be deleted: ");
            delete(scan.nextLine());
        }
        else if (input.equals("pred")) {
            System.out.print("Enter key to find predecessor of: ");
            pred(scan.nextLine());
        }
        else if (input.equals("succ")) {
            System.out.print("Enter key to find successor of: ");
            succ(scan.nextLine());
        }
        else if (input.equals("min")) {
            min();
        }
        else if (input.equals("max")) {
            max();
        }
        else {
            log("Unknown command.");
        }

    }

    private static void runtest() {
        DynamicSet ds = new DLLDynamicSet();
        for (int i = 0; i < names.length; i++) {
            KeyType k = new KeyType(names[i]);
            ds.insert(k, null);
        }
        log(ds);

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

    private static void printResults() {
        log("Size: " + names.length);
        log("---------------------------------------------------------");
        log("            | LL       |  SK      |  BST     | RBT      |");
        log("---------------------------------------------------------");
        log("insert      |          |          |          |          |");
        log("---------------------------------------------------------");
        log("search      |          |          |          |          |");
        log("---------------------------------------------------------");
        log("predecessor |          |          |          |          |");
        log("---------------------------------------------------------");
        log("successor   |          |          |          |          |");
        log("---------------------------------------------------------");
        log("minimum     |          |          |          |          |");
        log("---------------------------------------------------------");
        log("maximum     |          |          |          |          |");
        log("---------------------------------------------------------");
    }

    private static void log(Object o) {
        System.out.println(String.valueOf(o));
    }
}
