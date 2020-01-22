package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;
import service.EmployeeManager;

//@ComponentScan(basePackages="main")
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeManager employeeManager = context.getBean(EmployeeManager.class);
		
		//employeeManager.createEmployee(new Employee(1,"logesh","director"));
		
		employeeManager.getEmployeeById(1);
	}
}