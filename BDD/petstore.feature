Feature: Petstore E2E Flow
    As a user of the Petstore API
    I want to manage pets, orders, and user accounts
    So that I can run a successful pet store business

    Background:
        Given the Petstore API is available at "https://petstore.swagger.io/v2"
        And I have valid API credentials
        And I am authenticated with OAuth2 token with "write:pets" and "read:pets" scopes

    Scenario: Complete pet store management flow
        # User Management
        Given I create a new user with the following details:
            | username  | email          | firstName | lastName | password | phone      |
            | testuser1 | test@email.com | Test      | User     | pass123  | 1234567890 |
        When I log in with username "testuser1" and password "pass123"
        Then I should receive a valid authentication token
        And the response should include rate limit headers

        # Pet Management
        Given I have a new pet with the following details:
            | name   | category | status    |
            | Fluffy | Cat      | available |
        When I add the new pet to the store
        Then the pet should be successfully created
        And I can retrieve the pet by its ID

        # Upload Pet Image
        When I upload an image for the pet
        Then the image should be successfully attached to the pet

        # Update Pet
        When I update the pet's status to "pending"
        Then the pet's status should be updated successfully

        # Find Pets
        When I search for pets with status "pending"
        Then the response should include my pet
        When I search for pets by tag "friendly"
        Then the search results should be returned successfully

        # Store Operations
        When I check the store inventory
        Then I should see the current stock levels

        # Order Management
        Given I want to place an order for the pet
        When I create an order with the following details:
            | quantity | shipDate | status |
            | 1        | tomorrow | placed |
        Then the order should be created successfully
        And I can retrieve the order by its ID

        # Order Completion
        When I approve the order
        Then the order status should change to "approved"
        When the order is delivered
        Then the order status should change to "delivered"

        # Cleanup
        When I delete the order
        Then the order should be removed successfully
        When I delete the pet
        Then the pet should be removed successfully
        When I delete the user account
        Then the user should be removed successfully
        When I attempt to log out
        Then I should be successfully logged out

    Scenario: Error handling and validation
        # Invalid pet operations
        When I try to create a pet without required fields
        Then I should receive a 405 status code
        When I try to find a pet with invalid ID
        Then I should receive a 404 status code

        # Invalid order operations
        When I try to fetch an order with ID less than 1
        Then I should receive a 400 status code
        When I try to fetch an order with ID greater than 10
        Then I should receive a 400 status code

        # Invalid user operations
        When I try to create a user without required fields
        Then I should receive an error response
        When I try to log in with invalid credentials
        Then I should receive a 400 status code

    Scenario: Bulk operations
        Given I have multiple users to create
        When I create users with array input
            | username  | email          | firstName | lastName |
            | bulkuser1 | bulk1@test.com | Bulk      | User1    |
            | bulkuser2 | bulk2@test.com | Bulk      | User2    |
        Then all users should be created successfully

        Given I have multiple pets to add
        When I add the following pets:
            | name    | category | status    |
            | Max     | Dog      | available |
            | Charlie | Dog      | available |
        Then all pets should be added successfully