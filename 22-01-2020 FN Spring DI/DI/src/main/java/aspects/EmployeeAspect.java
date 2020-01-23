package aspects;

import java.time.Duration;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	private LocalDateTime before, after;

	@Before("execution(* service.EmployeeService.getAllEmployees())")
	public void logBeforeV1(JoinPoint joinPoint) {
		before = LocalDateTime.now();
		System.out.println("Method call-before at " + before);
	}
	
	@After("execution(* service.EmployeeService.getAllEmployees())")
	public void logAfterV1(JoinPoint joinPoint) {
		after = LocalDateTime.now();
		System.out.println("Method call-after at " + after);
		
		Duration duration = Duration.between(before, after);
		System.out.println("Timetaken: " + duration.getSeconds() + "s & " + duration.getNano() + " ns");
	}
}