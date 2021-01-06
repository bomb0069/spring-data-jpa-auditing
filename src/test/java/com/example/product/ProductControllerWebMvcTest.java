package com.example.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void get_product_no_1_with_initial_should_be_return_Balance_Training_Bicycle() throws Exception {

        Optional<Product> productOptional = Optional.of(new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png"));

        given(productRepository.findById(1)).willReturn(productOptional);

        String result = this.mvc.perform(get("/api/v1/product/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductDetailResponse product = mapper.readValue(result, ProductDetailResponse.class);

        assertEquals(1, product.getId());
        assertEquals("Balance Training Bicycle", product.getProductName());
    }

    @Test
    public void get_product_no_1_without_initial_should_be_return_status_code_404_with_error_message_Product_Not_Found() throws Exception {

        Optional<Product> productOptional = Optional.empty();

        given(productRepository.findById(1)).willReturn(productOptional);

        String result = this.mvc.perform(get("/api/v1/product/1"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductErrorResponse error = mapper.readValue(result, ProductErrorResponse.class);

        assertEquals(1, error.getProductId());
        assertEquals("Product Not Found", error.getMessage());
    }

    @Test
    public void get_product_no_2_without_initial_should_be_return_status_code_404_with_error_message_Product_Not_Found() throws Exception {

        Optional<Product> productOptional = Optional.empty();

        given(productRepository.findById(1)).willReturn(productOptional);

        String result = this.mvc.perform(get("/api/v1/product/2"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductErrorResponse error = mapper.readValue(result, ProductErrorResponse.class);

        assertEquals(2, error.getProductId());
        assertEquals("Product Not Found", error.getMessage());
    }
}
