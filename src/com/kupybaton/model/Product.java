package com.kupybaton.model;

public class Product extends KupyBaton {

    private Unit unit;
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, Unit unit, Category category) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
