package annotation;

public class Main {
    public static void main(String[] args) {
        try {
            //Method
            MethodAnnotation mAnnotation = (Methods.class).getMethod("display").getAnnotation(MethodAnnotation.class);
            System.out.println("method value: " + mAnnotation.type());
            mAnnotation = (MethodsDefault.class).getMethod("display").getAnnotation(MethodAnnotation.class);
            System.out.println("method value: " + mAnnotation.type());

            //Class
            ClassAnnotation cAnnotation = (Methods.class).getAnnotation(ClassAnnotation.class);
            System.out.println("\nclass value: " + cAnnotation.type());
            cAnnotation = (MethodsDefault.class).getAnnotation(ClassAnnotation.class);
            System.out.println("class value: " + cAnnotation.type());

            //Field
            FieldAnnotation fAnnotation = (Methods.class).getField("value").getAnnotation(FieldAnnotation.class);
            System.out.println("\nfield value: " + fAnnotation.type());
            fAnnotation = (MethodsDefault.class).getField("value").getAnnotation(FieldAnnotation.class);
            System.out.println("field value: " + fAnnotation.type());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@ClassAnnotation(type = "darbar")
class Methods {
    @FieldAnnotation(type = "movie")
    public int value;

    @MethodAnnotation(type = "rajini")
    public void display() {
        System.out.println("Display!");
    }
}

@ClassAnnotation
class MethodsDefault {
    @FieldAnnotation
    public int value;

    @MethodAnnotation
    public void display() {
        System.out.println("Display!");
    }
}
