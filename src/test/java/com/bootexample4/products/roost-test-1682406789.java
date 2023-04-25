package com.bootexample4.products.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bootexample4.products.model.Product;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductRepositoryImpl productRepositoryImpl;

    @Test
    public void testFindAll() {
        when(productRepository.findAll()).thenReturn(Stream
                .of(new Product(1L, "Product 1", "Description 1", 100.0), new Product(2L, "Product 2", "Description 2", 200.0))
                .collect(Collectors.toList()));
        assertEquals(2, productRepositoryImpl.findAll().size());
    }

    @Test
    public void testFindById() {
        Long productId = 1L;
        Product product = new Product(1L, "Product 1", "Description 1", 100.0);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        assertEquals(product, productRepositoryImpl.findById(productId).orElse(null));
    }

    @Test
    public void testSave() {
        Product product = new Product(1L, "Product 1", "Description 1", 100.0);
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product, productRepositoryImpl.save(product));
    }

    @Test
    public void testDeleteById() {
        Long productId = 1L;
        productRepository.deleteById(productId);
        assertEquals(Optional.empty(), productRepository.findById(productId));
    }
}
