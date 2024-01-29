Feature: Shopping Cart

  @RemoveFromCart
  Scenario: User removes an item from the cart
    Given User have open the browser
    When User opens the website
    And User enters valid username standard_user and password secret_sauce
    When User removes item with name backpack from the cart
    Then User should not see the item in the cart
