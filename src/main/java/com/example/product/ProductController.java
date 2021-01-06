package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/api/v1/product/{id}")
    public ProductDetailResponse getProductById(@PathVariable Integer id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        ProductDetailResponse productResponse = new ProductDetailResponse();
        productResponse.setId(product.get().getId());
        productResponse.setProductName(product.get().getProductName());
        productResponse.setProductPrice(product.get().getProductPrice());
        productResponse.setProductImage(product.get().getImageUrl());
        productResponse.setQuantity(product.get().getQuantity());
        productResponse.setProductBrand(product.get().getProductBrand());
        productResponse.setLastUpdate(product.get().getModified().toString());
        return productResponse;
    }

    @PostMapping("/api/v1/product/{id}")
    public ResponseEntity<String> createNewProduct(@RequestBody ProductRequest productRequest) {
        productRepository.save(new Product(productRequest.getProductId(), productRequest.getProductName(), productRequest.getProductPrice(), productRequest.getProductImage()));
        return new ResponseEntity<>("Product Create Successful", HttpStatus.CREATED);
    }
}
