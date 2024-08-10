Feature: User login

  @login
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page

  @login
  Scenario: Login with invalid credentials
    Given I am on the login page
    When I enter invalid credentials
    And I submit the login form
    Then I see the error message