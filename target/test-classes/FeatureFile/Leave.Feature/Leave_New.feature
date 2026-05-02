Feature: Leave - Extended Leave Management Scenarios

  @positive @leave
  Scenario: TC_LEAVE_06 - Admin can access leave calendar
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to Leave module
    And   user clicks on Leave Calendar link
    Then  the leave calendar should be displayed

  @boundary @leave
  Scenario: TC_LEAVE_07 - Leave comment with 251 characters is truncated to 250
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to Leave module
    And   user clicks on Apply leave link
    And   user selects leave type "Annual Leave"
    And   user enters from date "2025-09-03" and to date "2025-09-04"
    And   user enters leave comment with 251 characters
    And   user clicks Apply button
    Then  comment length should not exceed 250 characters in the field
