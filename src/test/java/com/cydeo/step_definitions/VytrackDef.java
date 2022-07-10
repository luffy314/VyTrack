package com.cydeo.step_definitions;

import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VytrackDef {

        VyTrackLoginPage vytrackLoginPage = new VyTrackLoginPage();
        Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("user is on the application login page")
    public void user_is_on_the_application_login_page() {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
    }

    @When("user enters correct credentials and click login")
    public void user_enters_correct_credentials_and_click_login() {
        vytrackLoginPage.username.sendKeys("user22");
        vytrackLoginPage.password.sendKeys("UserUser123");
        vytrackLoginPage.loginBtn.click();
    }

    @When("user click Vehicles under the Fleet module")
    public void user_click_vehicles_under_the_fleet_module() {
        actions.moveToElement(vytrackLoginPage.fleetModule).perform();
        vytrackLoginPage.vehicles.click();
    }

    @When("user see the {string} page title")
    public void user_see_the_page_title(String string) {
        wait.until(ExpectedConditions.titleIs(string));
        Assert.assertEquals(string, Driver.getDriver().getTitle());

    }

    @When("user checks the reset button if clickable")
    public void user_checks_the_reset_button_if_clickable() {
        System.out.println("vytrackLoginPage.resetBtn.isDisplayed() = " + vytrackLoginPage.resetBtn.isDisplayed());
        System.out.println("vytrackLoginPage.resetBtn.isEnabled() = " + vytrackLoginPage.resetBtn.isEnabled());

    }

    @When("user clicks on the reset button")
    public void user_clicks_on_the_reset_button() {
        actions.click(vytrackLoginPage.resetBtn).perform();
    }

    @Then("the grid settings should be resetted to default")
    public void the_grid_settings_should_be_resetted_to_default() {

        Scenario scenario = null;

            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        if (scenario != null) {
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // or we can do it in one line
            //  byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        }

    }




