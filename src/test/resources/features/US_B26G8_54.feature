@wip
  Feature: Vytrack => Fleet => Vehicles feature
    User Story: As a user when I am on Vytrack => Fleet => Vehicles,
    I should be able to see Export Grid dropdown, Refresh, Reset and
    Grid Settings Buttons
   @B26G8-69 @Anton
    Scenario: User should be able to click Export Grid dropdown
      Given user on the Dashboard page
      When user click on Vehicle under fleet module
      Then user should be able to click on the Export Grid button

    @B26G8-66 @B26G8-63 @Shinkay
    Scenario: Export Grid dropdown is on the left of the page
      Given user on the Dashboard page
      When user click on Vehicle under fleet module
      Then user should see Export Grid button on the left

    @B26G8-54 @B26G8_61 @Sasha
    Scenario: User click Grid Button
      Given user on the Dashboard page
      When user click on Vehicle under fleet module
      Then User should see Grid Settings button and click it
      Then User should see Grid Settings dropdown menu


    @B26G8-67   @B26G8-54 @Kanan
    Scenario: Grid Settings should be on the right side of the Reset button

      Given user on the Dashboard page
      When user clik on Vehicle under fleet module
      Then user should see Grid Settings on the right side of Reset button



    @B26G8-62 @B26G8-54 @Vicky
    Scenario: Refresh button should be on the left side of Reset button

      Given user on the Dashboard page
      When user clik on Vehicle under fleet module
      Then Then user should see Refresh button on the left side of Reset button




        @B26G8-56  @B26G8-70  @ali
      Scenario: User should be able to click refresh button
        Given user on the Dashboard page
        When user click on Vehicle under fleet module
        Then user should be able to click on the refresh button
