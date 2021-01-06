package com.example.product;

public class ProductErrorResponse {
    private Integer productId;
    private String message;

    public ProductErrorResponse() {
    }

    public ProductErrorResponse(Integer productId, String message) {
        this.productId = productId;
        this.message = message;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
