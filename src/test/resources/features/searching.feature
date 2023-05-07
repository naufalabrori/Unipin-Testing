@All
Feature: Searching

  @Searching
  Scenario: Searching Products
    Given : User in home page
    When : User fill product name in search field
    And : User click search button
    Then : User get product search result

  @InvalidSearching
  Scenario: Searching Missing Products
    Given : User in home page
    When : User fill invalid product name in search field
    And : User click search button
    Then : User get missing product result
