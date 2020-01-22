package aspects;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {

	@Before("execution(* service.EmployeeManager.getEmployeeById(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		System.out.println("logBeforeV1 called: " + joinPoint.getSignature().getName() + " " + LocalDateTime.now());
	}
	
	@After("execution(* service.EmployeeManager.getEmployeeById(..))")
	public void logAfterV1(JoinPoint joinPoint) {
		System.out.println("logAfterV1 called: " + joinPoint.getSignature().getName() + " " + LocalDateTime.now());
	}
}