Feature: Login and Authentication

  Background:
    Given The application has started on the login page

@loginScreenElements
  Scenario: Login screen elements
    Then Verify if logo visible on "LoginPage"
    And The login screen should have a screen title
    And The login screen should have a form for entering Email address and Password
    And The login screen should have a Log In button
