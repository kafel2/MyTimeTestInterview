Feature: Appointment

  @smoke
  Scenario: Left corner location is `123 Somewhere`
    When user go to appointment page via search filter
    Then user sees same location he chosen in first place

  @smoke
  Scenario: Check filters
    When user go to appointment page via search filter
    And user filters by Service - Hair Styling
    And user filters by By Staff Member - Rajat
    Then Rajat is the staff selected in the staff dropdown from top right
    And Consultation has 15 min service duration and price between $12.10-$13.20
    Then user press book button for service Curling Iron
    And variation modal is displayed
    And Curling Iron price in cart modal is the same as in the services list

