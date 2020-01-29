package com.github.thread;

class TicketWindow implements Runnable {
    private int count = 100;
    public void run() {
        while (true) {
                if (count > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售出车票，剩余车票:" + (--count));
                } else {
                    break;
                }
        }
    }
}

public class Ticket {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        Thread one = new Thread(ticketWindow);
        Thread two = new Thread(ticketWindow);
        Thread three = new Thread(ticketWindow);
        one.setName("1号窗口");
        two.setName("2号窗口");
        three.setName("3号窗口");
        one.start();
        two.start();
        three.start();
    }
}
