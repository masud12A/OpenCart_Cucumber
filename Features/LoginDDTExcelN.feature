Feature: Login Data Driven with Excel

  Scenario Outline: Login DataDriven Excel
    Given the User navigates to login Page
    Then the User should redirected to the MyAccount Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
