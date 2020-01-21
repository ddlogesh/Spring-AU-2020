public class Consumer implements Runnable {
    String[] fruits = {"apple", "orange", "grape", "watermelon"};
    int index;

    public Consumer(int i) {
        index = i;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started...");
        while (true) {
            synchronized (Main.inventory) {
                int value = Main.inventory.get(fruits[index]);
                if (value-- > 0) {
                    System.out.println(name + " removed: " + Main.inventory.put(fruits[index], value));
                    Main.inventory.notifyAll();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Main.inventory.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + " notified!");
                }
            }
        }
    }
}
