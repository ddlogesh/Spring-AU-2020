package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import model.Point;
import model.Triangle;
import model.TriangleList;
import model.TriangleMap;
import service.ExternalService;

public class Shape {
	public static void main(String[] args) {
//		Point point = new Point();
//		point.setX(10);
//		point.setY(20);
//		
//		point.draw();
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//Point point = (Point) context.getBean("point");
		//System.out.print(point);
		
//		Triangle triangle = (Triangle) context.getBean("triangle");
//		System.out.print(triangle);
		
		//TriangleList triangleList = (TriangleList) context.getBean("trianglelist");
		//System.out.print(triangleList);
		
//		TriangleMap triangleMap= (TriangleMap) context.getBean("trianglemap");
//		System.out.print(triangleMap);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//Triangle triangle = (Triangle) context.getBean("triangle");
		//System.out.print(triangle);
		
		ExternalService externalService = context.getBean(ExternalService.class);
	    externalService.printTriangle();
	}
}