package com.enigmacamp.entities;

public class Unit {
    private int id;
    private String name;

    public Unit(int int1, String string) {
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("| ID= %-9d  | NAME= %-25s | \n", id, name);
    }
}