Feature: Testing various APIs 
Scenario: Testing HTTP GET method
  Given the API base URL 'http://localhost:3000'
  When I send a GET request to '/users'
  Then the response status should be 200
  And the response should contain 'user details'

Scenario: Testing HTTP POST method
  Given the API base URL 'http://localhost:3000'
  When I send a POST request to '/users' with body 
  """
  {
    "name": "Test User",
    "email": "testuser@email.com"
  }
  """
  Then the response status should be 201
  And the response body should contain
  """
  {
    "name": "Test User",
    "email": "testuser@email.com"
  }
  """

Scenario: Testing HTTP PUT method
  Given the API base URL 'http://localhost:3000'
  When I send a PUT request to '/users/1' with body
  """
  {
    "name": "Updated User",
    "email": "updateduser@email.com"
  }
  """
  Then the response status should be 200
  And the response body should contain
  """
  {
    "name": "Updated User",
    "email": "updateduser@email.com"
  }
  """

Scenario: Testing HTTP DELETE method
  Given the API base URL 'http://localhost:3000'
  When I send a DELETE request to '/users/1'
  Then the response status should be 200
  And the response should contain 'user deleted'

Scenario: Testing GET method with nonexistent resource
  Given the API base URL 'http://localhost:3000'
  When I send a GET request to '/users/100'
  Then the response status should be 404
  And the response should contain 'user not found'

Scenario: Testing POST method with missing fields
  Given the API base URL 'http://localhost:3000'
  When I send a POST request to '/users' with body
  """
  {
    "name": ""
  }
  """
  Then the response status should be 400
  And the response should contain 'missing fields'
