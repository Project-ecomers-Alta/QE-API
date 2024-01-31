Feature: Login User

  @LoginUser
  Scenario: Login user with valid data
    Given Login user with json "LoginUser.json"
    When Send request post login user
    Then Status code should be 200
    And Response body message was "success login."
    And Validate json schema "LoginUserSchema.json"