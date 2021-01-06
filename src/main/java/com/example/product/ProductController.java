package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
