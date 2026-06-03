
@api
Feature: REST Assured API Validation

	@get
  Scenario: Validate GET Request

    Given user sends GET request
    Then validate GET response status code
    And validate path field
    And validate ip field
    And validate headers

	@post
  Scenario: Validate POST Request

    Given user sends POST request
    Then validate POST response status code
    And validate customer information
    And validate payment information
    And validate product information
