# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /accounts_post for http method type POST 
# RoostTestHash=53e96f9805
# 
# 

# ********RoostGPT********
Feature: Create new Account via /accounts endpoint

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:4010')
    * url urlBase

  Scenario Outline: Create a new account with valid email
    Given path '/accounts'
    And header commit-hash = <commitHash>
    And request
      """
      { 
        email: '<email>' 
      }
      """
    When method post
    Then status 201
    And match header api-version == '1.0.0'
    And match header commit-hash == '#? _ != null && _ == <commitHash>'

    Examples:
      | read('accounts_post.csv') |

  Scenario Outline: Create a new account with invalid email pattern
    Given path '/accounts'
    And header commit-hash = <commitHash>
    And request
      """
      { 
        email: '<email>' 
      }
      """
    When method post
    Then status 400
    And match header api-version == '1.0.0'
    And match response.description == 'Descriptive Error Message'
    And match response.error contains 'validation/'

    Examples:
      | commitHash | email         |
      |    928d28d | invalid-email |
      | null       | user@@example |

  Scenario Outline: Attempt to create a new account without email
    Given path '/accounts'
    And header commit-hash = <commitHash>
    And request {}
    When method post
    Then status 400
    And match header api-version == '1.0.0'
    And match response.description == 'Descriptive Error Message'
    And match response.error == 'error/code'

    Examples:
      | commitHash |
      |    928d28d |
      | null       |
