Feature: Filter products by brand

  Background:
    Given User is on the Home page

  Scenario: Filter products by brand and verify results
    When User searches by keyword "headphones"
    And User applies filter for brand "Samsung"
    Then All search results should contain brand "Samsung"
