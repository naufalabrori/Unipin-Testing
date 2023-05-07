@All
Feature: Login

  @Test1 @Valid
  Scenario: Valid Login
    Given User in home page
    When User click login page
    When User fill email and password
    And User click button login
    Then User verify login result

  @Test2 @Invalid
  Scenario: Invalid Login
    Given User in home page
    When User click login page
    When User fill invalid email and password
    And User click button login
    Then User get invalid login result
