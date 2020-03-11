package cn.bx.thread;

public class ThreadWait {
    public static void main(String[] args) {
         final Object object  = new Object();
         Thread waitThread = new Thread(){
             @Override
             public void run() {
                 synchronized (object) {
                     System.out.println(System.currentTimeMillis() +Thread.currentThread().getName()+"start");
                     try {
                         System.out.println(System.currentTimeMillis() + Thread.currentThread().getName()+" wait for object");
                         object.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(System.currentTimeMillis() + Thread.currentThread().getName()+" end!");

                 }
             }
         };

        Thread notifyThread = new Thread(){
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(System.currentTimeMillis() +Thread.currentThread().getName()+"start");
                    object.notify();
                    System.out.println(System.currentTimeMillis() + Thread.currentThread().getName()+" end!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            }
        };
        waitThread.start();
        notifyThread.start();
    }
}
