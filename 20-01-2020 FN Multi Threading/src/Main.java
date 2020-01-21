import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            if (i == 1 || i == 4)
                new Thread(new Farmer(i * 2 - 1, i + 2, i + 4, i * 3), "Farmer_" + i).start();
            else
                new Thread(new Farmer(i * 3, i + 4, i + 2, i * 2 - 1), "Farmer_" + i).start();
        }

        for (int i = 1; i <= 4; i++)
            new Thread(new Consumer(i - 1), "Consumer_" + i).start();
    }
}