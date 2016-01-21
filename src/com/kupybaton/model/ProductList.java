package com.kupybaton.model;

public class ProductList {
	
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
    
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

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
	}
}
