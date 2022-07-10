Feature: User should be able click reset button

	#4. User should be able click reset button
	@B26G8-57  @B26G8-63   @B26Group8
	Scenario: User should be able click reset button
		Given user is on the application login page
	    When user enters correct credentials and click login
	    And user click Vehicles under the Fleet module
	    And user see the "Car - Entities - System - Car - Entities - System" page title
		And user checks the reset button if clickable
		And user clicks on the reset button
		Then the grid settings should be resetted to default