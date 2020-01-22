package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Component;

import model.Employee;

@Component
public class EmployeeManager {
	public void getEmployeeById(Integer id) {
		System.out.println("getEmployeeById called " + LocalDateTime.now());
		//return new Employee();
	}
	
	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees called");
		return new ArrayList<Employee>();
	}
	
	public void createEmployee(Employee e) {
		System.out.println("createEmployee called");
	}
	
	public void updateEmployee(Employee e) {
		System.out.println("updateEmployee called");
	}
	
	public void deleteEmployee(Employee e) {
		System.out.println("deleteEmployee called");
	}
}
