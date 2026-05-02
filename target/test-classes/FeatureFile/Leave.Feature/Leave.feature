Feature: Leave - Apply and Manage Leave

  @positive @leave
  Scenario: TC_LEAVE_01 - Employee applies for annual leave
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to Leave module
    And  user clicks on Apply leave link
    And  user selects leave type "Annual Leave"
    And  user enters from date "2025-08-01" and to date "2025-08-03"
    And  user enters leave comment "Family vacation"
    And  user clicks Apply button
    Then leave apply success toast should be displayed

  @negative @leave
  Scenario: TC_LEAVE_02 - System rejects leave with invalid date range
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to Leave module
    And  user clicks on Apply leave link
    And  user selects leave type "Annual Leave"
    And  user enters from date "2025-08-10" and to date "2025-08-05"
    And  user clicks Apply button
    Then leave date validation error should be displayed

  @positive @leave
  Scenario: TC_LEAVE_03 - Admin can view leave list
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to Leave module
    And  user clicks on Leave List link
    And  user clicks Search on the leave list form
    Then leave list results should be displayed

  @negative @leave
  Scenario: TC_LEAVE_04 - Leave application fails when leave type is not selected
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to Leave module
    And  user clicks on Apply leave link
    And  user enters from date "2025-10-01" and to date "2025-10-02"
    And  user clicks Apply button
    Then leave type required validation error should be displayed

  @positive @leave
  Scenario: TC_LEAVE_05 - Employee applies for single-day leave
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to Leave module
    And  user clicks on Apply leave link
    And  user selects leave type "Annual Leave"
    And  user enters from date "2025-09-01" and to date "2025-09-01"
    And  user clicks Apply button
    Then leave apply success toast should be displayed
