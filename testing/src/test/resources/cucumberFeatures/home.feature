Feature: User Login

  Background:
    Given The application has started on the login page
    And I verify if logo visible on "LoginPage"
    When With "testUser1" I login
    Then I can see Home Page

    @verifyLogoAndButton
    Scenario Outline: Test case for verify logo and logout button
      And I verify if logo and logout button are visible on "<page>"
      Examples:
      | page     |
      | HomePage |



