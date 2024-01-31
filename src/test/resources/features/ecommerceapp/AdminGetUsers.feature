Feature: Get Users with admin login by id

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