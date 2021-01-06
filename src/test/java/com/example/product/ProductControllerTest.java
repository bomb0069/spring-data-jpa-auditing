package com.example.product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void get_product_no_2_should_be_return_43_Piece_dinner_Set () {
        ProductDetailResponse product = testRestTemplate.getForObject("/api/v1/product/2", ProductDetailResponse.class);

        assertEquals("43 Piece dinner Set", product.getProductName());
    }
}
