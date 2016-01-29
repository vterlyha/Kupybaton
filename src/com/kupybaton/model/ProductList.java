package com.kupybaton.model;

import java.sql.Date;

public class ProductList {

	private Integer id;
	private String name;
	private Date dateCreated;
	private Date dateDeleted;

    // it's prefer to have default constructor
    public ProductList() {
    }

    public ProductList(Integer id, String name, Date dateCreated) {
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}

    public ProductList(Integer id, String name, Date dateCreated, Date dateDeleted) {
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
}
