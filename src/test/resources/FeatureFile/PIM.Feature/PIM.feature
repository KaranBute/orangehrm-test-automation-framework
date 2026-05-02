Feature: PIM Employee Management

  Background:
    Given user is logged into OrangeHRM as "Admin"

  @positive @pim
  Scenario: TC_PIM_01 - Admin adds a new employee via PIM module
    When  user navigates to PIM module
    And   user clicks Add Employee button
    And   user enters first name "John", last name "AutoTest" and employee id "TC001"
    And   user clicks Save on Add Employee form
    Then  employee save success toast should be displayed

  @negative @pim
  Scenario: TC_PIM_02 - Add employee fails when first name is left blank
    When  user navigates to PIM module
    And   user clicks Add Employee button
    And   user enters first name "", last name "AutoTest" and employee id "TC002"
    And   user clicks Save on Add Employee form
    Then  required field validation error should be shown on employee form

  @negative @pim
  Scenario: TC_PIM_03 - Add employee fails when employee ID already exists
    When  user navigates to PIM module
    And   user clicks Add Employee button
    And   user enters first name "Dup", last name "IdTest" and employee id "0001"
    And   user clicks Save on Add Employee form
    Then  duplicate employee ID error should be shown

  @positive @pim
  Scenario: TC_PIM_04 - Admin can search for an employee by first name
    When  user navigates to PIM module
    And   user searches for employee with name "Linda"
    And   user clicks Search on the employee list
    Then  at least one employee result should be visible in the list

  @positive @pim
  Scenario: TC_PIM_05 - PIM module displays the Employee List page heading
    When  user navigates to PIM module
    Then  the Employee List page heading should be visible

    @negative @pim
Scenario: TC_PIM_06 - Employee creation fails without first name
  When user navigates to PIM module
  And user clicks Add Employee button
  And user enters first name "", last name "Test" and employee id "9999"
  And user clicks Save on Add Employee form
  Then required field validation error should be shown on employee form