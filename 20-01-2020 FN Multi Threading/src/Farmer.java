public class Farmer implements Runnable {
    int apple, orange, grape, watermelon;

    public Farmer(int a, int b, int c, int d) {
        apple = a;
        orange = b;
        grape = c;
        watermelon = d;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started...");

        synchronized (Main.inventory) {
            Main.inventory.put("apple", apple);
            Main.inventory.put("orange", orange);
            Main.inventory.put("grape", grape);
            Main.inventory.put("watermelon", watermelon);
            Main.inventory.notifyAll();
            System.out.println(name + " added!");
        }
    }
}
