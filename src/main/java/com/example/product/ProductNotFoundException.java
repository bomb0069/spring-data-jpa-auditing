package com.example.product;

public class ProductNotFoundException extends RuntimeException {

    private Integer productId;
    String message = "Product Not Found";

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductNotFoundException(Integer id) {
        this.productId = id;
    }
}
