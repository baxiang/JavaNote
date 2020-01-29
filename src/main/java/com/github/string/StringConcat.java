package com.github.string;

public class StringConcat {
    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "hello world";
        String s3 = new String("hello world");
        String s4 = new String("hello world");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3==s4);



//        String s1 = "hello";
//        String s2 = "world";
//        String s3 = "hello"+"world";
//        String s4 = s1 +"world";
//        String s5 = s1+s2;
//        String s6 = (s1+s2).intern();
//        System.out.println(s3==s4);
//        System.out.println(s3==s5);
//        System.out.println(s4==s5);
//        System.out.println(s3==s6);
    }
}
