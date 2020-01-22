package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Point;

public class Shape {
	public static void main(String[] args) {
//		Point point = new Point();
//		point.setX(10);
//		point.setY(20);
//		
//		point.draw();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Point point = (Point) context.getBean("point");
		point.draw();
	}
}