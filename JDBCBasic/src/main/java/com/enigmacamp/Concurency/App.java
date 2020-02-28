package com.enigmacamp.Concurency;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("BEFORE START");
        // thread1.setName("Thread ");
        // MyRunnable runnable = new MyRunnable(101, 200);
        // MyThread thread1 = new MyThread(1, 100);
        Counter counter = new Counter(0);

        Thread thread1 = new MyThread(counter, 100000);
        thread1.setName("Thread1");

        Thread thread2 = new MyThread(counter, 100000);
        thread1.setName("Thread2");


        Thread[] threads ={thread1,thread2};
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
            // System.out.println(thread.getName()+ " done.");
        }
        System.out.println("Counter: " + counter.getValue());
        


        // thread1.start();
        // thread2.start();






        // Thread.sleep(1000000);
        // thread1.interrupt();

    }

}