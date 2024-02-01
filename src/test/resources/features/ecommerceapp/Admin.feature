Feature: Admin

  @GetAllUsers
  Scenario: Get all users by admin
    Given Get all users by admin
    When Send request get all users
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Validate json schema "AdminGetAllUsersSchema.json"

  @GetUsers
  Scenario Outline: Get users by admin with id
    Given Get users by admin with parameter "<parameter>"
    When Send request get users
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Response body data username was "<parameter>"
    Examples:
      | parameter   |
      | super admin |

  @GetAllOrders
  Scenario: Get all orders by admin
    Given Get all orders by admin
    When Send request get all orders
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Validate json schema "AdminGetAllOrdersSchema.json"

  @GetOrders
  Scenario Outline: Get orders by admin with id
    Given Get orders by admin with id <id>
    When Send request get orders
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Response body data id orders was <id>
    Examples:
      | id |
      |1   |