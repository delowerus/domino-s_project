@web @regression @domino's
Feature: domino's feature;
  Background:
    Given I am on dominos homepage

  @store-pickup-order
    Scenario: Create a store pickup order for all available speciality pizza
      When I select carryout
      Then I enter zip code
      And  I enter search location
      Then I select the first store
      Then I select speciality pizza
      And I add all the speciality pizza to the cart
      Then I validate cart displayed the right amount of pizza
      Then I select checkout
      Then I close any upSell popup
      And I click continue checkout
      Then I verify checkout page has displayed
      Then Verify place your order button is functional

  @add-or-remove-pizzas
  Scenario: Add and remove items from shopping cart
    When I select carryout
    Then I enter zip code
    And  I enter search location
    Then I select the first store
    Then I select speciality pizza
    And I add 5 speciality pizzas to the cart
    Then I click on the cart
    And I add 2 more pizzas on the cart
    Then I verify cart displayed the right amount of pizza
    And I remove 2 order from the cart
    Then I verify the cart contains right amount of orders

  @SignUp
  Scenario: verify valid sign-up
    When I click on SIGN IN & EARN REWARDS on home page
    Then I click on to CREATE ONE link on home page
    Then I enter Md into firstname text fields on home page
    And I enter Hossen into lastname text fields on home page
    Then I enter email into email test fields
    Then I confirm email address
    And I enter 6464030389 into mobile number text fields on home page
    And I enter hossen@21 into new password text fields on home page
    And I click on JOIN NOW button on home page
    Then I verify valid signup message