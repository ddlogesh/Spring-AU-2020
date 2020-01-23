package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;
import model.EmployeeMap;
import model.Point;
import service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
	    System.out.println("AOP-----------------------------------------\n");
	    
	    EmployeeService externalService = (EmployeeService) context.getBean(EmployeeService.class);
	    List<Employee> empList = externalService.getAllEmployees();
	    System.out.println(empList);
	    
	    System.out.println("\nMap-----------------------------------------\n");
	    
	    EmployeeMap employeeMap= (EmployeeMap) context.getBean("employeemap");
		System.out.println(employeeMap);
		
		System.out.println("\nPointConfig-----------------------------------------\n");
		
		Point point = (Point) context.getBean(Point.class);
		System.out.println(point.getX() + " " + point.getY());
	}
}
