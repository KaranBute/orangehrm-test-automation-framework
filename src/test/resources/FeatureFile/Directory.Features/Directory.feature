Feature: Directory - Employee Directory Search

  Background:
    Given user is logged into OrangeHRM as "Admin"
    And user navigates to Directory module

  @positive @directory
  Scenario: TC_DIR_01 - Search by employee name returns results
    When user enters employee name "Rahul Das" in directory search
    And user clicks Search button in directory
    Then directory results should be displayed

  @positive @directory
  Scenario: TC_DIR_02 - Search without filters shows all employees
    When user clicks Search button in directory
    Then directory results should be displayed

  @negative @directory
  Scenario: TC_DIR_03 - Search with unknown name shows no records
    When user enters employee name "ZZZNOBODYXYZ" in directory search
    And user clicks Search button in directory
    Then directory should show no records found message

  @positive @directory
  Scenario: TC_DIR_04 - Reset button clears search fields
    When user enters employee name "Rahul Das" in directory search
    And user clicks Reset button in directory
    Then directory search fields should be cleared
