Feature: Register User

  @Register
  Scenario: Register user with valid data
    Given Register user with json "RegisterUser.json"
    When Send request post register user
    Then Status code should be 201
#    And Response body message was "Registration Successful"
    And Validate json schema "RegisterUserSchema.json"

    @Register
    Scenario: Register user without username
      Given Register user without username "RegisterUserWithoutUsername.json"
      When Send request post register user
      Then Status code should be 400
#      And Response body message was "Please enter your username"
      And Validate json schema "RegisterUserInvalidSchema.json"

  @Register
  Scenario: Register user without email
    Given Register user without email "RegisterUserWithoutEmail.json"
    When Send request post register user
    Then Status code should be 400
#    And Response body message was "Please enter your email"
    And Validate json schema "RegisterUserInvalidSchema.json"

  @Register
  Scenario: Register user without password
    Given Register user without password "RegisterUserWithoutPassword.json"
    When Send request post register user
    Then Status code should be 400
#    And Response body message was "Please enter your password"
    And Validate json schema "RegisterUserInvalidSchema.json"

  @Register
  Scenario: Register user without domicile
    Given Register user without domicile "RegisterUserWithoutDomicile.json"
    When Send request post register user
    Then Status code should be 400
#    And Response body message was "Please enter your domicile"
    And Validate json schema "RegisterUserInvalidSchema.json"

  @Register
  Scenario: Register user invalid email
    Given Register user invalid email "RegisterUserInvalidEmail.json"
    When Send request post register user
    Then Status code should be 400
#    And Response body message was "Email doesn't exist"
    And Validate json schema "RegisterUserInvalidSchema.json"

  @Register
  Scenario: Register user password minimum
    Given Register user password minimum "RegisterUserPasswordMinimum.json"
    When Send request post register user
    Then Status code should be 400
#    And Response body message was "Please fill in a minimum password of 6 characters/numbers/special characters"
    And Validate json schema "RegisterUserInvalidSchema.json"