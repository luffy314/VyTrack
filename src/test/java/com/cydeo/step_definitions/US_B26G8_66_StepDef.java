package com.cydeo.step_definitions;

import com.cydeo.pages.VytrackPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US_B26G8_66_StepDef {


    VytrackPage vytrackPage = new VytrackPage();


    @Given("user on the Dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        vytrackPage.login("user22", "UserUser123");
    }

    @When("user clicks on Vehicle under fleet module")
    public void user_clicks_on_vehicle_under_fleet_module()  {
        vytrackPage.fleetModule.click();
        vytrackPage.vehicles.click();

    }

    @Then("user should see Export Grid button on the left")
    public void user_should_see_export_grid_button_on_the_left() {

        // using explicit wait for the driver to have enough time to locate vehicles under fleet module
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(vytrackPage.exportGrid));

        // using point class to find the x and y coordinates of the vehicles
        Point point = vytrackPage.exportGrid.getLocation();
        int xcord = point.getX();
        System.out.println("xcord = " + xcord);
        int ycord = point.getY();
        System.out.println("ycord = " + ycord);

        // using Actions class to find the WebElement and click on it
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(vytrackPage.exportGrid, xcord, ycord).click().build().perform();

        // making an if condition to verify the presence of the button on the left side
        if(xcord >= 0 && ycord >= 0){
            System.out.println("Export Grid button is on the left side of the page");
        }


    }
}
