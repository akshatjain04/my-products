Feature: Product API
  As a user of the product API
  I want to be able to perform CRUD operations on products
  So that I can manage my products effectively

  Background:
    Given the base URL is "http://localhost:8080"

  Scenario: Get all products
    When the client sends a GET request "/api/products" to get the list of all products
    Then the list of products returned should be empty

  Scenario: Create a new product
    Given the client provides the following product data:
      | name        | description              | price |
      | Test Product | This is a test product. | 10.0  |
    When the client sends a POST request to "/api/products"
    Then the saved product should not be null and its properties must correspond to those provided by client

  Scenario: Get a product by ID
    Given there is an existing product with ID 1
    When the client sends a GET request "/api/products/1" to get a product by its id
    Then the response status code should be 200
    And the response should contain the product with ID 1

  Scenario: Update an existing product
    Given there is an existing product with ID 1
    And the client provides the following product data:
      | name           | description                      | price |
      | Updated Product | This is an updated test product. | 15.0  |
    When the client sends a PUT request to "/api/products/1"
    Then the product with ID 1 should be updated with the provided details

  Scenario: Delete an existing product
    Given there is an existing product with ID 1
    When the client sends a DELETE request to "/api/products/1"
    Then the response status code should be 200
    And the product with ID 1 should no longer exist
