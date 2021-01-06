
package com.example.product;

import javax.annotation.Generated;
public class ProductDetailResponse {

    private Integer id;
    private String lastUpdate;
    private String productBrand;
    private String productImage;
    private String productName;
    private Double productPrice;
    private Integer quantity;

    public ProductDetailResponse() {
    }

    public ProductDetailResponse(Integer id, String productName, Double productPrice, String productImage, Integer quantity, String productBrand, String lastUpdate) {
        this.id = id;
        this.lastUpdate = lastUpdate;
        this.productBrand = productBrand;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
