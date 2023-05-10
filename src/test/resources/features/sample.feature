Feature: Product API
  As a user of the product API
  I want to be able to perform CRUD operations on products
  So that I can manage my products effectively

  Background:
    Given the base URL is "http://localhost:8080"

  Scenario: Get all products
    When I send a GET request to "/api/products"
    Then the response status code should be 200
    And the response should contain a list of products

  Scenario: Create a new product
    Given the following product payload:
      | name          | description              | price |
      | Test Product  | This is a test product.  | 10.0  |
    When I send a POST request to "/api/products" with the payload
    Then the response status code should be 201
    And the response should contain the created product

  Scenario: Get a product by ID
    Given an existing product with ID 1
    When I send a GET request to "/api/products/1"
    Then the response status code should be 200
    And the response should contain the product with ID 1

  Scenario: Update an existing product
    Given an existing product with ID 1
    And the following product payload:
      | name            | description                      | price |
      | Updated Product | This is an updated test product. | 15.0  |
    When I send a PUT request to "/api/products/1" with the payload
    Then the response status code should be 200
    And the response should contain the updated product
