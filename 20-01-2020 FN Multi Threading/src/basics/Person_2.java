package basics;

public class Person_2 implements Runnable {
    Thread t;

    Person_2(Thread t) {
        this.t = t;
    }

    public void run() {
        try {
            t.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}