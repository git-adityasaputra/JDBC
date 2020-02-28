package com.enigmacamp.Concurency;

public class Counter {
    private ConcurrentLinkedDeque<Integer> list = new ConcurrentLinkedDeque<>();

    public void increment(){ //cara satu
        list.push(1);
        } // tidak ada yang boleh ganggu thread 1 sampai thread 1 selesai eksekusi ini
    }

    public void decrement() {
        list.pop();
    }

    public int getValue() { //cara 2 nempel di method
        return value;
    }

}