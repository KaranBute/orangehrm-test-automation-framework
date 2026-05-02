Feature: OrangeHRM Dashboard Functionality

  Background:
    Given user is logged into OrangeHRM as "Admin"

  @positive @dashboard @smoke
  Scenario: TC_DASH_01 - Dashboard shows header after login
    When user navigates to the Dashboard
    Then the page header should display "Dashboard"

  @positive @dashboard
  Scenario: TC_DASH_02 - Quick Launch widget is visible on Dashboard
    When user navigates to the Dashboard
    Then the "Quick Launch" widget should be visible on the dashboard

  @positive @dashboard
  Scenario: TC_DASH_03 - Side menu search filters modules
    When user types "Admin" into the side menu search bar
    Then only the Admin module should be visible in the menu

  @positive @dashboard
  Scenario: TC_DASH_04 - Dashboard displays Time at Work widget
    When user navigates to the Dashboard
    Then the "Time at Work" widget should be visible on the dashboard

  @positive @dashboard
  Scenario: TC_DASH_05 - Clicking Admin menu from dashboard navigates to Admin module
    When user clicks on "Admin" from the left side navigation menu
    Then the page header should display "Admin"
