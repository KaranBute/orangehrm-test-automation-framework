Feature: Leave - Extended Leave Management Scenarios
  Additional leave scenarios not covered in the existing suite.

  # TC_LEAVE_06 - Negative: Apply leave without selecting leave type
  @negative @leave
  Scenario: TC_LEAVE_06 - Leave application fails when leave type is not selected
    Given user is logged into OrangeHRM as "Employee"
    When user navigates to Leave module
    And user clicks "Apply" option
    And user enters from date "2025-10-01" and to date "2025-10-02"
    And user clicks Apply button
    Then field validation error "Required" should appear under leave type

  # TC_LEAVE_07 - Positive: Employee can view their leave balance
  @positive @leave
  Scenario: TC_LEAVE_07 - Employee can view leave balance from My Leave section
    Given user is logged into OrangeHRM as "Employee"
    When user navigates to Leave module
    And user clicks "My Leave" option
    Then leave entitlement list should be visible with leave types

  # TC_LEAVE_08 - Positive: Admin can view the leave calendar
  @positive @leave
  Scenario: TC_LEAVE_08 - Admin can access the leave calendar view
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to Leave module
    And user clicks "Leave Calendar" option
    Then the leave calendar should be displayed for current month

  # TC_LEAVE_09 - Boundary: Apply leave on a weekend date
  @boundary @leave
  Scenario: TC_LEAVE_09 - System shows zero working days when leave is on weekend
    Given user is logged into OrangeHRM as "Employee"
    When user navigates to Leave module
    And user clicks "Apply" option
    And user selects leave type "Annual Leave"
    And user enters from date "2025-08-02" and to date "2025-08-03"
    And user clicks Apply button
    Then leave duration should display "0.00 Day(s)"

  # TC_LEAVE_10 - Positive: Employee cancels a pending leave request
  @positive @leave
  Scenario: TC_LEAVE_10 - Employee can cancel their own pending leave request
    Given user is logged into OrangeHRM as "Employee"
    When user navigates to Leave module
    And user clicks "My Leave" option
    And user opens a leave request with status "Pending Approval"
    And user clicks Cancel button on leave request
    Then leave status should change to "Cancelled"