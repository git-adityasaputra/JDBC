package com.enigmacamp.Concurency;

public class MyThread extends Thread {

    private int start;
    private int end;

    public MyThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(getName() + " : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }
    }
}