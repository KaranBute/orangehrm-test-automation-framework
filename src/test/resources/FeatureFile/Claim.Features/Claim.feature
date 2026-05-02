Feature: Claim Module

  Background:
    Given user is logged into OrangeHRM as "Admin"
    And user navigates to Claim module

  @claim @positive
  Scenario: TC_CLAIM_01 - View My Claims
    When user clicks claim menu item "My Claims"
    Then claims list should be displayed

  @claim @positive
  Scenario: TC_CLAIM_02 - Open Submit Claim page
    When user clicks claim menu item "Submit Claim"
    Then submit claim page should be displayed

  @claim @positive
  Scenario: TC_CLAIM_03 - Open Assign Claim page
    When user clicks claim menu item "Assign Claim"
    Then assign claim page should be displayed successfully

  @claim @negative
  Scenario: TC_CLAIM_04 - Create claim without data
    When user clicks claim menu item "Submit Claim"
    And user clicks Create Claim button
    Then claim required error should be displayed

  @claim @positive
  Scenario: TC_CLAIM_05 - Create claim with valid data
    When user clicks claim menu item "Submit Claim"
    And user selects claim event "Travel"
    And user selects claim currency "United States Dollar"
    And user enters claim remarks "Business trip"
    And user clicks Create Claim button
    Then claims list should be displayed
    
    @positive @claim
Scenario: TC_CLAIM_06 - Admin selects event and currency successfully
  When user clicks claim menu item "Submit Claim"
  And user selects claim event "Travel"
  And user selects claim currency "United States Dollar"
  Then submit claim page should be displayed

@positive @claim
Scenario: TC_CLAIM_07 - Admin enters remarks successfully
  When user clicks claim menu item "Submit Claim"
  And user enters claim remarks "Business trip expenses"
  Then submit claim page should be displayed

@positive @claim
Scenario: TC_CLAIM_08 - Admin creates claim with valid data
  When user clicks claim menu item "Submit Claim"
  And user selects claim event "Travel"
  And user selects claim currency "United States Dollar"
  And user enters claim remarks "Client meeting"
  And user clicks Create Claim button
  Then claims list should be displayed
  
  @negative @claim
Scenario: TC_CLAIM_09 - Claim creation fails without event
  When user clicks claim menu item "Submit Claim"
  And user selects claim currency "United States Dollar"
  And user clicks Create Claim button
  Then claim required error should be displayed

@negative @claim
Scenario: TC_CLAIM_10 - Claim creation fails without currency
  When user clicks claim menu item "Submit Claim"
  And user selects claim event "Travel"
  And user clicks Create Claim button
  Then claim required error should be displayed

@negative @claim
Scenario: TC_CLAIM_11 - Claim creation fails without remarks
  When user clicks claim menu item "Submit Claim"
  And user selects claim event "Travel"
  And user selects claim currency "United States Dollar"
  And user clicks Create Claim button
  Then claim required error should be displayed
  
  @positive @claim
Scenario: TC_CLAIM_12 - Admin navigates to Employee Claims
  When user clicks claim menu item "Employee Claims"
  Then claims list should be displayed

@positive @claim
Scenario: TC_CLAIM_13 - Admin navigates between claim tabs
  When user clicks claim menu item "My Claims"
  And user clicks claim menu item "Submit Claim"
  And user clicks claim menu item "Assign Claim"
  Then assign claim page should be displayed successfully