Feature: Calculator

  @Addition
  Scenario: Simple addition
    Given Addition scenario
    When User enters n1 as 4.0 and n2 as 5.0
    Then Addition result should be 9.0
