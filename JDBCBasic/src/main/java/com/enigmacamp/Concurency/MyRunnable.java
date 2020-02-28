package com.enigmacamp.Concurency;

public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            
        } catch (InterruptedException ex) {
            //TODO: handle exception
        }
        System.out.println("Heloo... " + name + "!");
    }

}