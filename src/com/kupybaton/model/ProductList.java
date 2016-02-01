package com.kupybaton.model;

import java.sql.Date;

public class ProductList extends KupyBaton {

	private Date dateCreated;
	private Date dateDeleted;

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
