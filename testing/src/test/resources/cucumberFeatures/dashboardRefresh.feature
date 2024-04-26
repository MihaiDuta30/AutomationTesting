Feature: Dashboard Refresh

  Background:
    Given The application has started on the login page
    Then Verify if logo visible on "LoginPage"
    When With "testUser1" login

  Scenario: User refreshes the dashboard
    Given the user is logged in
    When the user reloads the page
    Then the user should remain logged in
    And the page should reload all the data on page