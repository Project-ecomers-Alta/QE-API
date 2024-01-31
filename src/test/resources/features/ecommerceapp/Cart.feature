Feature: Cart

  @Cart
  Scenario: Post cart with valid data
    Given Post cart with json "PostCart.json"
    When Send request post cart
    Then Status code should be 200
    And Response body message was "success menambahkan cart"
    And Validate json schema "PostCartSchema.json"

  @Cart
  Scenario: Get all carts
    Given Get all carts
    When Send request get all carts
    Then Status code should be 200
    And Response body message was "success read cart."