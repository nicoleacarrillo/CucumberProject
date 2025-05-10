Feature: Login Validation for HRMS Portal

  Background:
    Given user is able to access HRMS application
    And user clicks on login button

  @loginValidation @testCase1
  Scenario: empty username field
    When user attempts to login with an empty username field
    Then username error message will be displayed

  @loginValidation @testCase2
  Scenario: empty password field
    When user attempts to login with an empty password field
    Then password error message will be displayed

  @loginValidation @testCase3
  Scenario: invalid login credentials
    When user enters incorrect login username or password
    Then invalid error message will be displayed

  @loginValidation @testCase4
  Scenario: error messages
    When user enters incorrect login username or password
    Then error message will be displayed
    And user can attempt to log back in again
    When user clicks on login button
    Then user will see dashboard page











