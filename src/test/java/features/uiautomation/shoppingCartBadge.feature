Feature: Testing the shopping cart badge number

  Background:
    Given  the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the login button is clicked
    And the page is refreshed

  Scenario Outline: As a logged in user , i should be able to add two items to the cart.
    Given the First item '<label1>' is added to the cart
    And the Second item '<label2>' is added to the cart
    Then the number '2' should be showing on top of the shopping cart

    Examples:
            | label1  | label2 |
            |  Sauce Labs Backpack | Sauce Labs Bolt T-Shirt |

  Scenario Outline: As a logged in user , i should be able to add three items to the cart.
    Given the First item '<label1>' is added to the cart
    And the Second item '<label2>' is added to the cart
    And the Third item '<label2>' is added to the cart
    Then the number '3' should be showing on top of the shopping cart

     Examples:
                | label1  | label2 |label3|
                |  Sauce Labs Backpack | Sauce Labs Bolt T-Shirt |Sauce Labs Bike Light|
