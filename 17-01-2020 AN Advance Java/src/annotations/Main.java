package annotations;

import java.lang.reflect.Method;

public class Main {
	  
	public static void main(String args[])throws Exception{  
	  
	Hello h=new Hello();  
	Method m=h.getClass().getMethod("sayHello");
	  
	MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
	System.out.println("value is: "+manno.myValue());  
	
	HelloDefault h2= new HelloDefault();
	Method m2=h2.getClass().getMethod("sayHello");  
	  
	MyAnnotation manno2=m2.getAnnotation(MyAnnotation.class);  
	System.out.println("value is: "+ manno2.myValue());  
	}
}
