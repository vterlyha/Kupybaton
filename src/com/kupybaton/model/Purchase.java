package com.kupybaton.model;

public class Purchase extends BaseModel {

    private ProductList productlist;
    private Product product;
    private Double quantity;
    private Boolean flag;

    public Purchase() {
    }

    public Purchase(Integer id, ProductList productlist, Product product, Double quantity, Boolean flag) {
        this.setId(id);
        this.setProductlist(productlist);
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setFlag(flag);
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

}
