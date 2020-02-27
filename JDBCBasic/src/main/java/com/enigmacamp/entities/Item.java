package com.enigmacamp.entities;

public class Item {
    private Integer id;
    private String name;

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        // return "Item{" + "id=" + id + ", name=" + name + '}';
        return String.format("| ID= %-9d  | ITEM= %-25s | \n", id, name);
    }

}