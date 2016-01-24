package com.kupybaton.model;

public class ProductList {
<<<<<<< HEAD
	
	private Integer id;
	private String name;
	private String dateCr;
	private String dateDel;

    public ProductList(Integer id, String name, String dateCr) {
		this.id = id;
		this.name = name;
		this.dateCr = dateCr;
	}

    public ProductList(Integer id, String name, String dateCr, String dateDel) {
		this.id = id;
		this.name = name;
		this.dateCr = dateCr;
		this.dateDel = dateDel;
	}
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    
=======

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

>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

<<<<<<< HEAD
	public String getDateCr() {
		return dateCr;
	}

	public void setDateCr(String dateCr) {
		this.dateCr = dateCr;
	}

	public String getDateDel() {
		return dateDel;
	}

	public void setDateDel(String dateDel) {
		this.dateDel = dateDel;
=======
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
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
	}
}
