Feature: Travel Details Page Refresh

  Background:
    Given The application has started on the login page
    Then Verify if logo visible on "LoginPage"
    When With "testUser1" login

  Scenario: User refreshes the travel details page
    Given The user is on the Travels Dashboard
    And there is at least one Travel Card

    When they click on the Cover photo in the Travel Card
    Then the user should be directed to the Travels screen for the related destination
    And the page should have a Profile dropdown
    And the screen should have the destination name
    When the user reloads the page
    Then the user should remain logged in on the Travel Details page.
    And the page should reload all the data on Travel Details page