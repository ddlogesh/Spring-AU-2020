package com.au.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.spring.dao.EmployeeDao;
import com.au.spring.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public void insert(Employee emp) {
		employeeDao.insert(emp);
	}
	
	public void update(Employee emp) {
		employeeDao.update(emp);
	}
	
	public void delete(Employee emp) {
		employeeDao.delete(emp);
	}
	
	public List<Employee> view() {
		return employeeDao.getAllEmployee();
	}
}
