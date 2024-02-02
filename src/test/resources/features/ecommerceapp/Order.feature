Feature: Order

  @Order
  Scenario: Post order with valid data
    Given Post order with json "PostOrderValid.json"
    When Send request post order
    Then Status code should be 200
    And Response body message was "success post order."
    And Validate json schema "PostOrderSchema.json"

  @Order
  Scenario: Post order with blank payment method
    Given Post order with json "PostOrderBlankPayment.json"
    When Send request post order
    Then Status code should be 400
    And Response body message was "payment method can't be blank"
    And Validate json schema "PostOrderSchema.json"

  @Order
  Scenario: Post order with blank address
    Given Post order with json "PostOrderBlankAddress.json"
    When Send request post order
    Then Status code should be 400
    And Response body message was "address can't be blank"
    And Validate json schema "PostOrderSchema.json"

  @Order
  Scenario: Get order user
    Given Get order user
    When Send request get order
    Then Status code should be 200
    And Response body message was "Success get order."

  @Order
  Scenario Outline: Cancel order user with valid order id
    Given Order id <id>
    When Send request put update user
    Then Status code should be 200
    And Response body message was "success cancel order"
    And Validate json schema "CancelOrderSchema.json"
    Examples:
      | id |
      | 4  |

  @Order
  Scenario Outline: Cancel order user with invalid order id
    Given Order id <id>
    When Send request put update user
    Then Status code should be 400
    And Response body message was "success cancel order"
    And Validate json schema "CancelOrderSchema.json"
    Examples:
      | id  |
      | 200 |