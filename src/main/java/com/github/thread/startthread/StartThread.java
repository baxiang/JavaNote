package com.github.thread.startthread;

public class StartThread extends Thread{
    public static void main(String[] args) {
        StartThread thread = new StartThread();
        thread.run();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
