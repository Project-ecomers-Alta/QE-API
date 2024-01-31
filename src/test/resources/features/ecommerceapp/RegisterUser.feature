Feature: Register User

  @Register
  Scenario: Register user with valid data
    Given Register user with json "RegisterUser.json"
    When Send request post register user
    Then Status code should be 201
    And Validate json schema "RegisterUserSchema.json"