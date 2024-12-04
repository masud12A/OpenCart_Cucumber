Feature: Account Registration

  @regression
  Scenario: Successfull Account Registration
    Given the User navigates to Register Account Page
    When the user enters the details into below fields
      | firstName   | Masud    |
      | lastName    | Atif     |
      | password    | test@123 |
      | cnfPassword | test@123 |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully
