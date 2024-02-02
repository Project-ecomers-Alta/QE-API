Feature: Cart

  @PostGetCart
  Scenario: Post cart with valid product id
    Given Post cart with json "PostCart.json"
    When Send request post cart
    Then Status code should be 200
    And Response body message was "success add to cart"
    And Validate json schema "PostCartSchema.json"

  @PostGetCart
  Scenario: Post cart with unavailable product id
    Given Post cart with json "PostCartUnavailableProductID.json"
    When Send request post cart
    Then Status code should be 404
    And Response body message was "product is not found"
    And Validate json schema "PostCartSchema.json"

  @PostGetCart
  Scenario: Get all carts
    Given Get all carts
    When Send request get all carts
    Then Status code should be 200
    And Response body message was "success read cart."

  @DeletePostCart
  Scenario: Delete cart with blank cart id
    Given Delete all carts with json "DeleteCartBlankID.json"
    When Send request delete all carts
    Then Status code should be 400
    And Response body message was "cart id can't be blank"
    And Validate json schema "DeleteCartSchema.json"

  @DeletePostCart
  Scenario: Delete cart with invalid cart id
    Given Delete all carts with json "DeleteCartInvalidID.json"
    When Send request delete all carts
    Then Status code should be 400
    And Response body message was "cart id is invalid"
    And Validate json schema "DeleteCartSchema.json"

  @DeletePostCart
  Scenario: Delete cart
    Given Delete all carts with json "DeleteCart.json"
    When Send request delete all carts
    Then Status code should be 200
    And Response body message was "success"
    And Validate json schema "DeleteCartSchema.json"

  @DeletePostCart
  Scenario: Get cart that have been deleted
    Given Get all carts
    When Send request get all carts have been deleted
    Then Status code should be 200
    And Response body message was "success read cart."
    And Validate json schema "GetCartNullSchema.json"

  @DeletePostCart
  Scenario: Post cart with valid data
    Given Post cart with json "PostCart.json"
    When Send request post cart
    Then Status code should be 200
    And Response body message was "success add to cart"
    And Validate json schema "PostCartSchema.json"