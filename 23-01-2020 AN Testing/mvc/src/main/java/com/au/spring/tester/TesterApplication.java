package com.au.spring.tester;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.au.spring.model.Employee;

public class TesterApplication {
	
	private EmployeeTestService employeeTestService;
	
	public List<Employee> getAllEmployee(){
//		List<Employee> list = new ArrayList<Employee>();
//		return list;
		return employeeTestService.getAllEmployee();
	}
	
	public ModelAndView view() {
		return employeeTestService.view();
	}
	
	public ModelAndView create(HttpServletRequest request) {
		return employeeTestService.create(request);
	}
	
	public ModelAndView delete(HttpServletRequest request) {
		return employeeTestService.delete(request);
	}
	
	public ModelAndView update(HttpServletRequest request) {
		return employeeTestService.update(request);
	}
}
