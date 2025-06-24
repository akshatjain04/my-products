Feature: Product Management Functionality
  As a user of the product management system
  I want to interact with product-related operations
  So that I can manage the product catalog effectively

  Background:
    Given the Product Management API is up and running
    And the product repository is initialized with test data

  Scenario: Successfully retrieve all products when products exist
    When I send a GET request to "/products" endpoint using ProductController
    Then the response status code should be 200
    And the response should contain a list of products
    And the response body should have a non-zero number of products

  Scenario: Retrieve all products when no products exist
    Given the product repository is empty
    When I send a GET request to "/products" endpoint using ProductController
    Then the response status code should be 200
    And the response body should be an empty list

  Scenario: Successfully create a new product
    Given I have a valid product payload:
      | name        | description           | price |
      | Test Laptop | High-performance Dell | 999.99|
    When I send a POST request to "/products" endpoint using ProductController with the product payload
    Then the response status code should be 200
    And the response body should contain the created product details
    And the product should be saved in the database

  Scenario: Validate product list attributes
    When I send a GET request to "/products" endpoint using ProductController
    Then the response status code should be 200
    And each product in the response should have the following attributes:
      | attribute    | type    |
      | id           | Long    |
      | name         | String  |
      | description  | String  |
      | price        | Double  |

  Scenario: Retrieve product by valid ID
    Given a product exists in the database with ID 1
    When I send a GET request to "/products/1" endpoint using ProductController
    Then the response status code should be 200
    And the response body should contain the product details for ID 1
    And the response should match the product with ID 1 in the database

  Scenario: Attempt to retrieve non-existent product
    Given no product exists with ID 999
    When I send a GET request to "/products/999" endpoint using ProductController
    Then the response status code should be 404
    And the response body should be empty

  Scenario: Update an existing product successfully
    Given a product exists in the database with ID 1
    And I have an updated product payload:
      | name            | description               | price |
      | Updated Laptop  | Improved performance      | 1099.99 |
    When I send a PUT request to "/products/1" endpoint using ProductController with the updated product payload
    Then the response status code should be 200
    And the response body should reflect the updated product details
    And the product in the database should be updated with the new information

  Scenario: Attempt to update a non-existent product
    Given no product exists with ID 999
    And I have an updated product payload:
      | name            | description               | price |
      | Updated Laptop  | Improved performance      | 1099.99 |
    When I send a PUT request to "/products/999" endpoint using ProductController with the updated product payload
    Then the response status code should be 404
    And the response body should be empty

  Scenario: Delete an existing product
    Given a product exists in the database with ID 1
    When I send a DELETE request to "/products/1" endpoint using ProductController
    Then the response status code should be 200
    And the product with ID 1 should be removed from the database

  Scenario: Attempt to delete a non-existent product
    Given no product exists with ID 999
    When I send a DELETE request to "/products/999" endpoint using ProductController
    Then the response status code should be 404
    And the response body should be empty

  Scenario: Check API response content type
    When I send a GET request to "/products" endpoint using ProductController
    Then the response content type should be "application/json"

  Scenario: Ensure maximum performance for product retrieval
    Given the product repository contains a large number of products
    When I send a GET request to "/products" endpoint using ProductController
    Then the response should be returned within 2 seconds
