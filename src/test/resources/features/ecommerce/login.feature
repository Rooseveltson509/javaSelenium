Feature: As a user i want to sign In to the store

  @e-com
  Scenario Outline: As a user i connect to the store
    Given I am on the home page (La boutique française)
    When I log in with my "<email>" and "<password>" on the website
    Then I am logged
    Examples:
      | email           | password    |
      | roose@gmail.com | mirlle509   |
      | roose@gmail.com | mireille555 |
      | roose@gmail.com | mireille    |
