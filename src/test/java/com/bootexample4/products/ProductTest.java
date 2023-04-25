package com.bootexample4.products;

import com.bootexample4.products.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testGetAndSetId() {
        Long id = 1L;
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void testGetAndSetName() {
        String name = "Test Product";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    public void testGetAndSetDescription() {
        String description = "This is a test product";
        product.setDescription(description);
        assertEquals(description, product.getDescription());
    }

    @Test
    public void testGetAndSetPrice() {
        double price = 99.99;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }
}