package consumer;

public class Main {
    private void printTriConsumer(String s, Integer i, Boolean b, TriConsumer<String, Integer, Boolean> consumer) {
        consumer.accept(s, i, b);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printTriConsumer("String", 5, true, (s, i, b) -> System.out.println(s + " " + i + " " + b));
    }
}