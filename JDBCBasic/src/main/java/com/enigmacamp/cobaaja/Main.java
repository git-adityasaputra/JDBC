package com.enigmacamp.cobaaja;


public class Main {

    public static void main(String[] args) {
        args = new String[] { "100", "100", "100"};


        RacingCar args1 = new RacingCar(" Thread", Double.parseDouble(args[1]));
        args1.start();
        RacingCar args2 = new RacingCar(" Thread", Double.parseDouble(args[2]));
        args2.start();
    }

}