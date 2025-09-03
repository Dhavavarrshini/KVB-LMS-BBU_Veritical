Feature: Login functionality
  @ValidCredentials
  Scenario: Login with valid credentials
    Given user navigates to the login page
    When the user enters valid username and password
    Then the user should be logged in successfully

  @InvalidPassword @Negative
  Scenario: Login with valid username and invalid password
    Given user navigates to the login page
    When the user enters valid username and invalid password
    Then the user should be logged out with invalid password

  @InvalidUsername @Negative
  Scenario: Login with invalid username and valid password
    Given user navigates to the login page
    When the user enters invalid username and valid password
    Then the user should be logged out with invalid username

  @InvalidCredentials @Negative
  Scenario: Login with invalid username and invalid password
    Given user navigates to the login page
    When the user enters invalid username and invalid password
    Then the user should be logged out with invalid credentials
