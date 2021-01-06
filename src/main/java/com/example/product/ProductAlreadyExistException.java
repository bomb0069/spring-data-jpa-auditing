package com.example.product;

public class ProductAlreadyExistException extends RuntimeException {
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message = "Can't Create This Product ID. It's Already Exist";

    public ProductAlreadyExistException(Integer productId) {

        this.productId = productId;
    }
}
