package com.enigmacamp.Concurency;

public class MyThread extends Thread {

   private final Counter counter;
   private final int count;

    public MyThread(Counter counter, int count) {
        this.counter = counter;
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 0; i < count; i++) {
            counter.increment();
            System.out.println(getName()+ ": " + counter.getValue());
        }


        // try {
        //     for (int i = 0; i < 100; i++) {
        //         System.out.println(getName() + " : " + i);
        //         Thread.sleep(100);
        //     }
        // } catch (InterruptedException e) {

        // }
    }
}