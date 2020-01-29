package com.au.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.au.spring.model.Employee;
import com.au.spring.rowMapper.RowMapperLambda;

@Repository
@PropertySource("classpath:application.properties")
public class EmployeeDao {
	
	@Autowired
    Environment environment;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void getConnection() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("class"));
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("user_name"));
		dataSource.setPassword(environment.getProperty("password"));
	
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Employee> getAllEmployee() {
		getConnection();
		return (List<Employee>) jdbcTemplate.query("select * from employee", RowMapperLambda.sellerRowMapperLambda);
	}
	
	public void insert(Employee emp) {
		getConnection();
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("id", emp.getId())
				.addValue("fname", emp.getFname())
				.addValue("lname", emp.getLname())
				.addValue("mobile", emp.getMobile());
		
		String query = "insert into employee(id, fname, lname, mobile) values(:id, :fname, :lname, :mobile)";
		namedParameterJdbcTemplate.update(query, parameters);
	}
	
	public void update(Employee emp) {
		getConnection();
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("id", emp.getId())
				.addValue("fname", emp.getFname());
		
		String query = "update employee set fname=:fname where id=:id";
		namedParameterJdbcTemplate.update(query, parameters);
	}
	
	public void delete(Employee emp) {
		getConnection();
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("id", emp.getId());
		
		String query = "delete from employee where id=:id";
		namedParameterJdbcTemplate.update(query, parameters);
	}
}
