Feature: Login Admin

  @LoginAdmin
  Scenario: Login admin with valid data
    Given Login admin with json "LoginAdmin.json"
    When Send request post login admin
    Then Status code should be 200
    And Response body message was "success login."
    And Validate json schema "LoginAdminSchema.json"