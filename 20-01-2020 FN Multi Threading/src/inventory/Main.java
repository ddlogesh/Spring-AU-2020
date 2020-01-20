package inventory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(),"Producer");

        producer.start();
        for(int i = 1; i<=3;i++){
            new Thread(new Consumer(),"Consumer_" + i).start();
        }
    }
}