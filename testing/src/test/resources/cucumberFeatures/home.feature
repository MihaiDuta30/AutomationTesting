Feature: User Login

  Background:
    Given The application has started on the login page
    Then Verify if logo visible on "LoginPage"
    When With "testUser1" login
    Then The user should be directed to the travels screen

    @verifyLogoAndButton
    Scenario Outline: Verify logo and logout button
      Then Verify if logo and logout button are visible on "<page>"
      Examples:
      | page     |
      | HomePage |



