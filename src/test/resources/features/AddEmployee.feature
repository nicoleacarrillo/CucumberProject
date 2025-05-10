Feature: Add Employee to HRMS

  Background:
    Given user is able to access HRMS application
    When user enters valid username and password

  @addEmployee @testCase5
  Scenario: user should be able to add an employee without employee ID
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on add employee option
    When user enters "John" and "Allen" and "Gonzalez"
    Then system should generate unique employee ID
    And user clicks on save button
    Then employee is added successfully

  @addEmployee @testCase6
  Scenario: user should have the option to add employee by providing unique employee ID
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on add employee option
    When user enters "Rebecca" and "Marie" and "Smith"
    Then system should generate unique employee ID
    And user clicks on save button
    Then employee is added successfully

  @addEmployee @testCase7
  Scenario: error message
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on add employee option
    When user attempts to login with empty fields or invalid employee information
    And user clicks on save button
    Then error message will be displayed for invalid credentials
