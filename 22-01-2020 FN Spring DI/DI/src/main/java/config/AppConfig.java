package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import model.Employee;
import model.Point;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("service")
public class AppConfig {
	
	@Autowired
    Environment environment;
	
	@Bean(name="employee")
	public Employee getEmployee() {
		Employee emp = new Employee(1, "logesh", "Manager");
		return emp;
	}
	
	@Bean(name="point")
	public Point getPoint() {
		return new Point(Integer.parseInt(environment.getProperty("x")), Integer.parseInt(environment.getProperty("y")));
	}
}