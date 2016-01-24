package com.kupybaton.model;

public class Category {
<<<<<<< HEAD
	
	private Integer id;
	private String name;

    public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
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
=======

    private Integer id;
    private String name;

    // it's prefer to have default constructor
    public Category() {
    }

    public Category(Integer id, String name) {
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
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1

}
