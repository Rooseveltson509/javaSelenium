Feature: Choose a product

  @pass
  Scenario Outline: As a user i want to place an order
    Given I am on the product catalog page
    And I choose a product "<product1>"
    Then I am on the product detail page
    Examples:
      | product1            |
      | PS VITA             |
      | Game Boy Advance SP |