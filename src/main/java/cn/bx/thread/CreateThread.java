package cn.bx.thread;

import java.util.concurrent.TimeUnit;

public class CreateThread {
    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("total time: %d", endTime - startTime));
        }).start();
        long startTime = System.currentTimeMillis();
        sleep(1);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("main total time: %d", endTime - startTime));
    }

    private static void sleep(long ms) {
        try {
            TimeUnit.SECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
