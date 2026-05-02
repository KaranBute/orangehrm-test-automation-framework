Feature: Time - Attendance and Timesheet Management

  Background:
    Given user is logged into OrangeHRM as "Admin"
    And user navigates to Time module

  @positive @time
  Scenario: TC_TIME_01 - Admin can record Punch In attendance
    When user clicks "Attendance" sub menu
    And user clicks "My Attendance" option
    And user clicks Punch In/Out button
    Then punch in success message should be displayed

  @positive @time
  Scenario: TC_TIME_02 - Admin can add a new timesheet
    When user clicks "Timesheets" sub menu
    And user clicks "My Timesheets" option
    And user clicks Add Timesheet button
    And user selects current week date
    And user clicks Create Timesheet button
    Then timesheet should be created successfully

  @positive @time
  Scenario: TC_TIME_03 - Admin can view project report
    When user clicks "Reports" sub menu
    And user clicks "Project Reports" option
    And user clicks Time Report button
    Then project report should be displayed

  @negative @time
  Scenario: TC_TIME_04 - Timesheet creation fails without selecting a date
    When user clicks "Timesheets" sub menu
    And user clicks "My Timesheets" option
    And user clicks Add Timesheet button
    And user clicks Create Timesheet button without selecting a date
    Then timesheet date validation error should be displayed

  @positive @time
  Scenario: TC_TIME_05 - Admin can view attendance records
    When user clicks "Attendance" sub menu
    And user clicks "My Attendance" option
    Then attendance records page should be displayed
