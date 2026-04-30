Feature: OrangeHRM Dashboard Functionality

  Background:
    Given user is logged into OrangeHRM

  Scenario: Verify Dashboard page header
    When user navigates to the Dashboard
    Then the page header should display "Dashboard"

  Scenario: Verify Quick Launch widget visibility
    When user navigates to the Dashboard
    Then the "Quick Launch" widget should be visible on the dashboard

  Scenario: Verify side menu search filters modules
    When user types "Admin" into the side menu search bar
    Then only the Admin module should be visible in the menu
    
    
  @positive @dashboard
  Scenario: TC_DASH_04 - Dashboard displays Time at Work widget
    Given user is logged into OrangeHRM as "Admin"
    When user navigates to the Dashboard
    Then the "Time at Work" widget should be visible on the dashboard

  @positive @dashboard
  Scenario: TC_DASH_05 - Clicking Admin menu from dashboard navigates to Admin module
    Given user is logged into OrangeHRM as "Admin"
    When user clicks on "Admin" from the left side navigation menu
    Then the page header should display "Admin"