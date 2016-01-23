package com.kupybaton.model;

public class ProductList {

	private Integer id;
	private String name;
	private String dateCreated;
	private String dateDeleted;

    // it's prefer to have default constructor
    public ProductList() {
    }

    public ProductList(Integer id, String name, String dateCreated) {
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}

    public ProductList(Integer id, String name, String dateCreated, String dateDeleted) {
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
		this.dateDeleted = dateDeleted;
	}

    public void setId(Integer id) {
    	this.id = id;
    }

    public void setName(String name) {
    	this.name=name;
    }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(String dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
}
