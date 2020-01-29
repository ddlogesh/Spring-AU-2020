package com.au.spring.tester;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.au.spring.model.Employee;

public interface EmployeeTestService {
	public List<Employee> getAllEmployee();
	public ModelAndView view();
	public ModelAndView create(HttpServletRequest request);
	public ModelAndView delete(HttpServletRequest request);
	public ModelAndView update(HttpServletRequest request);
}
