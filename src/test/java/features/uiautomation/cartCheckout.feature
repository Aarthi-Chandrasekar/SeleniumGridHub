Feature: Ordering and checking out

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the login button is clicked
    And the page is refreshed


  Scenario Outline: As a logged in user ,i should be add items to the cart and perform checkout
    Given the First item '<label1>' is added to the cart
    And the cart icon is clicked
    And the Checkout button is clicked
    And the First name is filled with 'Aarthi'
    And the Last name is filled with 'Chandrasekar'
    And the Zip code is filled with '1234'
    When the Continue button is clicked
    Then '<total>' should be shown as total price

     Examples:
        | label1  | total|
        |  Sauce Labs Backpack |Total: $49.66|

  Scenario Outline: As a logged in user i should be able to add and chekout multiple items in the cart
    Given the Third item '<label2>' is added to the cart
    And the First item '<label1>' is added to the cart
    And the Second item '<label2>' is added to the cart
    And the cart icon is clicked
    And the Checkout button is clicked
    And the First name is filled with 'Aarthi'
    And the Last name is filled with 'Chandrasekar'
    And the Zip code is filled with '1234'
    When the Continue button is clicked
    Then '<total>' should be shown as total price
    And  '<tax>' should be shown as tax
    And '<itemtotal>' should be shown as an item total

   Examples:
           | label1  | label2 |label3|total|tax|itemtotal|
           |  Sauce Labs Backpack | Sauce Labs Bolt |Sauce Labs Bike |Total: $60.45|Tax: $4.48|Item total: $55.97|
