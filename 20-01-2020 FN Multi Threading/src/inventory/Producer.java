package inventory;

public class Producer implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        synchronized (Main.inventory) {
            Main.inventory.add(1);
            Main.inventory.add(2);
            Main.inventory.add(3);
            Main.inventory.add(4);
            Main.inventory.notifyAll();
            System.out.println("Added: " + Main.inventory.size());
        }
    }
}