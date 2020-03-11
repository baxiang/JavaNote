package com.github.thread.createthread;

public class RunnableAndThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable run");
            }
        }){
            @Override
            public void run() {
                System.out.println("Thread run");
            }
        }.start();
    }
}
