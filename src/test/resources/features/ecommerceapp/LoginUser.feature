Feature: Login User

  @LoginUser
  Scenario: Login user with valid data
    Given Login user with json "LoginUser.json"
    When Send request post login user
    Then Status code should be 200
    And Response body message was "success login."
    And Validate json schema "LoginUserSchema.json"

  @LoginUser
  Scenario: Login user without email
    Given Login user without email "LoginUserWithoutEmail.json"
    When Send request post login user
    Then Status code should be 401
#    And Response body message was "Email cannot be empty"
    And Validate json schema "LoginUserInvalidSchema.json"

  @LoginUser
  Scenario: Login user without password
    Given Login user without password "LoginUserWithoutPassword.json"
    When Send request post login user
    Then Status code should be 401
#    And Response body message was "Password cannot be empty"
    And Validate json schema "LoginUserInvalidSchema.json"

  @LoginUser
  Scenario: Login user invalid email
    Given Login user invalid email "LoginUserInvalidEmail.json"
    When Send request post login user
    Then Status code should be 401
#    And Response body message was "Your email is not correct"
    And Validate json schema "LoginUserInvalidSchema.json"

  @UpdateUser
  Scenario: Update password with valid data
    Given Update password with valid data "UpdatePasswordLogin.json"
    When Send request update password
    Then Status code should be 200
#    And Response body message was "success update password"
    And Validate json schema "UpdatePasswordLoginSchema.json"

  @UpdateUser
  Scenario: Update password without input data
    Given Update password without input data "UpdatePasswordWithoutInput.json"
    When Send request update password
    Then Status code should be 400
#    And Response body message was "success update password"
    And Validate json schema "UpdatePasswordLoginSchema.json"

  @UpdateUser
  Scenario: Update password minimum
    Given Update password minimum "UpdatePasswordLoginMinimum.json"
    When Send request update password
    Then Status code should be 400
#    And Response body message was "Please fill in a minimum password of 6 characters/numbers/special characters"
    And Validate json schema "UpdatePasswordLoginSchema.json"