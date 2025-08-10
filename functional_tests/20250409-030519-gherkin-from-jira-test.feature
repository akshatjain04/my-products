Feature: Testing Parser API

Scenario: Testing HTTP POST method for copying business logic
Given the API base URL 'http://localhost:3000'
When I send a POST request to '/copy-business-logic' with existing logic in RoostGPT payload
Then the response status should be 200
And the response should contain 'Logic successfully moved and restructured in modular method in new parser'

Scenario: Testing HTTP POST method for gathering information
Given the API base URL 'http://localhost:3000'
When I send a POST request to '/gather-information' with various pieces of information payload
Then the response status should be 200
And the response should contain 'All relevant information gathered in one structure'

Scenario: Testing HTTP PUT method for embedding gathered information
Given the API base URL 'http://localhost:3000'
When I send a PUT request to '/embed-information' with the structure having all gathered information
Then the response status should be 200
And the response should confirm 'The information is successfully embedded into the pre-existing structure'

Scenario: Testing HTTP POST method for checking the grouped structure of parsed data
Given the API base URL 'http://localhost:3000'
When I send a POST request to '/check-grouped-data' with AST parsed data payload
Then the response status should be 200
And the response should contain 'Grouped structure of AST parsed data'

Scenario: Testing HTTP POST method for executing parseGoDirectory function
Given the API base URL 'http://localhost:3000'
When I send a POST request to '/parse-go-directory' with a directory payload
Then the response status should be 200
And the response should contain 'Error and Parses data object'

Scenario: Testing HTTP POST method for generating Go unit tests
Given the API base URL 'http://localhost:3000' and DEVELOPER_MODE is set to true
When I send a POST request to '/generate-go-unittests'
Then the response status should be 200 
And the message 'Go unit tests are generated and passed on AI prompts' should be displayed

Scenario: Testing HTTP GET method for validating parser's code maintainability
Given the API base URL 'http://localhost:3000'
When I send a GET request to '/check-parser-maintainability'
Then the response status should be 200 and the parser's code should be well-structured and easy to navigate

Scenario: Testing HTTP GET method for checking parser's performance
Given the API base URL 'http://localhost:3000' and AST, data to parse
When I send a GET request to '/check-parser-performance'
Then the response status should be 200 
And the 'Time taken for parser operations' should not exceed previous benchmarks by a significant margin

Scenario: Testing HTTP GET method for checking the parser's capabilities in handling large-sized repositories
Given the API base URL 'http://localhost:3000' and a large-sized repository
When I send a GET request to '/test-large-repo'
Then the response status should be 200
And the parser should return the result within expected time without crashing or out-of-memory errors

Scenario: Testing HTTP GET method for checking thread safety for parser
Given the API base URL 'http://localhost:3000' and simultaneous initiation of multiple instances
When I send a GET request to '/test-thread-safety'
Then the response status should be 200
And all instances should run smoothly with no interference.

Scenario: Testing HTTP POST method for checking how analyser handles empty or irrelevant file
Given the API base URL 'http://localhost:3000'
When I send a POST request to '/check-analyser' with a file containing no struct or only non-related statements payload
Then the response status should be 200
