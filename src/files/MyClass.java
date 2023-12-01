package files;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation (name = "myName", value = "my value")



@MyAnnotation2 (author = "Vasile", majorVersion = 1, minorVersion = 5)
public class MyClass{
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface MyAnnotation {
        String name() default "";
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface MyAnnotation2 {
        String author() default "Unknown";
        int majorVersion() default 1;
        int minorVersion() default 1;
    }
    /** Define the annotation page 35 course 4 (something like copy paste) */
}



