Feature: Add product to cart functionality

  Background:
    Given User is on the Home page

  Scenario Outline: Add product to cart and verify it is present
    When User performs search for "<productName>"
    And User selects the first product from the search results
    And User adds the product to the cart
    And User opens the cart
    Then The cart should display at least one item
    And The first item in the cart should contain "<productName>"

    Examples:
      | productName |
      | ноутбук     |
      | смартфон    |
      | планшет     |
      | монітор     |
