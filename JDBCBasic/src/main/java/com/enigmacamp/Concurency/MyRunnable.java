package com.enigmacamp.Concurency;

public class MyRunnable implements Runnable {
    private final int start;
    private final int end;

    public boolean done;

    public MyRunnable (int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
            while (done) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                }
                
            }
        System.out.println("DONE!");
        // try {
        //     for (int i = start; i < 200; i++) {
        //         System.out.println(i);
        //     }
        // } catch (Exception e) {

        // }
    }

    public void markAsDone () {
        synchronized (this){
            this.done = true;
        notify();
    }
        }
}