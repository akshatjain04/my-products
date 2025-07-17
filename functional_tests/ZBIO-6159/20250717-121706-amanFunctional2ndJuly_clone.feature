Feature: API Testing for Jira PDF Upload and Processing

Background:
  Given the API base URL is stored in an environment variable "API_BASE_URL"
  And the authorization header is set with a valid token
  And the content type is "application/json"

Scenario: Functional Test - PDF Upload
  Given the system supports uploading PDFs with endpoint "/upload-pdf"
  When I send a POST request to the "/upload-pdf" endpoint with a valid Jira ticket PDF file
  Then the response status should be 200
  And the response body should display a confirmation message including the file name and prompt type

Scenario: Functional Test - PDF Parsing
  Given a Jira ticket PDF is already uploaded to the system
  When I send a POST request to the "/parse-pdf" endpoint triggering backend parsing
  Then the response status should be 200
  And the response body should contain valid fields for "title", "description", and "comments"

Scenario: Functional Test - Validation of Unsupported File Types
  Given the system only supports PDF uploads at the "/upload-pdf" endpoint
  When I send a POST request to "/upload-pdf" with a file of type ".docx"
  Then the response status should be 400
  And the response body should display an error message stating "Only PDF files are supported."

Scenario: Functional Test - Storing File Metadata in roost-reg
  Given a valid Jira ticket PDF is uploaded
  When I send a GET request to "/metadata-pdf" to fetch metadata from roost-reg
  Then the response status should be 200
  And the response body should contain valid metadata for "file name", "file path", and "prompt type"

Scenario: Functional Test - Sending Metadata and Content to AI Server
  Given the PDF metadata is stored in roost-reg and the file is uploaded
  When I send a POST request to "/send-to-ai" with file metadata and content
  Then the response status should be 200
  And the AI server receives the file content, file name, and prompt type without errors

Scenario: Non-Functional Test - Performance for PDF Upload
  Given the network conditions are stable
  When I send a POST request to "/upload-pdf" with a valid Jira PDF file under 5MB
  Then the response status should be 200
  And the upload process completes within 3 seconds

Scenario: Non-Functional Test - Scalability for Multiple PDF Uploads
  Given multiple Jira ticket PDFs are ready for upload
  When I send 10 simultaneous POST requests to "/upload-pdf" endpoint
  Then all response statuses should be 200
  And the system handles all uploads without crashes or significant slowdowns

Scenario: Non-Functional Test - Security for File Upload
  Given the system enforces role-based access control
  When an unauthorized user attempts to send a POST request to "/upload-pdf"
  Then the response status should be 403
  And the response body should display an error message: "Unauthorized access."

Scenario: Non-Functional Test - File Size Limit Enforcement
  Given the system enforces a maximum file size limit of 10MB
  When I send a POST request to "/upload-pdf" with a PDF file exceeding 10MB
  Then the response status should be 400
  And the response body should display an error message: "File size exceeds the maximum allowed limit of 10MB."
