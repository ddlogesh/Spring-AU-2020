package com.au.spring.rowMapper;

import org.springframework.jdbc.core.RowMapper;

import com.au.spring.model.Employee;

public class RowMapperLambda {
	public static final RowMapper<Employee> sellerRowMapperLambda = (rs, rownum) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setFname(rs.getString("fname"));
		employee.setLname(rs.getString("lname"));
		employee.setMobile(rs.getString("mobile"));
		return employee;
	};
}
