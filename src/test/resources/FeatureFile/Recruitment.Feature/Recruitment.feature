Feature: Recruitment - Job Vacancy and Application Management

  Background:
    Given user is logged into OrangeHRM as "Admin"

  @positive @recruitment
  Scenario: TC_REC_01 - Admin creates a new job vacancy successfully
    When  user navigates to Recruitment module
    And   user clicks Add Vacancy button
    And   user enters vacancy name "QA Automation Engineer"
    And   user selects job title for vacancy "QA Engineer"
    And   user clicks Save Vacancy button
    Then  vacancy save success toast should be displayed

  @negative @recruitment
  Scenario: TC_REC_02 - Vacancy creation fails when vacancy name is blank
    When  user navigates to Recruitment module
    And   user clicks Add Vacancy button
    And   user leaves vacancy name blank
    And   user selects job title for vacancy "QA Engineer"
    And   user clicks Save Vacancy button
    Then  vacancy required field error should be displayed

  @positive @recruitment
  Scenario: TC_REC_03 - Admin adds a new candidate with valid email
    When  user navigates to Recruitment module
    And   user clicks Candidates tab
    And   user clicks Add Candidate button
    And   user enters candidate first name "Jhon" and last name "Doe"
    And   user enters candidate email "jhon@gmail.com"
    And   user clicks Save Candidate button
    Then  candidate save success toast should be displayed

  @negative @recruitment
  Scenario: TC_REC_04 - Candidate creation fails with invalid email format
    When  user navigates to Recruitment module
    And   user clicks Candidates tab
    And   user clicks Add Candidate button
    And   user enters candidate first name "Rahul" and last name "Das"
    And   user enters candidate email "invalid-email"
    And   user clicks Save Candidate button
    Then  candidate email format error should be displayed

  @positive @recruitment
  Scenario: TC_REC_05 - Admin can search candidates
    When  user navigates to Recruitment module
    And   user clicks Candidates tab
    And   user clicks Search Candidates button
    Then  candidates search results should be displayed

    @negative @recruitment
Scenario: TC_REC_06 - Vacancy creation fails without job title
  When user navigates to Recruitment module
  And user clicks on "Add" button in Vacancies section
  And user enters vacancy name "QA Engineer Automation"
  And user clicks Save Vacancy button
  Then field validation error "Required" should appear under job title field
  
  @positive @recruitment
Scenario: TC_REC_06 - Admin opens Candidates tab
  When user navigates to Recruitment module
  And user clicks Candidates tab
  Then candidates list for "All" should be displayed

@positive @recruitment
Scenario: TC_REC_07 - Admin searches candidates without filters
  When user navigates to Recruitment module
  And user clicks Candidates tab
  And user clicks Search button in Recruitment
  Then candidates list for "All" should be displayed

@positive @recruitment
Scenario: TC_REC_08 - Admin filters candidates by vacancy
  When user navigates to Recruitment module
  And user clicks Candidates tab
  And user selects vacancy "Associate IT Manager" in candidate search form
  And user clicks Search button in Recruitment
  Then candidates list for "Associate IT Manager" should be displayed

@positive @recruitment
Scenario: TC_REC_09 - Admin opens Add Candidate form
  When user navigates to Recruitment module
  And user clicks Candidates tab
  And user clicks "Add" in candidates section
  Then Add Candidate page should be displayed

@negative @recruitment
Scenario: TC_REC_10 - Candidate search with invalid keyword shows no records
  When user navigates to Recruitment module
  And user clicks Candidates tab
  And user enters candidate keyword "xyzinvalidcandidate"
  And user clicks Search button in Recruitment
  Then candidates list or no records message should be displayed