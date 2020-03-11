package com.github.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

 class Foo implements Callable {

    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i & 1) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadCall {
    public static void main(String[] args) {
        Foo foo = new Foo();
        FutureTask futureTask = new FutureTask(foo);
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("1-100偶数和是：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
