package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

public class Employee {
	private int id;
	private String name;
	private String position;
	
	public Employee() {}
	public Employee(int id, String name, String position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", position=" + position + "\n";
	}
}
