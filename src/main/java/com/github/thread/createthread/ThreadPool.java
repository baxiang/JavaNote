package com.github.thread.createthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FooThread implements Runnable{

    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i & 1) != 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class BarThread implements Runnable{

    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new FooThread());
        executorService.execute(new BarThread());
        executorService.shutdown();
    }
}
