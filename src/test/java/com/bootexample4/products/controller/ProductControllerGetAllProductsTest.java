package com.bootexample4.products.controller;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ProductControllerGetAllProductsTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductRepository productRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllProductsReturnsListOfProducts() {
		// Arrange
		List<Product> predefinedList = Arrays.asList(new Product(), new Product());
		when(productRepository.findAll()).thenReturn(predefinedList);

		// Act
		List<Product> resultList = productController.getAllProducts();

		// Assert
		assertEquals(predefinedList, resultList);
	}

	@Test
    public void getAllProductsReturnsEmptyListWhenNoProducts() {
        // Arrange
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Product> resultList = productController.getAllProducts();

        // Assert
        assertEquals(0, resultList.size());
    }

	@Test(expected = DataAccessException.class)
	public void getAllProductsHandlesRepositoryAccessFailure() {
		// Arrange
		doThrow(DataAccessException.class).when(productRepository).findAll();

		// Act
		productController.getAllProducts();
	}

	@Test
	public void getAllProductsReturnsProductsInCorrectOrder() {
		// Arrange
		Product firstProduct = new Product(); // TODO: Set properties
		Product secondProduct = new Product(); // TODO: Set properties
		List<Product> predefinedOrderedList = Arrays.asList(firstProduct, secondProduct);
		when(productRepository.findAll()).thenReturn(predefinedOrderedList);

		// Act
		List<Product> resultList = productController.getAllProducts();

		// Assert
		assertEquals(predefinedOrderedList, resultList);
	}

	@Test
	public void getAllProductsReturnsProductsWithIntactData() {
		// Arrange
		Product product = new Product(); // TODO: Set properties with known values
		List<Product> predefinedListWithProperties = Arrays.asList(product);
		when(productRepository.findAll()).thenReturn(predefinedListWithProperties);

		// Act
		List<Product> resultList = productController.getAllProducts();

		// Assert
		assertEquals(predefinedListWithProperties, resultList);
		assertEquals(product, resultList.get(0)); // Additional check for data integrity
	}

}