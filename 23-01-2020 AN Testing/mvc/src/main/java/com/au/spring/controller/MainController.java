package com.au.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.au.spring.model.Employee;
import com.au.spring.service.EmployeeService;

@Controller
public class MainController {
	
	@Autowired
	private EmployeeService employeeService;
		
	 @RequestMapping("/home") 
	 public ModelAndView view() {
		 List<Employee> list = employeeService.view();
		 return new ModelAndView("index").addObject("emp", list); 
	 }
	
	@RequestMapping("/create")
	public ModelAndView create(HttpServletRequest request){
		Employee emp = new Employee();
		if(request.getParameter("id") != null) {
			try {
				emp.setId(Integer.parseInt(request.getParameter("id")));
				emp.setFname(request.getParameter("fname"));
				emp.setLname(request.getParameter("lname"));
				emp.setMobile(request.getParameter("mobile"));
				employeeService.insert(emp);
				return new ModelAndView("redirect:home");
			}
			catch (Exception e) {
				return new ModelAndView("error").addObject("error", e.getMessage());
			}	
		}
		return new ModelAndView("create");
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request) {
		Employee emp = new Employee();
		if(request.getParameter("id") != null) {
			try {
				emp.setId(Integer.parseInt(request.getParameter("id")));
				employeeService.delete(emp);
				return new ModelAndView("redirect:home");
			}
			catch (Exception e) {
				return new ModelAndView("error").addObject("error", e.getMessage());
			}
		}
		return new ModelAndView("delete");
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request) {
		Employee emp = new Employee();
		if(request.getParameter("id") != null) {
			try {
				emp.setId(Integer.parseInt(request.getParameter("id")));
				emp.setFname(request.getParameter("fname"));
				employeeService.update(emp);
				return new ModelAndView("redirect:home");
			}
			catch (Exception e) {
				return new ModelAndView("error").addObject("error", e.getMessage());
			}
		}
		return new ModelAndView("update"); 
	}
}