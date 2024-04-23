Feature: User Registration

  Background:
    Given The application has started on the login page

@userRegister
  Scenario: User create a new account
    Given The user doesn't have an account
    When It clicks on Sign Up
    Then Should be redirected to "Register" page
    And Populate all the required fields
    And The user clicks Register button
    Then Should be redirected to "LogIn" page