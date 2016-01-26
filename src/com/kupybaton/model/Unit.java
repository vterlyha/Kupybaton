package com.kupybaton.model;

public class Unit {

    private Integer id;
    private String name;

    // it's prefer to have default constructor

    public Unit() {
    }

    public Unit(Integer id, String name) {
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

}
