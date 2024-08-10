Feature: User Search

  @search
  Scenario: Successful login with valid credentials and search
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I click the time button
    And I enter search text
    When I click the View Button
    Then I see error message

  @search2
  Scenario: Successful login with valid credentials and search2
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I click the Admin button
    And I enter search text in Admin Page
    When I click the Search Button
    Then I see search results
    #Then I see error message

  @search3
  Scenario: Verify search results count
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I search for "a"
    Then I should see 6 results

  @search4
  Scenario: Verify search results count
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I search for "Performance"
    Then I should see the "Performance"


  @search5
  Scenario: Verify search results count
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I click Directory Button
    And I choose an option from the dropdown menu and click Search Button
    Then I should see results

  @search6
  Scenario: Verify search results count
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I click the Recruitment button
    And I enter keyword "c#" on Recruitment Page
    When I click the Recruitment Search Button
    Then I see the Recruitment search results

  @search7
  Scenario: Verify search results count
    Given I am on the login page
    When I enter valid credentials
    And I submit the login form
    Then I should be redirected to the dashboard page
    #
    When I click the PIM button
    And I enter ID "5489" on PIM Page
    When I click the Employee Search Button
    Then I see the PIM search results