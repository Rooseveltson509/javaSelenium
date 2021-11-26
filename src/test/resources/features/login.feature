@non-reg
Feature: As a Zenity collaborator I want to login so that I could access the intranet

  @Login
  Scenario Outline: Login with valid user credentials
    Given user is on the login page
    When  user is logging-in with "<username>" "<password>"
      #Then  he should be at the home page
    Examples:
      | username | password |
      | tester1  | tester1 |

@Login
  Scenario Outline: Login with wrong password
    Given user is on the login page
    When  user is logging-in with "<username>" "<password>"
    Then  he should not be able to go to the home page
    Examples:
      | username | password       |
      | tester1  | wrongPassword  |