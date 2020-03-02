package com.enigmacamp.Concurency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) throws Exception {
        int[] values = {111, 222, 333, 555, 666,777};
        
        ExecutorService service = Executors.newFixedThreadPool(6);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Future <Integer> future = service.submit(new MyCallable(values[i]));
            futures.add(future);
        }

        System.out.println("All task submitted.");
        int i = 0;
        for (Future<Integer> future : futures) {
            Integer o = future.get();
            System.out.println(i++ + ": " + o);
        }
        service.shutdown();

        // System.out.println("BEFORE START");
        // thread1.setName("Thread ");
        // MyRunnable runnable = new MyRunnable(101, 200);
        // MyThread thread1 = new MyThread(1, 100);
        /*
         * Counter counter = new Counter(0);
         * 
         * Thread thread1 = new MyThread(counter, 100000); thread1.setName("Thread1");
         * 
         * Thread thread2 = new MyThread(counter, 100000); thread1.setName("Thread2");
         * 
         * 
         * Thread[] threads ={thread1,thread2}; for (Thread thread : threads) {
         * thread.start(); }
         * 
         * for (Thread thread : threads) { thread.join(); //
         * System.out.println(thread.getName()+ " done."); }
         * System.out.println("Counter: " + counter.getValue());
         * 
         */

        // thread1.start();
        // thread2.start();
        // Thread.sleep(1000000);
        // thread1.interrupt();

    }

}