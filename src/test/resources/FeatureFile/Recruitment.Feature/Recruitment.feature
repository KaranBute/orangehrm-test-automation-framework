Feature: Recruitment - Job Vacancy and Application Management

  Background:
    Given user is logged into OrangeHRM as "Admin"

  # TC_REC_01 - Positive: Add a new job vacancy
  Scenario: TC_REC_01 - Admin can add a new job vacancy
    When user navigates to Recruitment module
    And user clicks on "Add" button in Vacancies section
    And user enters vacancy name "QA Engineer"
    And user selects job title "Software Engineer"
    And user enters number of positions "2"
    And user clicks Save button
    Then vacancy "QA Engineer" should appear in the vacancies list

  # TC_REC_02 - Negative: Add vacancy with missing job title
  Scenario: TC_REC_02 - Vacancy creation fails without job title
    When user navigates to Recruitment module
    And user clicks on "Add" button in Vacancies section
    And user enters vacancy name "DevOps Engineer"
    And user leaves job title blank
    And user clicks Save button
    Then field validation error "Required" should appear under job title field

  # TC_REC_03 - Positive: Add a new candidate application
  Scenario: TC_REC_03 - Admin can add candidate for a vacancy
    When user navigates to Recruitment module
    And user opens vacancy "QA Engineer"
    And user clicks "Add" in candidates section
    And user enters candidate first name "Alice" and last name "Walker"
    And user enters candidate email "alice.walker@test.com"
    And user clicks Save button
    Then candidate "Alice Walker" should be added under "QA Engineer" vacancy

  # TC_REC_04 - Negative: Candidate email with invalid format is rejected
  Scenario: TC_REC_04 - System rejects invalid candidate email
    When user navigates to Recruitment module
    And user opens vacancy "QA Engineer"
    And user clicks "Add" in candidates section
    And user enters candidate first name "Bob" and last name "Taylor"
    And user enters candidate email "invalid-email"
    And user clicks Save button
    Then field validation error "Expected format: admin@example.com" should appear

  # TC_REC_05 - Positive: Search candidates by vacancy name
  Scenario: TC_REC_05 - Admin can search candidates by vacancy
    When user navigates to Recruitment module
    And user selects vacancy "QA Engineer" in candidate search form
    And user clicks Search button
    Then candidates list for "QA Engineer" should be displayed

 @positive @recruitment
  Scenario: TC_REC_06 - Admin can edit an existing vacancy
    When user navigates to Recruitment module
    And user searches for vacancy "QA Engineer" in vacancies list
    And user clicks Edit on vacancy "QA Engineer"
    And user updates number of positions to "5"
    And user clicks Save button
    Then success toast message should be displayed
    And vacancy "QA Engineer" should show "5" positions

  # TC_REC_07 - Negative: Add candidate without first name
  @negative @recruitment
  Scenario: TC_REC_07 - Candidate creation fails without first name
    When user navigates to Recruitment module
    And user opens vacancy "QA Engineer"
    And user clicks "Add" in candidates section
    And user leaves candidate first name blank
    And user enters candidate last name "Smith"
    And user enters candidate email "smith@test.com"
    And user clicks Save button
    Then field validation error "Required" should appear under first name

  # TC_REC_08 - Boundary: Vacancy name at exactly 100 character limit
  @boundary @recruitment
  Scenario: TC_REC_08 - Vacancy name with exactly 100 characters is accepted
    When user navigates to Recruitment module
    And user clicks on "Add" button in Vacancies section
    And user enters vacancy name "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    And user selects job title "Software Engineer"
    And user clicks Save button
    Then success toast message should be displayed

  # TC_REC_09 - Positive: Admin can shortlist a candidate
  @positive @recruitment
  Scenario: TC_REC_09 - Admin can shortlist a candidate application
    When user navigates to Recruitment module
    And user searches for candidate "Alice Walker" by vacancy "QA Engineer"
    And user opens candidate profile for "Alice Walker"
    And user clicks "Shortlist" action button
    And user enters shortlisting note "Strong technical profile"
    And user confirms the action
    Then candidate status should change to "Shortlisted"

  # TC_REC_10 - Positive: Admin can reject a candidate application
  @positive @recruitment
  Scenario: TC_REC_10 - Admin can reject a candidate application with a note
    When user navigates to Recruitment module
    And user searches for candidate "Alice Walker" by vacancy "QA Engineer"
    And user opens candidate profile for "Alice Walker"
    And user clicks "Reject" action button
    And user enters rejection note "Does not meet experience requirement"
    And user confirms the action
    Then candidate status should change to "Rejected"