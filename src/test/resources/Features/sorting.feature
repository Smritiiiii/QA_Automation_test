Feature: Sorting Products

  @SortByNameAtoZ
  Scenario: User sorts products by name (A to Z)
    Given User have open the browser
    When User opens the website
    And User enters valid username standard_user and password secret_sauce
    And User clicks the login button
    Then User should navigate to dashboard
    When User sorts products by name (A to Z)
    Then Products should be displayed in ascending order by name
