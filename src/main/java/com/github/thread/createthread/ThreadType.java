package com.github.thread.createthread;

public class ThreadType extends Thread {
    @Override
    public void run() {
        System.out.println("用thread类实现线程");
    }

    public static void main(String[] args) {
        ThreadType t = new ThreadType();
        t.start();
    }
}
