package com.github.thread.objectthread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotify {
    private AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
         WaitNotify instance = new WaitNotify();
        for (int i =0;i<10;i++){
              new Thread(instance::waitThread).start();
          }
        TimeUnit.MILLISECONDS.sleep(100);
        for(int i =0;i<5;i++){
            instance.notifyThread();
        }
    }
    private synchronized void notifyThread(){
        notify();
    }

    private synchronized void waitThread(){
        try{
            log("wait开始");
            wait();
            log("wait结束");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private void log(String s) {
        System.out.println(count.incrementAndGet() + " "
                + new Date().toString().split(" ")[3]
                + "\t" + Thread.currentThread().getName() + " " + s);
    }
}
