Feature: Integration testing for ProductController API

Scenario: Retrieve all products using GET method
  Given the API base URL 'http://localhost:8080'
  When I send a GET request to '/products'
  Then the response status should be 200
  And the response should be a JSON array
  And the response should contain product entries with keys 'id', 'name', 'description', and 'price'

Scenario: Create a new product using POST method
  Given the API base URL 'http://localhost:8080'
  And the request payload is:
    """
    {
      "name": "Laptop",
      "description": "Gaming Laptop",
      "price": 1299.99
    }
    """
  When I send a POST request to '/products' with the payload
  Then the response status should be 201
  And the response should contain the created product with keys 'id', 'name', 'description', and 'price'
  And the 'name' field should be 'Laptop'
  And the 'description' field should be 'Gaming Laptop'
  And the 'price' field should be 1299.99

Scenario: Retrieve product by ID using GET method
  Given the API base URL 'http://localhost:8080'
  And a product with ID 1 exists
  When I send a GET request to '/products/1'
  Then the response status should be 200
  And the response should contain a product with 'id' as 1
  And the response should have keys 'name', 'description', and 'price'

Scenario: Update an existing product using PUT method
  Given the API base URL 'http://localhost:8080'
  And a product with ID 1 exists
  And the request payload is:
    """
    {
      "name": "Updated Laptop",
      "description": "Updated description",
      "price": 1399.99
    }
    """
  When I send a PUT request to '/products/1' with the payload
  Then the response status should be 200
  And the response should contain the updated product with 'id' as 1
  And the 'name' field should be 'Updated Laptop'
  And the 'description' field should be 'Updated description'
  And the 'price' field should be 1399.99

Scenario: Delete a product by ID using DELETE method
  Given the API base URL 'http://localhost:8080'
  And a product with ID 1 exists
  When I send a DELETE request to '/products/1'
  Then the response status should be 200
  And the product with ID 1 should no longer exist

Scenario: Retrieve a non-existent product by ID using GET method
  Given the API base URL 'http://localhost:8080'
  And there is no product with ID 999
  When I send a GET request to '/products/999'
  Then the response status should be 404
  And the response body should be empty

Scenario: Update a non-existent product using PUT method
  Given the API base URL 'http://localhost:8080'
  And there is no product with ID 999
  And the request payload is:
    """
    {
      "name": "Non-existent Product",
      "description": "Description",
      "price": 999.99
    }
    """
  When I send a PUT request to '/products/999' with the payload
  Then the response status should be 404
  And the response body should be empty

Scenario: Delete a non-existent product using DELETE method
  Given the API base URL 'http://localhost:8080'
  And there is no product with ID 999
  When I send a DELETE request to '/products/999'
  Then the response status should be 404
  And the response body should be empty
