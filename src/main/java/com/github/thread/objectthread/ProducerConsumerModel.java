package com.github.thread.objectthread;

import java.util.LinkedList;
import java.util.Random;

class EventStorage {
    private Integer maxSize;
    private LinkedList<Integer> storage;
    private Random random;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
        random = new Random();
    }

    public synchronized void put() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer p = Integer.valueOf(random.nextInt(100) + 1);
        storage.add(p);
        System.out.println("生产:" + p + "\t 总共" + storage.size() + "个");
        notify();
    }

    public synchronized void take() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费:" + storage.poll() + "\t 剩下" + storage.size() + "个");
        notify();
    }
}

class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
