Feature: Travels page

  Background:
    Given The application has started on the login page
    And I verify if logo visible on "LoginPage"
    When With "testUser1" I login
    Then I can see Home Page

  Scenario: User had previously recorded travels on their profile
    Given the user is logged in
    And there are travels previously recorded for their profile
    When they are on the Travels screen (dashboard)
    Then the screen should display the app name and logo on the left side
    And the screen should have a screen title
    And the screen should have a Profile dropdown
    And the screen should have a Travel card for each Travel recorded
    And the Travel cards are ordered based on date & time they were created (show latest first)
    And the screen should have a New Travel button