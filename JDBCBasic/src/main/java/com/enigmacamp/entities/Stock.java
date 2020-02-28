package com.enigmacamp.entities;

public class Stock {
    private int id;
    private int quantity;
    private int item_id;
    private String name_item;
    private int unit_id;
    private String name_unit;

    public Stock(Integer id, Integer item_id, Integer quantity, Integer unit_id) {
        this.id = id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.unit_id = unit_id;
    }

    public Stock(Integer id, Integer item_id, Integer quantity, Integer unit_id, String name_item, String name_unit) {
        this.id = id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.unit_id = unit_id;
        this.name_item = name_item;
        this.name_unit = name_unit;
    }

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

    public String getName_item() {
        return name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
    }

    public String getName_unit() {
        return name_unit;
    }

    public void setName_unit(String name_unit) {
        this.name_unit = name_unit;
    }

    @Override
    public String toString() {
    return String.format("| ID= %-9d | ITEM ID= %-25d | QTY= %-10d | UNIT ID=%-9d | NAME ITEM= %-10s  | NAME UNIT=  %-10s | \n", id, item_id,quantity,unit_id, name_item,name_unit);
    }

}