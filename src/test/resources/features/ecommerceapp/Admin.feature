Feature: Admin

  @ByAdmin
  Scenario: Get all users by admin
    Given Get all users by admin
    When Send request get all users
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Validate json schema "AdminGetAllUsersSchema.json"

  @ByUser
  Scenario: Get all users by user
    Given Get all users by user
    When Send request get all users
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an admin"
    And Validate json schema "ActionForbiddenByUserSchema.json"

  @ByAdmin
  Scenario Outline: Get users by admin with parameter
    Given Get users by admin with parameter "<parameter>"
    When Send request get users
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Response body data username was "<parameter>"
    Examples:
      | parameter |
      | ziko1     |

  @ByUser
  Scenario Outline: Get users by user with parameter
    Given Get users by user with parameter "<parameter>"
    When Send request get users
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an admin"
    And Validate json schema "ActionForbiddenByUserSchema.json"
    Examples:
      | parameter   |
      | super admin |

  @ByAdmin
  Scenario: Get all orders by admin
    Given Get all orders by admin
    When Send request get all orders
    Then Status code should be 200
    And Response body message was "Success searching data."
#    And Validate json schema "AdminGetAllOrdersSchema.json"

  @ByUser
  Scenario: Get all orders by user
    Given Get all orders by user
    When Send request get all orders
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an admin"
    And Validate json schema "ActionForbiddenByUserSchema.json"

  @ByAdmin
  Scenario Outline: Get orders by admin with id
    Given Get orders by admin with id <id>
    When Send request get orders
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Response body data id orders was <id>
    Examples:
      | id |
      | 1  |

  @ByUser
  Scenario Outline: Get orders by user with id
    Given Get orders by user with id <id>
    When Send request get orders
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an admin"
    And Validate json schema "ActionForbiddenByUserSchema.json"
    Examples:
      | id |
      | 1  |