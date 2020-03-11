package cn.bx.thread;

public class ThreadJoin {
    static  int num = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName() + " start ");
                for (int i = 0; i < 10; i++) {
                    num++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName() + ",num = " + num);
                }
                System.out.println(this.getName() + " end ");
            }
        };
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName() + ",num = " + num);
    }
}
