public class Farmer implements Runnable {
    int apple, orange, grape, watermelon;
    String name;

    public Farmer(int a, int b, int c, int d) {
        apple = a;
        orange = b;
        grape = c;
        watermelon = d;
    }

    @Override
    public void run() {
        name = Thread.currentThread().getName();
        System.out.println(name + " started...");

        while(true) {
            synchronized (Main.inventory) {
                addFruit("apple", apple);
                addFruit("orange", orange);
                addFruit("grape", grape);
                addFruit("watermelon", watermelon);

                try {
                    Main.inventory.wait();
                } catch (Exception e) {
                    System.err.println(name + " " + e.getMessage());
                }
            }
        }
    }

    public void addFruit(String fruit, int value){
        /*
        Assumption:
        Considering (total) as total capacity & (current) as current threshold of fruit,
        Farmer can sell (x) fruits only if
                  (current) <= (total)
         */

        int present = Main.inventory.get(fruit);
        if (present <= Main.threshold) {
            Main.inventory.put(fruit, present + value);
            System.out.println("\n" + name + " sold " + value + " " + fruit + "(s)");
            Main.getInfo();
            Main.inventory.notifyAll();
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println(name + " " + e.getMessage());
        }
    }
}