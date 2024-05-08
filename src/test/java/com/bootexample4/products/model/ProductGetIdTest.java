package com.bootexample4.products.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductGetIdTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product();
	}

	@Test
	public void getIdShouldReturnNonNullValue() {
		// Arrange
		Long expectedId = 123L;
		product.setId(expectedId);
		// Act
		Long actualId = product.getId();
		// Assert
		assertNotNull("The id should not be null", actualId);
		assertEquals("The returned id should match the set id", expectedId, actualId);
	}

	@Test
	public void getIdShouldReturnNull() {
		// Arrange
		// No id is set for the product
		// Act
		Long actualId = product.getId();
		// Assert
		assertNull("The id should be null", actualId);
	}

	@Test
	public void getIdShouldBeConsistentAcrossInvocations() {
		// Arrange
		Long expectedId = 456L;
		product.setId(expectedId);
		// Act
		Long firstInvocationResult = product.getId();
		Long secondInvocationResult = product.getId();
		// Assert
		assertEquals("The id should be consistent across multiple invocations", firstInvocationResult,
				secondInvocationResult);
	}

	@Test
	public void getIdShouldReflectUpdatedValue() {
		// Arrange
		Long initialId = 789L;
		Long updatedId = 101112L;
		product.setId(initialId);
		product.setId(updatedId);
		// Act
		Long actualId = product.getId();
		// Assert
		assertEquals("The returned id should reflect the updated value", updatedId, actualId);
	}

	// Inner class to simulate existing Product entity
	// TODO: Replace this with the actual Product class from the project
	private static class Product {

		private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	}

}