package com.kupybaton.model;

public class Product {
    
	private Integer id;
	private String name;
	private Unit unit;
	private Category category;

    public Product(Integer id, String name, Unit unit, Category category) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.category = category;
	}

    public void setId(Integer id) {
    	this.id = id;
    }
    
	public Integer getId() {
		return id;
	}
    
    public void setName(String name) {
    	this.name=name;
    }
    
	public String getName() {
		return name;
	}
	    
    public void setUnit(Unit unit) {
    	this.unit=unit;
    }
    
	public Unit getUnit() {
		return unit;
	}
    
    public void setCategory(Category category) {
    	this.category=category;
    }
    
	public Category getCategory() {
		return category;
	}

}
