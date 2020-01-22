package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import model.Point;
import model.Triangle;

@Configuration
public class AppConfig {

	@Bean(name="triangle")
	@Scope("prototype")
	public Triangle getTriangle() {
		Triangle triangle = new Triangle();
		Point p1 = getPoint1();
		Point p2 = getPoint2();
		Point p3 = getPoint3();
		
		triangle.setP1(p1);
		triangle.setP2(p2);
		triangle.setP3(p3);
		return triangle;
	}
	
	public Point getPoint1() {
		Point p1 = new Point();
		p1.setX(11);
		p1.setY(13);
		return p1;
	}
	
	public Point getPoint2() {
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(17);
		return p1;
	}
	
	public Point getPoint3() {
		Point p1 = new Point();
		p1.setX(19);
		p1.setY(23);
		return p1;
	}
}