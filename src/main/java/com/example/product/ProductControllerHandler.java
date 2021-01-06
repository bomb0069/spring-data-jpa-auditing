package com.example.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductErrorResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        return new ResponseEntity<ProductErrorResponse>(new ProductErrorResponse(exception.getProductId(), exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ProductErrorResponse> handleProductAlreadyExistException(ProductAlreadyExistException exception) {
        return new ResponseEntity<ProductErrorResponse>(new ProductErrorResponse(exception.getProductId(), exception.getMessage()), HttpStatus.CONFLICT);
    }

}
