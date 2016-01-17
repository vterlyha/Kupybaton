package com.kupybaton.model;

public class Product {
    /**
     * WHERE ARE ALL OTHER FIELDS????
     * CHECK RELATED TABLE IN DB!!!
     */
	private Integer id;
	private String name;

	// class constructor has to be declared directly after fields and before methods
    public Product(Integer id, String name) {
		this.id = id;
		this.name = name;

	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

    /**
     * WHERE ARE SETTERS?
     * Don't you get the situation when you need to change only name of existing product?
     */
}
