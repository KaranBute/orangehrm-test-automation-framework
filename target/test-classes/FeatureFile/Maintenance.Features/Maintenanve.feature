Feature: Maintenance  Records Purge and Access Logs

  Background:
    Given user is logged into OrangeHRM as "Admin"

  @positive @maintenance
  Scenario: TC_MAINT_01 - Admin can navigate to Maintenance module
    When user navigates to Maintenance module
    Then Maintenance module landing page should be displayed

  @positive @maintenance
  Scenario: TC_MAINT_02 - Admin can access Employee Records purge page
    When user navigates to Maintenance module
    And user clicks "Employee Records" option in Maintenance
    Then employee purge search results should be displayed

  @positive @maintenance
  Scenario: TC_MAINT_03 - Admin can access Access Logs
    When user navigates to Maintenance module
    And user clicks "Access Logs" option in Maintenance
    Then access logs table should be displayed

  @positive @maintenance
  Scenario: TC_MAINT_04 - Admin can access Candidate Records purge
    When user navigates to Maintenance module
    And user clicks "Candidate Records" option in Maintenance
    Then candidate records purge page should be displayed

  @positive @maintenance
  Scenario: TC_MAINT_05 - Purge search returns results or no records message
    When user navigates to Maintenance module
    And user clicks "Employee Records" option in Maintenance
    And user clicks Search button in purge without any input
    Then purge search should return results or show appropriate message
