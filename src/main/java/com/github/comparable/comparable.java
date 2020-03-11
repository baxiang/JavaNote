package com.github.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class User implements Comparable<User> {
    private String Name;
    private int age;

    public User(String name, int age) {
        Name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }

    // 根据年龄排序，如果年龄一样　根据姓名排序
    public int compareTo(User o) {
        if (this.age != o.age) {
            return this.age - o.age;// 升序排列
        } else {
            return this.Name.compareTo(o.Name);
        }
    }
}

public class comparable {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("张三", 20));
        list.add(new User("李四", 30));
        list.add(new User("王五", 20));
        list.add(new User("赵六", 18));
        list.add(new User("孙七", 25));
        list.add(new User("周八", 30));
        Collections.sort(list);
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user);
        }
    }
}
