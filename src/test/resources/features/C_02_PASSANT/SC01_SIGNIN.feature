Feature: As a user i want to connect to the website

  @pass
  Scenario Outline: As a user i connect to the website
    Given I am on the homePage LeBonCoin
    When I connect with my "<email>" and "<password>"
    Then I am connected
    Examples:
      | email          | password |
      | roose@yahoo.fr | mireille |