Feature: Dashboard Refresh

  Background:
    Given The application has started on the login page
    And I verify if logo visible on "LoginPage"
    When With "testUser1" I login
    Then I can see Home Page

  Scenario: User refreshes the dashboard
    Given the user is logged in
    When the user reloads the page
    Then the user should remain logged in
    And the page should reload all the data on page
