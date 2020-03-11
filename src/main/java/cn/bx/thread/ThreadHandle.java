package cn.bx.thread;

import java.util.concurrent.TimeUnit;

public class ThreadHandle {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("start");
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        this.interrupt();
                        e.printStackTrace();
                    }
                    if (this.isInterrupted()) {
                        System.out.println("end");
                        break;
                    }
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
