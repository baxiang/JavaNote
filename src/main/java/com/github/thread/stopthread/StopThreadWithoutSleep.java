package com.github.thread.stopthread;

import java.util.concurrent.TimeUnit;

public class StopThreadWithoutSleep implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (i<=10000){
            if (!Thread.currentThread().isInterrupted()&&i%3==0){
                System.out.println(i+"是3的倍数");
            }
            i++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadWithoutSleep());
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1);
        thread.interrupt();
    }
}
