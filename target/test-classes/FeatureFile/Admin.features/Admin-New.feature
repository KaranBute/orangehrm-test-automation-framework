Feature: Admin  User Management in OrangeHRM
  This feature covers Admin module scenarios for managing system users.

  Background:
    Given user is logged into OrangeHRM as "Admin"
    And user navigates to Admin module

  # TC_ADMIN_01 - Positive: Add a new system user with ESS role
  @positive @admin
  Scenario: TC_ADMIN_01 - Admin can create a new system user with ESS role
    When user clicks "Add" button on User Management page
    And user selects user role "ESS"
    And user types employee name "Linda Anderson" in employee name field
    And user selects status "Enabled"
    And user enters new system username "ess_linda_2025"
    And user enters password "Password@123" and confirm password "Password@123"
    And user clicks Save on Add User form
    Then success toast message should be displayed
    And user "ess_linda_2025" should appear in the users list

  # TC_ADMIN_02 - Negative: Add user with mismatched passwords
  @negative @admin
  Scenario: TC_ADMIN_02 - User creation fails when passwords do not match
    When user clicks "Add" button on User Management page
    And user selects user role "ESS"
    And user types employee name "Linda Anderson" in employee name field
    And user selects status "Enabled"
    And user enters new system username "ess_user_mismatch"
    And user enters password "Password@123" and confirm password "WrongPass@999"
    And user clicks Save on Add User form
    Then password mismatch error "Passwords do not match" should be displayed

  # TC_ADMIN_03 - Negative: Add user with username already existing
  @negative @admin
  Scenario: TC_ADMIN_03 - User creation fails with duplicate username
    When user clicks "Add" button on User Management page
    And user selects user role "Admin"
    And user types employee name "Linda Anderson" in employee name field
    And user selects status "Enabled"
    And user enters new system username "Admin"
    And user enters password "Password@123" and confirm password "Password@123"
    And user clicks Save on Add User form
    Then username error "Already exists" should be displayed

  # TC_ADMIN_04 - Positive: Search system user by username
  @positive @admin
  Scenario: TC_ADMIN_04 - Admin can search user by username
    When user enters search username "Admin" in user search form
    And user clicks Search button on user management page
    Then user record with username "Admin" should be visible in results

  # TC_ADMIN_05 - Positive: Verify Job Titles list is accessible under Admin
  @positive @admin
  Scenario: TC_ADMIN_05 - Admin can navigate to Job Titles configuration page
    When user navigates to "Job" section under Admin
    And user clicks on "Job Titles" menu item
    Then the Job Titles page heading should be displayed