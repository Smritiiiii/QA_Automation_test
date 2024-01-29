Feature: Shopping

  @AddToCart
  Scenario: User logs in, adds an item to the cart, and verifies it is added
    Given User have open the browser
    When User opens the website
    And User enters valid username standard_user and password secret_sauce
    And User clicks the login button
    Then User should navigate to dashboard
    When User adds item with name sauce lab backpack to the cart
    Then User should see the item in the cart
