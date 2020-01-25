package junit;

import junit.employee.TestEmployeeDetails;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestEmployeeDetails.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
        System.out.println("Result: " + result.wasSuccessful());
        System.out.println("Count: " + result.getRunCount());
    }
}
