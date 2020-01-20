package basics;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread Person_1 = new Thread(new Person_1(), "basics.Person_1");
        Thread Person_2 = new Thread(new Person_2(Person_1), "basics.Person_2");

        Person_1.setPriority(Thread.MIN_PRIORITY);
        Person_2.setPriority(Thread.MAX_PRIORITY);
        Person_1.start();
        Person_2.start();

        System.out.println("I'm done");
    }
}