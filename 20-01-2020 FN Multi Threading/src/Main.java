import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, Integer> inventory = new HashMap<>();
    public static final String[] fruits = {"apple", "orange", "grape", "watermelon"};
    public static final int threshold = 3;

    public static void main(String[] args) {
        initialize();
        for (int i = 1; i <= 3; i++)
            new Thread(new Farmer(i, i + 1, i + 2, i + 3), "Farmer_" + i).start();

        for (int i = 1; i <= 4; i++)
            new Thread(new Consumer(i - 1), "Consumer_" + i).start();
    }

    public static void initialize(){
        Main.inventory.put("apple", 5);
        Main.inventory.put("orange", 5);
        Main.inventory.put("grape", 5);
        Main.inventory.put("watermelon", 5);
        System.out.println("Inventory initialised with (5) fruits each and " + threshold + " threshold.");
        getInfo();
    }

    public static void getInfo() {
        System.out.println("\t\t\t\t\t" + inventory.toString());
    }
}