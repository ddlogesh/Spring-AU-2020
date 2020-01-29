package com.au.spring.tester;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.au.spring.model.Employee;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTester {
	
	HttpServletRequest request;
	
	@InjectMocks
	private TesterApplication testerApplication = new TesterApplication();
	
	@Mock
	EmployeeTestService employeeTestService;

	@Test
	public void testDataSource() {
		when(employeeTestService.getAllEmployee()).thenReturn(new ArrayList<Employee>());
		when(employeeTestService.view()).thenReturn(new ModelAndView("index"));
		when(employeeTestService.create(request)).thenReturn(new ModelAndView("create"));
		when(employeeTestService.update(request)).thenReturn(new ModelAndView("update"));
		when(employeeTestService.delete(request)).thenReturn(new ModelAndView("delete"));
		
		Assert.assertTrue(employeeTestService.getAllEmployee().size() > 0);		// fails
		Assert.assertEquals(employeeTestService.view().getViewName(), "index");
		Assert.assertEquals(employeeTestService.create(request).getViewName(), "create");
		Assert.assertEquals(employeeTestService.update(request).getViewName(), "update");
		Assert.assertEquals(employeeTestService.delete(request).getViewName(), "delete");
	}
}
