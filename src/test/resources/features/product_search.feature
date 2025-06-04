Feature: Product search functionality

  Background:
    Given User is on the Home page

  Scenario Outline: Verify that product with searched name appears in search results and on product page
    When User searches for "<searchTerm>"
    Then The search results should be visible
    And The first search result should contain "<searchTerm>"
    When User clicks on the first filtered product
    Then The product page should display title containing "<searchTerm>"

    Examples:
      | searchTerm  |
      | asus        |
      | acer        |
      | samsung     |
      | xiaomi      |
      | iphone      |
      | hp          |
      | dell        |
