Feature: Admin User Management in OrangeHRM
  This feature covers Admin module scenarios for managing system users.

  Background:
    Given user is logged into OrangeHRM as "Admin"
    And user navigates to Admin module

  # TC_ADMIN_01 - Positive: Add a new system user with ESS role
  @positive @admin
  Scenario: TC_ADMIN_01 - Admin creates a new ESS system user successfully
    When user clicks "Add" button on User Management page
    And user selects user role "Admin"
    And user types employee name "manda akhil user" in employee name field
    And user selects status "Enabled"
    And user enters new system username "JhonDoe"
    And user enters password "Password@123" and confirm password "Password@123"
    And user clicks Save on Add User form
    Then success toast message should be displayed
    And user "JhonDoe" should appear in the users list

  # TC_ADMIN_02 - Negative: Password mismatch validation
  @negative @admin
  Scenario: TC_ADMIN_02 - User creation fails when passwords do not match
    When user clicks "Add" button on User Management page
    And user selects user role "Admin"
    And user types employee name "manda akhil user" in employee name field
    And user selects status "Enabled"
    And user enters new system username "JhonDoe"
    And user enters password "Password@123" and confirm password "WrongPass@999"
    And user clicks Save on Add User form
    Then password mismatch error "Passwords do not match" should be displayed

  # TC_ADMIN_03 - Negative: Duplicate username validation
  @negative @admin
  Scenario: TC_ADMIN_03 - User creation fails with an already-existing username
    When user clicks "Add" button on User Management page
    And user selects user role "Admin"
    And user types employee name "manda akhil user" in employee name field
    And user selects status "Enabled"
    And user enters new system username "Admin"
    And user enters password "Password@123" and confirm password "Password@123"
    And user clicks Save on Add User form
    Then username error "Already exists" should be displayed

  # TC_ADMIN_04 - Positive: Search user by username
  @positive @admin
  Scenario: TC_ADMIN_04 - Admin searches for a user by username
    When user enters search username "Admin" in user search form
    And user clicks Search button on user management page
    Then user record with username "Admin" should be visible in results

  # TC_ADMIN_05 - Positive: Navigate to Job Titles page
  @positive @admin
  Scenario: TC_ADMIN_05 - Admin navigates to Job Titles page under Job section
    When user navigates to "Job" section under Admin
    And user clicks on "Job Titles" menu item
    Then the Job Titles page heading should be displayed
    
    @negative @admin
Scenario: TC_ADMIN_06 - Admin cannot create user without username
  When user clicks "Add" button on User Management page
  And user selects user role "Admin"
  And user types employee name "Manda" in employee name field
  And user selects status "Enabled"
  And user enters new system username ""
  And user enters password "Password@123" and confirm password "Password@123"
  And user clicks Save on Add User form
  Then username required error "Required" should be displayed