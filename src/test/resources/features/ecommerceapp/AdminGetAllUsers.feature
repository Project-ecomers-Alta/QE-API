Feature: Get All Users with admin login

  @GetAllUsers
  Scenario: Get all users by admin
    Given Get all users by admin
    When Send request get all users
    Then Status code should be 200
    And Response body message was "Success searching data."
    And Validate json schema "AdminGetAllUsersSchema.json"