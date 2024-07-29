# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /accounts_patch for http method type PATCH 
# RoostTestHash=2758affb7e
# 
# 

# ********RoostGPT********
Feature: RESTful API operation for /accounts endpoint

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * def authToken = karate.properties['AUTH_TOKEN']
    * url urlBase
    * header api-version = '1.0.0'
    * header Authorization = authToken

  Scenario Outline: Login to existing Account with valid email
    Given path '/accounts'
    And request
      """
      { 
        "email": "<email>" 
      }
      """
    When method post
    Then status 200
    And match response contains
      """
      { 
        "api-version": "1.0.0" 
      }
      """

    Examples:
      | read('accounts_patch.csv') |

  Scenario: Attempt login with invalid email format
    Given path '/accounts'
    And request
      """
      { 
        "email": "invalidemail" 
      }
      """
    When method post
    Then status 400
    And match response contains
      """
      { 
        "api-version": "1.0.0" 
      }
      """
    And match response contains
      """
      { 
        "error": "#string", 
        "description": "#string" 
      }
      """

  Scenario: Login without email in the request body
    Given path '/accounts'
    And request {}
    When method post
    Then status 400
    And match response contains
      """
      { 
        "api-version": "1.0.0" 
      }
      """
    And match response contains
      """
      { 
        "error": "#string", 
        "description": "#string" 
      }
      """
