@web @regression @domino's
Feature: domino's feature

  Background:
    Given I am on domino's homepage

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

