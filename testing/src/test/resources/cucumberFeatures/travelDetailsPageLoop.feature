Feature: Travel Details Page Loop

  Background:
    Given The application has started on the login page
    Then Verify if logo visible on "LoginPage"
    When With "testUser1" login

  Scenario: User views travel details for each card
    Given The user is on the Travels Dashboard
    And there is at least one Travel Card
    And they click on each Cover photo in the Travel Cards