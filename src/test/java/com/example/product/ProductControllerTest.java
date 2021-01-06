package com.example.product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    ProductRepository repository;

    Product product43PieceDinnerSet = new Product(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

    @Test
    public void get_product_no_2_should_be_return_43_Piece_dinner_Set () {
        repository.save(product43PieceDinnerSet);

        ProductDetailResponse product = testRestTemplate.getForObject("/api/v1/product/2", ProductDetailResponse.class);

        assertEquals("43 Piece dinner Set", product.getProductName());
    }

    @Test
    public void create_product_no_3_should_be_return_http_status_code_201_CREATED_and_when_get_3_it_should_be_43_Piece_dinner_Set_2 () {

        ResponseEntity<String> result = testRestTemplate.postForEntity("/api/v1/product/3", new ProductRequest(3, "43 Piece dinner Set 2", 18.95, "/43_Piece_dinner_Set_2.png"), String.class);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        ProductDetailResponse product = testRestTemplate.getForObject("/api/v1/product/3", ProductDetailResponse.class);

        assertEquals("43 Piece dinner Set 2", product.getProductName());

    }

    @Test
    public void create_existing_product_id_should_be_return_http_status_code_409_CONFLICT() {
        repository.save(product43PieceDinnerSet);

        ResponseEntity<String> result = testRestTemplate.postForEntity("/api/v1/product/2", new ProductRequest(2, "43 Piece dinner Set", 18.95, "/43_Piece_dinner_Set.png"), String.class);

        assertEquals(HttpStatus.CONFLICT, result.getStatusCode());

    }
}
