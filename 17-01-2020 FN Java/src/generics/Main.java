package generics;

class Main<T> {
	   //T stands for "Type"
	   private T t;
	 
	   public void set(T t) { this.t = t; }
	    
	   public T get() { return t; }
	   
	   public static void main(String[] args) {
		   Main<String> instance = new Main<String>();
		   instance.set("lokesh"); //Correct usage
		   System.out.println(instance.get());
		  // instance.set(1);   
	}
	}