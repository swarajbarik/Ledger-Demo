Feature: This feature is to test the login functionality

  @login @e2e
  Scenario: Valid login should display the username
    Given user navigates to "https://react-redux.realworld.io/"
    When user click on "Sign in" link from top menu
    And user enters username as "testing@web.com"
    And user enters password as "test123"
    And user click on Sign In button
    Then user verifies the user should display as "Test User 007"

  @login
  Scenario Outline: Verify login functionality for <Description>
    Given user navigates to "https://react-redux.realworld.io/"
    When user click on "Sign in" link from top menu
    And user enters username as "<User Name>"
    And user enters password as "<Password>"
    And user click on Sign In button
    Then user verifies the error message as "<Expected Result>"

    Examples: 
      | Description               | User Name       | Password | Expected Result              |
      | Blank Email               |                 | test     | email can't be blank         |
      | Blank Password            | test@email.com  |          | password can't be blank      |
      | Wrong Username & Password | testing@web.com | INVALID  | email or password is invalid |
