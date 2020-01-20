package inventory;

public class Consumer implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (true) {
            synchronized (Main.inventory) {
                if (!Main.inventory.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " removed: " + Main.inventory.remove(0));
                    Main.inventory.notify();
                    try{
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        Main.inventory.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " notified!");
                }
            }
        }
    }
}
