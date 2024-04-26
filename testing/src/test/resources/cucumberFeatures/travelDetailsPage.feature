Feature: Travel Details Page

  Background:
    Given The application has started on the login page
    Then Verify if logo visible on "LoginPage"
    When With "testUser1" login

  Scenario: User views travel details
    Given The user is on the Travels Dashboard
    And there is at least one Travel Card

    When they click on the Cover photo in the Travel Card
    Then the user should be directed to the Travels screen for the related destination
    And the screen should display the logo on the left side
    And the page should have a Profile dropdown
    And the screen should display the breadcrumbs as Travels/[destination_name]
    And the screen should have the destination name
    And the screen should have the start date and the end date
    And the screen should have the number of notes
    And the screen should display the Cover photo from the Travel Card
    And the screen should have a description
    And the screen should include a + New Note button
    And a message indicating that ‘No notes are available yet’ should be displayed if there are 0 notes.