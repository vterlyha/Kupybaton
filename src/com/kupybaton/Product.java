package com.kupybaton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Product {
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Product(Integer id, String name) {
		this.id = id;
		this.name = name;

	}

	// public static void main (String [] args) {
	// List <Integer> n = new ArrayList <Integer>();
	// n.add(new Integer (3));
	// ProductExpert p = new ProductExpert();
	// List <Product> l = p.getProducts(n);
	// System.out.println(l);
	// System.out.println(l.size());
	// }

}
