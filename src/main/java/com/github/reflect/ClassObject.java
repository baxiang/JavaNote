package com.github.reflect;

import java.lang.reflect.Field;

class Person{
    public int id;
    private String name;
}

class  Student extends Person{
    String school;
    private  String grade;
    protected String className;
}


public class ClassObject {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        try {
            Field name = studentClass.getDeclaredField("grade");
            System.out.println(name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("getDeclaredField "+e.getMessage());
        }

        try {
            Field name = studentClass.getField("id");
            System.out.println(name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        }

        Field[] filed1 = studentClass.getDeclaredFields();

        for ( Field f : filed1 ) {
            System.out.println("Declared Field :"+f.getName());
        }

        Field[] filed2 = studentClass.getFields();

        for ( Field f : filed2 ) {
            System.out.println("Field :"+f.getName());
        }
    }
}
