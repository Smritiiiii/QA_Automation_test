@LoginPage
Feature: CucumberJava

  @InvalidCredentials
  Scenario: Verify if invalid username and  password is entered then user should see error message
    Given User have open the browser
    When User opens the website
    And User enters invalid username some_username and password secret_sauce
    And User clicks the login button
    Then User should see an error message
