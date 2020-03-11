package com.github.thread.createthread;

public class RunnableType implements Runnable {
    @Override
    public void run() {
        Thread thread = new Thread(new RunnableType());
        thread.start();
    }

    public static void main(String[] args) {
        System.out.println("实现Runnable接口创建thread");
    }
}
