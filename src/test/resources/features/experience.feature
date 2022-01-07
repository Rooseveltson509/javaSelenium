@non-reg
Feature: As a user I want to do a experience for a stay and add it to my wishlist

  @Experience
  Scenario Outline: Experience for a stay
    Given I am on the home page
    When I go to the experience section I choose the start date and the end date with "<endDate>"
    And I filter by number of travelers and by price with "<minPrice>" and "<maxPrice>"
    And I create a favorites list for this I log in
    When I log in with my "<email>" and "<password>"
    ##Then  I create my list of favorites with "<listName>"
    Examples:
      | email                 | password   | endDate | minPrice | maxPrice | listName |
      | roose8888@yopmail.com | airbnb1994 | 13      | 50       | 88       | My List  |

  @Subscription
  Scenario Outline: Register with a new mail address
    Given user is on the popup register page
    When user wants to signup with email "<email>"
    Then  he should be at the account page
    When user fills all the fields register with email "<firtsName>" "<lastName>" "<fdate>" "<password>"
    Then he should be at validate form
    Examples:
      | email                     | firtsName | lastName | fdate    | password  |
      | airbnbemail1@yopmails.com | TestJava  | Selenium | 12121990 | Java8Test |