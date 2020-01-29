package com.github.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Description {
    String foo();
}

@Description(foo = "hello class ")
class UseAnnotation {
    @Description(foo = "hello method ")
    public void hello() {
        System.out.println("hello world");
    }

}

public class ParseAnnotation {
    public static void main(String[] args) {
        Class<UseAnnotation> useAnnotationClass = UseAnnotation.class;
        boolean annotationPresent = useAnnotationClass.isAnnotationPresent(Description.class);
        if (annotationPresent) {
            Description annotation = useAnnotationClass.getAnnotation(Description.class);
            System.out.println(annotation.foo());
        }

        Method[] methods = useAnnotationClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Description.class)) {
                Description annotation = method.getAnnotation(Description.class);
                System.out.println(annotation.foo());
            }
        }
    }
}

