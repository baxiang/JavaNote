package com.github.thread.objectthread;


import java.util.Date;
import java.util.LinkedList;
class EventStorage{
    private Integer maxSize;
    private LinkedList<Date> storage;
    public EventStorage(){
        maxSize=10;
        storage = new LinkedList<>();
    }
    public synchronized void put(){
        while (storage.size()== maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("当前生产了"+storage.size()+"个产品");
        notify();
    }
    public synchronized void take(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了"+storage.poll()+"\t 现在还剩下"+storage.size());
        notify();
    }
}
class Producer implements Runnable{
    private EventStorage storage;
    public Producer(EventStorage storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            storage.put();
        }
    }
}
class Consumer implements Runnable{
    private EventStorage storage;
    public Consumer(EventStorage storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
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
