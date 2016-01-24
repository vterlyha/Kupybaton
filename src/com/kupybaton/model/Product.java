package com.kupybaton.model;

public class Product {
<<<<<<< HEAD
    
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
=======

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
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1

}
