package com.enigmacamp.Concurency;

public class MyRunnable implements Runnable {
    private final int start;
    private final int end;

    public MyRunnable (int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = 0; i <= end; i++) {
            System.out.println(i);
        }
    }
}