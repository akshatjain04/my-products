package com.bootexample4.products.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
       product1 = new Product(1L, "Product 1", "Description 1", 100.0);
       product2 = new Product(2L, "Product 2", "Description 2", 200.0);
    }

    @Test
    public void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = productController.getAllProducts();

        assertThat(products).isNotEmpty();
        assertThat(products).hasSize(2);
        assertThat(products).contains(product1, product2);
    }

    @Test
    public void testCreateProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product1);

        Product createdProduct = productController.createProduct(product1);

        assertThat(createdProduct).isEqualTo(product1);
    }

    @Test
    public void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        ResponseEntity<Product> response = productController.getProductById(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(product1);
    }

    @Test
    public void testGetProductByIdNotFound() {
        when(productRepository.findById(3L)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.getProductById(2L);

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void testUpdateProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        when(productRepository.save(any(Product.class))).thenReturn(product1);

        product1.setPrice(300.00);
        ResponseEntity<Product> response = productController.updateProduct(1L, product1);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(product1);
    }

    @Test
    public void testUpdateProductNotFound() {
        when(productRepository.findById(3L)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.updateProduct(3L, product1);

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void testDeleteProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        ResponseEntity<Object> response = productController.deleteProduct(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(productRepository, times(1)).delete(product1);
    }

    @Test
    public void testDeleteProductNotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = productController.deleteProduct(3L);

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}
