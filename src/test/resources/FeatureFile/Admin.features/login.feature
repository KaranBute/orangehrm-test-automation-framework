Feature: Login Scenarios OrangeHRM Login
  This feature contains positive, negative and data-driven scenarios for the OrangeHRM demo login page:https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

 #Background: Open the login page
  # Given The browser is launched ,the Url is opened

@smoke @positive
  Scenario: Successful login with valid credentials
    When user enters valid credentials
    Then user should be redirected to the dashboard

@negative
  Scenario: Login failure with invalid credentials
    When user enters invalid credential
    Then check if the error message appears

@data @login
  Scenario Outline: Data-driven login attempts
    When user enters userName "<userName>" and password "<password>"
    Then the login result should be "<result>"

    Examples:
      | userName  | password  | result  |
      | Admin    | admin123  | success |
      | wronguser | wrongpass | failure |
      | Admin     | wrongpass | failure |
      |           |           | failure |
      
      
       @negative @login
  Scenario: Login fails when userName is blank but password is provided
    Given user is on the OrangeHRM login page
    When user enters userName "" and password "admin123"
    And user clicks the login button
    Then userName field validation error "Required" should be displayed

  @negative @login
  Scenario:Login fails when password is blank but username is provided
    Given user is on the OrangeHRM login page
    When user enters userName "Admin" and password ""
    And user clicks the login button
    Then password field validation error "Required" should be displayed

  @boundary @login
  Scenario:UserName with leading spaces fails authentication
    Given user is on the OrangeHRM login page
    When user enters userName " Admin" and password "admin123"
    And user clicks the login button
    Then login error message "Invalid credentials" should be displayed

  @positive @login
  Scenario:- Login page displays correct brand title
    Given user is on the OrangeHRM login page
    Then the login page title should contain "OrangeHRM"

  @security @login
  Scenario: TC_LOGIN_10 - Password input field masks characters
    Given user is on the OrangeHRM login page
    When user enters password "admin123" in the password field
    Then the password field type should be "password"
