package com.enigmacamp.cobaaja;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;


public class RacingCar extends Thread {
    private String model;
    private Double speed;
    private Long start;
    private Long finish;

    public RacingCar(String model, Double speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public void run() {
        try {
            start = System.currentTimeMillis();

            go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish = System.currentTimeMillis();
        Long durasiNano = TimeUnit.MILLISECONDS.toNanos(finish - start);
        LocalTime duration = LocalTime.ofNanoOfDay(durasiNano);
    }

    private void go() throws InterruptedException {
        

        int trackLength = 300;
        int check = 0;
        for (int i = 0; i < trackLength; i += speed) {
            finish = System.currentTimeMillis();
        Long durasiNano = TimeUnit.MILLISECONDS.toNanos(finish - start);
        LocalTime duration = LocalTime.ofNanoOfDay(durasiNano);
            if (check * 100 < i) { //kalo 100m di print
                check++;
                System.out.println("[" + duration + "]" + this.model + check + " ");
            }
            Thread.sleep(1000);
        } 
    } 

}
