public class Consumer implements Runnable {
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
                int value = Main.inventory.get(Main.fruits[index]);
                if (value-- > 0) {
                    Main.inventory.put(Main.fruits[index], value);
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + name + " consumed 1 " +  Main.fruits[index]);
                    Main.getInfo();
                    Main.inventory.notifyAll();

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.err.println(name + " " + e.getMessage());
                    }
                }

                try {
                    Main.inventory.wait();
                } catch (Exception e) {
                    System.err.println(name + " " + e.getMessage());
                }
            }
        }
    }
}
