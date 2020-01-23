package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/apis")
public class EmployeeProfile{
	
	@GET
	@Path("/get/text")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName() {
		return "logesh";
	}
	
	@GET
	@Path("/get/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee() {
		Employee emp = new Employee(1, "logesh", "Intern");
		return emp;
	}
	
	//----------------------------------------------------------

	@POST
	@Path("/post/text/{position}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String setName(String name, @PathParam("position") String position) {
		return name + " " + position + " added";
	}
	
	@POST
	@Path("/post/json/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setEmployee(@PathParam("id") int id, Employee emp) {
		return "record-" + id + " " + emp.getName() + " added";
	}
	
	@POST
	@Path("/post/form")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee setEmployee(@FormParam("id") int id, @FormParam("name") String name, @FormParam("position") String position) {
		return new Employee(id, name, position);
	}
	
	//----------------------------------------------------------
	
	@PUT
	@Path("/put/text")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String putEmployee(String name) {
		List<String> list =new ArrayList<String>(Arrays.asList("logesh","kamal","vijay"));
		
		list.add(name);
		return list.toString();
	}
	
	@PUT
	@Path("/put/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String putEmployee(Employee emp) {
		//Initialisation
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "logesh", "Intern"));
		list.add(new Employee(2, "ravi", "Lead"));
		
		list.add(emp);
		return list.toString();
	}
	
	@PUT
	@Path("/put/form")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String putEmployee(@FormParam("id") int id, @FormParam("name") String name, @FormParam("position") String position) {
		//Initialisation
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "logesh", "Intern"));
		list.add(new Employee(2, "ravi", "Lead"));
		
		list.add(new Employee(id, name, position));
		return list.toString();
	}
	
	//----------------------------------------------------------
	
	@DELETE
	@Path("/delete/text")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(int id) {
		//Initialisation
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "logesh", "Intern"));
		list.add(new Employee(2, "ravi", "Lead"));
		list.add(new Employee(3, "Rajini", "Darbar"));
		
		list.removeIf(item -> item.getId() == id);	
		return list.toString();
	}
	
	@DELETE
	@Path("/delete/form")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployeeForm(@FormParam("id") int id) {
		//Initialisation
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "logesh", "Intern"));
		list.add(new Employee(2, "ravi", "Lead"));
		list.add(new Employee(3, "Rajini", "Darbar"));
		
		list.removeIf(item -> item.getId() == id);	
		return list.toString();
	}
	
	//----------------------------------------------------------
}

/*
 * Sample Input JSON
{
	"id": 10,
	"name": "vijay",
	"position": "CEO"
}
*/	