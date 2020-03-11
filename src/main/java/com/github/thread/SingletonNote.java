package com.github.thread;


class Singleton {
    private static  Singleton instance = null;
    private Singleton(){}
    public  static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonNote {
    public static void main(String[] args) {
        Singleton foo = Singleton.getInstance();
        Singleton bar = Singleton.getInstance();
        System.out.println(foo ==bar);
    }
}

