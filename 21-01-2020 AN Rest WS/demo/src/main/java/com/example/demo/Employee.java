package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/apis")
public class Employee{
	
	@GET
	@Produces("application/json")
	public String[] getAllUsers() {
		String str[] = {"Ajith", "Rajini"};
		return str;
	}
}