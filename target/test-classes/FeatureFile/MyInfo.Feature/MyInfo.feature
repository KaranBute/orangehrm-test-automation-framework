Feature: My Info - Personal Information Management

  @positive @myinfo
  Scenario: TC_MYINFO_01 - Admin updates own nationality in Personal Details
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to My Info module
    And   user clicks on Personal Details tab
    And   user selects nationality "Indian"
    And   user clicks Save on Personal Details form
    Then  personal details success toast should be displayed

  @negative @myinfo
  Scenario: TC_MYINFO_02 - Personal Details save fails with future Date of Birth
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to My Info module
    And   user clicks on Personal Details tab
    And   user enters date of birth "2099-01-01"
    And   user clicks Save on Personal Details form
    Then  date of birth validation error should be displayed

  @positive @myinfo
  Scenario: TC_MYINFO_03 - Employee can update contact information
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to My Info module
    And   user clicks on Contact Details tab
    And   user enters street1 "123 Main Street"
    And   user enters city "Mumbai"
    And   user clicks Save on Personal Details form
    Then  personal details success toast should be displayed

  @positive @myinfo
  Scenario: TC_MYINFO_04 - Employee can select and save gender preference
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to My Info module
    And   user clicks on Personal Details tab
    And   user selects gender "Male"
    And   user clicks Save on Personal Details form
    Then  personal details success toast should be displayed

  @negative @myinfo
  Scenario: TC_MYINFO_05 - Contact details rejected when mobile number has letters
    Given user is logged into OrangeHRM as "Admin"
    When  user navigates to My Info module
    And   user clicks on Contact Details tab
    And   user enters mobile number "123561545112"
    And   user clicks Save on Personal Details form
    Then  mobile number validation error should be displayed
