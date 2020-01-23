package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	@Qualifier("employee")
	private Employee emp;
	
	public List<Employee> getAllEmployees(){
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "logesh", "Intern"));
		empList.add(new Employee(2, "rajini", "Intern"));
		empList.add(new Employee(3, "vijay", "Intern"));
		empList.add(new Employee(4, "ajith", "Intern"));
		empList.add(new Employee(5, "kamal", "Intern"));
		return empList;
	}
}
