package exception;

import java.util.function.Consumer;

public class Main {
    static Consumer<Integer> handleException(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println("Arithmetic Exception occurred: " + e.getMessage());
            }
        };
    }

    private void printConsumer(Integer i, Consumer<Integer> consumer) {
        consumer.accept(i);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printConsumer(5, handleException(i -> System.out.println(50 / i)));
        main.printConsumer(0, handleException(i -> System.out.println(50 / i)));
    }
}