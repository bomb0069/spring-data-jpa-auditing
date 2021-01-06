package com.example.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/v1/product/{id}")
    public ProductDetailResponse getProductById (@PathVariable Integer id) {
        return new ProductDetailResponse(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png", 10, "CoolKidz", "2021-01-06 13:47:05.886");
    }
}
