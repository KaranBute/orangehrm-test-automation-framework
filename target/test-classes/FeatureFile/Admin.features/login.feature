Feature: Login Scenarios OrangeHRM Login

  @smoke @positive @login
  Scenario: TC_LOGIN_01 - Admin login with valid credentials redirects to Dashboard
    Given user is on the OrangeHRM login page
    When  user enters userName "Admin" and password "admin123"
    And   user clicks the login button
    Then  user should be redirected to the dashboard

  @negative @login
  Scenario: TC_LOGIN_02 - Login fails when incorrect password is supplied
    Given user is on the OrangeHRM login page
    When  user enters userName "Admin" and password "wrongPassword99"
    And   user clicks the login button
    Then  login error message "Invalid credentials" should be displayed

  @negative @boundary @login
  Scenario: TC_LOGIN_03 - Login fails when username is blank
    Given user is on the OrangeHRM login page
    When  user enters userName "" and password "admin123"
    And   user clicks the login button
    Then  userName field validation error "Required" should be displayed

  @negative @boundary @login
  Scenario: TC_LOGIN_04 - Login fails when password is blank
    Given user is on the OrangeHRM login page
    When  user enters userName "Admin" and password ""
    And   user clicks the login button
    Then  password field validation error "Required" should be displayed

  @security @login
  Scenario: TC_LOGIN_05 - Password field masks typed characters
    Given user is on the OrangeHRM login page
    When  user enters password "admin123" in the password field
    Then  the password field type should be "password"

  @data @login
  Scenario Outline: TC_LOGIN_06 - Data-driven login attempts
    Given user is on the OrangeHRM login page
    When  user enters userName "<userName>" and password "<password>"
    And   user clicks the login button
    Then  the login result should be "<result>"

    Examples:
      | userName  | password  | result  |
      | Admin     | admin123  | success |
      | wronguser | wrongpass | failure |
      | Admin     | wrongpass | failure |

  @boundary @login
  Scenario: TC_LOGIN_07 - Username with leading spaces fails authentication
    Given user is on the OrangeHRM login page
    When  user enters userName " Admin" and password "admin123"
    And   user clicks the login button
    Then  login error message "Invalid credentials" should be displayed

  @positive @login
  Scenario: TC_LOGIN_08 - Login page displays correct brand title
    Given user is on the OrangeHRM login page
    Then  the login page title should contain "OrangeHRM"
