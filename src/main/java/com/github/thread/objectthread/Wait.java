package com.github.thread.objectthread;

import java.util.concurrent.TimeUnit;

public class Wait {
    public static void main(String[] args)throws InterruptedException {
        final Object object  = new Object();
        Thread waitThread = new Thread(){
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName()+"开始执行");
                    try {
                        System.out.println(Thread.currentThread().getName()+"准备释放锁");
                        object.wait();
                        System.out.println(Thread.currentThread().getName()+"再次获取到锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"结束执行");
                }
            }
        };

        Thread notifyThread = new Thread(){
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName()+"开始执行");
                    object.notify();
                    System.out.println(Thread.currentThread().getName()+"结束执行");
                }
            }
        };
        waitThread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        notifyThread.start();
    }
}
