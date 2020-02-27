package com.enigmacamp.entities;

public class Stock {
    private int id;
    private int item_id;
    private int quantity;
    private int unit_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    @Override
    public String toString() {
        return String.format("| ID= %-9d  | ITEM ID= %-25d |  QTY= %-10d | UNIT ID= %-9d | \n", id, item_id,quantity,unit_id);
    }

}