package com.github.thread;

public class ThreadVisible {
    public static void main(String[] args) throws InterruptedException {
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(timeConsumingTask);
        thread.start();

        // 指定的时间内任务没有执行结束的话，就将其取消
        Thread.sleep(10000);
        timeConsumingTask.cancel();
    }
}

class TimeConsumingTask implements Runnable {
    private boolean toCancel = false;
    public void run() {
        while (!toCancel) {
            if (doExecute()) {
                break;
            }
        }
        if (toCancel) {
            System.out.println("Task was canceled.");
        } else {
            System.out.println("Task done.");
        }
    }

    private boolean doExecute()  {
        boolean isDone = false;
        System.out.println("executing...");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isDone;
    }

    public void cancel() {
        toCancel = true;
        System.out.println(Thread.currentThread().getName() + " canceled.");
    }
}
