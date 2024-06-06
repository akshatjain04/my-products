package com.bootexample4.products.controller;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerDeleteProductTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductController productController;

	@Test
	public void deleteExistingProduct() {
		// Arrange
		Long existingProductId = 1L;
		Product existingProduct = new Product();
		when(productRepository.findById(existingProductId)).thenReturn(Optional.of(existingProduct));
		// Act
		ResponseEntity<Object> response = productController.deleteProduct(existingProductId);
		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void deleteNonExistingProduct() {
		// Arrange
		Long nonExistingProductId = 2L;
		when(productRepository.findById(nonExistingProductId)).thenReturn(Optional.empty());
		// Act
		ResponseEntity<Object> response = productController.deleteProduct(nonExistingProductId);
		// Assert
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test(expected = RuntimeException.class)
	public void deleteProductThrowsException() {
		// Arrange
		Long validProductId = 3L;
		Product product = new Product();
		when(productRepository.findById(validProductId)).thenReturn(Optional.of(product));
		doThrow(new RuntimeException("Database error")).when(productRepository).delete(product);
		// Act
		productController.deleteProduct(validProductId);
	}

	@Test
	public void deleteProductWithNullId() {
		// Arrange
		Long invalidProductId = null;
		// Act
		ResponseEntity<Object> response = productController.deleteProduct(invalidProductId);
		// Assert
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void verifyDeleteCalledOnRepository() {
		// Arrange
		Long validProductId = 4L;
		Product product = new Product();
		when(productRepository.findById(validProductId)).thenReturn(Optional.of(product));
		// Act
		productController.deleteProduct(validProductId);
		// Assert
		verify(productRepository, times(1)).delete(product);
	}

	// Commenting out the test case as the business logic doesn't handle deletion by name
	// The error indicates that the method `findByName` is not present in the
	// `ProductRepository`
	// @Test
	// public void deleteProductByName() {
	// // Arrange
	// String productName = "Sample Product";
	// Product product = new Product();
	// when(productRepository.findByName(productName)).thenReturn(Optional.of(product));
	// // Act
	// ResponseEntity<Object> response =
	// productController.deleteProductByName(productName);
	// // Assert
	// assertEquals(HttpStatus.OK, response.getStatusCode());
	// }

}
