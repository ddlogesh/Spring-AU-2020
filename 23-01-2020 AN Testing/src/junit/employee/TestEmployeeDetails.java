package junit.employee;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEmployeeDetails {
    @BeforeClass
    public static void before(){
        System.out.println("before");
    }

    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        double yearlySalary = 0;
        yearlySalary = employeeDetails.getSalary() * 12;
        return yearlySalary;
    }

    @Test
    public void testing(){
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAge(24);
        employeeDetails.setSalary(6000.00);
        employeeDetails.setName("Logesh");
        Assert.assertEquals(73000.00, calculateYearlySalary(employeeDetails), 1000);
    }

    @Test(timeout=5000)
    public void infinity() {
        while(true);
    }

    @Test(expected = ArithmeticException.class)
    public void testAdd() {
        int i = 1/0;
    }

    @AfterClass
    public static void after(){
        System.out.println("after");
    }
}