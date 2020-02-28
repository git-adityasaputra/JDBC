package com.enigmacamp.Concurency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private int value;

    public MyCallable(int value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;

        for (int i = 0; i <= value; i++) {
            result += i;
        }
        return result;
    }

}