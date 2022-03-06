Feature: As a user I want push a producte

  @demo
  Scenario Outline: Add page
    Given I am on the add page
    When I go to the register page and I create account with "<title>" and "<price>" and "<description>"
    Then then I added the product
    Examples:
      | title                 | price  | description |
      | productTestAutomation | 202.99 | Lorem ipsum dolor sit amet. Ut internos natus vel consectetur inventore qui vero nobis. Est delectus cumque et accusamus harum sed sapiente quo saepe possimus a doloribus veniam sit voluptatum voluptatum non eligendi incidunt.   |