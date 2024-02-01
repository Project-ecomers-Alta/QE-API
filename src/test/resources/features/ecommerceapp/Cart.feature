Feature: Cart

  @Cart
  Scenario: Post cart with valid data
    Given Post cart with json "PostCart.json"
    When Send request post cart
    Then Status code should be 200
    And Response body message was "success add to cart"
    And Validate json schema "PostCartSchema.json"

  @Cart
  Scenario: Get all carts
    Given Get all carts
    When Send request get all carts
    Then Status code should be 200
    And Response body message was "success read cart."

  @Cart
  Scenario: Delete cart
    Given Delete all carts with json "DeleteCart.json"
    When Send request delete all carts
    Then Status code should be 200
    And Response body message was "success"
    And Validate json schema "DeleteCartSchema.json"

  @Cart
  Scenario: Get cart that have been deleted
    Given Get all carts
    When Send request get all carts have been deleted
    Then Status code should be 200
    And Response body message was "success read cart."
    And Validate json schema "GetCartNullSchema.json"