package com.github.thread.objectthread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyAll {
    private AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll instance = new WaitNotifyAll();
        for(int i =0;i<10;i++){
            new Thread(instance::waitThread).start();
        }
        TimeUnit.MILLISECONDS.sleep(100);
        instance.notifyThread();
    }
    private synchronized void notifyThread(){
        notifyAll();
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
