package com.enigmacamp.Concurency;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("BEFORE START");
        MyThread thread1 = new MyThread(1, 1000);
        thread1.setName("Thread ");
        thread1.start();

        // MyRunnable runnable = new MyRunnable(101, 200);
        // Thread thread2 = new Thread(runnable);
        // thread2.start();


        Thread.sleep(1000000);
        thread1.interrupt();


        System.out.println("AFTER START");
    }

}