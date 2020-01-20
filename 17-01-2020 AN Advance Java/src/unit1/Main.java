package unit1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	private void perform(Action1 action1) {
		action1.perform();
		//System.out.println("Performs an Static Action");
	}
	
	private int addTen(int a, Function<Integer, Integer> function) {
		return function.apply(a);
	}
	
	private void printUsingConsumer(String s, Consumer<String> consumer) {
		consumer.accept(s);
	}
	
	private void testUsingPred(int[] array, Predicate<Integer> p) {
		for (int i : array) {
			if (p.test(i)) {
				System.out.println(i);
			}
		}
	}
	
	private void printHello() {
		System.out.println("Hello Method Reference");
	}
	
	public static void main(String[] args) {

		Main main = new Main();
		//mainClass.perform();
		
		Action1 action = new ImplementsAction1();
		//mainClass.perform(action);

		Action1 innerClassActionImplementation = new Action1() {
			public void perform() {
				System.out.println("Perform Of InnerClass Implementation");
			}
		};

		//mainClass.perform(innerClassActionImplementation);

		Action1 lambdaExpression = () -> System.out.println("Lambda");
		
		//mainClass.perform(lambdaExpression);
		
		//mainClass.perform(() -> System.out.println("Lambda inline"));

		//System.out.println(mainClass.addTen(100, (a) -> a + 10));

		//mainClass.printUsingConsumer("Hello Consumer", p -> System.out.println(p));

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//mainClass.testUsingPred(array, (p) -> { return p % 2 == 0;});

		Action1 action2 = main::printHello;
		main.perform(action2);

	}
}