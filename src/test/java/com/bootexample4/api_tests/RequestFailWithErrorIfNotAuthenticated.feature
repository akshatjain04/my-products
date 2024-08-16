# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# ROOST_METHOD_HASH=f93f9c01c9
# ROOST_METHOD_SIG_HASH=66e25557dd
# 
#  ########## Scenario ########## 
# 
# {
#   feature: 'Feature: Credential Wallet API\r\n' +
#     '  As a user of the Credential Wallet API\r\n' +
#     '  I want to get registration details of people allowed to receive credentials \r\n' +
#     '  So that I can manage my account effectively',
#   background: 'Background:\r\n    Given the base URL is "http://localhost:8080"',
#   rule: null,
#   scenario: {
#     title: 'Scenario: Request must fail with error if request not authenticated',
#     steps: 'Given id of recipient as 09237482347 in path parameter\r\n' +
#       'And size=43 and offset=22 in request query\r\n' +
#       'When the client sends a GET request to endpoint "/recipients/persons/{id}/registrations" \r\n' +
#       'When authentication token is not sent in request\r\n' +
#       'Then for unauthenticated request having status code 401, Verify that headers have api-version\r\n' +
#       'And response body must have appropriate error schema',
#     examples: ''
#   }
# }
# 

# ********RoostGPT********
Feature: Credential Wallet API
  As a user of the Credential Wallet API
  I want to get registration details of people allowed to receive credentials 
  So that I can manage my account effectively

  Background:
    * url 'http://localhost:8080'

  Scenario: Request must fail with error if request not authenticated
    Given def id = '09237482347'
    And def size = 43
    And def offset = 22
    When path '/recipients/persons/', id, '/registrations'
    And param size = #(size)
    And param offset = #(offset)
    And method get
    Then status 401
    And match header api-version == '1.0.0'
    And match response contains
      """
      {
        error: '#string',
        description: '#string'
      }
      """
