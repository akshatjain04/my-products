# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /accounts_post for http method type POST 
# RoostTestHash=53e96f9805
# 
# 

# ********RoostGPT********
Feature: Create new Account

  Background:
    * def urlBase = karate.properties['url.base'] || 'http://localhost:4010'
    * url urlBase

  Scenario Outline: Create a new account with valid email
    Given path '/accounts'
    And header commit-hash = '<commit_hash>'
    And request
      """
      { 
        email: '<email>' 
      }
      """
    When method post
    Then status 201
    And match responseHeaders['api-version'] == '1.0.0'
    And match responseHeaders['commit-hash'] == '<commit_hash>'

    Examples:
      | read('accounts_post.csv') |

  Scenario Outline: Create a new account with invalid email
    Given path '/accounts'
    And header commit-hash = '<commit_hash>'
    And request
      """
      { 
        email: '<email>' 
      }
      """
    When method post
    Then status 400
    And match responseHeaders['api-version'] == '1.0.0'
    And match response..error == '#string'
    And match response..description == '#string'

    Examples:
      | email           | commit_hash |
      | 'invalid_email' | '928d28d'   |
      | 'user@com'      | 'b5da1af'   |

  Scenario: Create a new account without commit-hash header
    Given path '/accounts'
    And request
      """
      { 
        email: 'user@example.com' 
      }
      """
    When method post
    Then status 201
    And match responseHeaders['api-version'] == '1.0.0'

  Scenario: Create a new account with invalid commit-hash pattern
    Given path '/accounts'
    And header commit-hash = '12345678'
    And request
      """
      { 
        email: 'user@example.com' 
      }
      """
    When method post
    Then status 400
    And match responseHeaders['api-version'] == '1.0.0'
    And match response..error == '#string'
    And match response..description == '#string'
