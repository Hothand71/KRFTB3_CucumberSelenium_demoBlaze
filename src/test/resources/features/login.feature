Feature: Login Test- The User Should be able to log in with valid credentials
  Background: Go to store page
    Given The User is on the Login Page

  Scenario: Positive Login Test 1
    When The user is enter valid credentials
    Then The user verify that Welcome username is displayed

  Scenario: Positive Login Test 2 login with parameter
    When The user is enters with "GeraltOfRivia" and "Geralt1234." credentials
    Then The user verify that "Welcome GeraltOfRivia" is displayed

    Scenario Outline: Positive Login Test 3 login with scenario outline
      When The user is enters with "<username>" and "<password>" credentials
      Then The user verify that "<WelcomeUsername>" is displayed
      Examples:
        | username      | password    | WelcomeUsername       |
        | GeraltOfRivia | Geralt1234. | Welcome GeraltOfRivia |



  Scenario Outline: Positive Login Test 3 login with scenario outline
    When The user is enters valid username and password credentials
      | username | <username> |
      | password | <password> |
    Then The user verify that "<WelcomeUsername>" is displayed
    Examples:
      | username      | password    | WelcomeUsername       |
      | GeraltOfRivia | Geralt1234. | Welcome GeraltOfRivia |
  @wip
  Scenario Outline: Negative Scenario The user should Not ve able to log in with invalid credentials
    When The user is enters with "<username>" and "<password>" credentials
    Then The user verify that should be invalid credentials "<message>"
    Examples:
      | username      | password    | message                                |
      |               |             | Please fill out Username and Password. |
      | GeraltOfRivia |             | Please fill out Username and Password. |
      |               | Geralt1234. | Please fill out Username and Password. |
      | GeraltOfRivia | 1234563     | Wrong password.                        |
      | GeraltOf      | Geralt1234. | User does not exist.                   |