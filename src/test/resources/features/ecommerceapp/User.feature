Feature: User

  @User
  Scenario: Get user login
    Given Get user login
    When Send request get user login
    Then Status code should be 200
    And Response body message was "read success"
    And Validate json schema "GetUserLoginSchema.json"

    @User
    Scenario: Update user with valid data
      Given Update user with valid data "UpdateUserLoginData.json"
      When Send request update user data
      Then Status code should be 200
      And Response body message was "success update data"
      And Validate json schema "PutUserDataSchema.json"

  @User
  Scenario: Get user shop
    Given Get user shop
    When Send request get user shop
    Then Status code should be 200
    And Response body message was "read success"
    And Validate json schema "GetUserShopSchema.json"

  @User
  Scenario: Update user shop with valid data
    Given Update user shop with valid data "UpdateUserShop.json"
    When Send request update user shop
    Then Status code should be 200
    And Response body message was "read success"
    And Validate json schema "PutUserShopSchema.json"

    @User
    Scenario: Delete user login data
      Given Delete user login data
      When Send request delete user login data
      Then Status code should be 200
      And Response body message was "success delete data"
      And Validate json schema "DeleteUserLoginSchema.json"