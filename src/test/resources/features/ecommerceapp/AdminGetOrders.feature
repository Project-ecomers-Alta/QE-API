Feature: Get Orders with admin login by id

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