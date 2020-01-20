package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface MyAnnotation {
	int myValue() default 101;  
}

class Hello{  
@MyAnnotation(myValue=10)  
public void sayHello(){System.out.println("hello annotation");}  
}

class HelloDefault{  
@MyAnnotation
public void sayHello(){System.out.println("Default hello annotation");}  
} 

