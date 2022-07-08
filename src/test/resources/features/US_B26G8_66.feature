Feature: User should be able to click the Export Grid button on the left of the page

  @B26G8-66 @B26G8-63
  Scenario: Export Grid dropdown is on the left of the page
    Given user on the Dashboard page
    When user clicks on Vehicle under fleet module
    Then user should see Export Grid button on the left