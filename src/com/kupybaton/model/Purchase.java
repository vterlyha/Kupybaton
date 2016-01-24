package com.kupybaton.model;

public class Purchase {
<<<<<<< HEAD
	
	private Integer id;
	private ProductList productlist;
	private Product product;
	private Double quantity;
	private Boolean flag;
	
	public Purchase (Integer id, ProductList productlist, Product product, Double quantity, Boolean flag) {
		this.setId(id);
		this.setProductlist(productlist);
		this.setProduct(product);
		this.setQuantity(quantity);
		this.setFlag(flag);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductList getProductlist() {
		return productlist;
	}

	public void setProductlist(ProductList productlist) {
		this.productlist = productlist;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
=======

    private Integer id;
    private ProductList productlist;
    private Product product;
    private Double quantity;
    private Boolean flag;

    // it's prefer to have default constructor
    public Purchase() {
    }

    public Purchase(Integer id, ProductList productlist, Product product, Double quantity, Boolean flag) {
        this.setId(id);
        this.setProductlist(productlist);
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setFlag(flag);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductList getProductlist() {
        return productlist;
    }

    public void setProductlist(ProductList productlist) {
        this.productlist = productlist;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1

}
