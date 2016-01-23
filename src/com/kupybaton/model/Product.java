package com.kupybaton.model;

public class Product {

    private Integer id;
    private String name;
    private Unit unit;
    private Category category;

    // it's prefer to have default constructor
    public Product() {
    }

    public Product(Integer id, String name, Unit unit, Category category) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.category = category;
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
