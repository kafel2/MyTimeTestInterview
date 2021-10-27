Feature: Pick location for further appointment

  @smoke
  Scenario: find required location in a location picker
    When user clicks on a location filter bar
    And user enters required location
    Then user sees required location
