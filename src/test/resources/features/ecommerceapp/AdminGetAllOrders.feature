Feature: Get All Orders with admin login

  @GetAllOrders
  Scenario: Get all orders by admin
    Given Get all orders by admin
    When Send request get all orders
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Validate json schema "AdminGetAllOrdersSchema.json"