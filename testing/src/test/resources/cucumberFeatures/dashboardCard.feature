Feature: dashboardCard

  Background:
    Given The application has started on the login page
    Then Verify if logo visible on "LoginPage"
    When With "testUser1" login

  Scenario: Travels card elements
    Given the user is logged in
    And there are travels previously recorded for their profile
    When they are on the Travels screen (dashboard)
    Then the cards should display the Cover Photo
    And Destination Name
    And the date rage
    And Budget and number of notes
    And Edit and Delete options