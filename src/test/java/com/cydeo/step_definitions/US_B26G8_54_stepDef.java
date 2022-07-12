package com.cydeo.step_definitions;

import com.cydeo.pages.VytrackPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class US_B26G8_54_stepDef {

    VytrackPage vytrackPage = new VytrackPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user on the Dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        vytrackPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @When("user click on Vehicle under fleet module")
    public void user_click_on_vehicle_under_fleet_module() {
        vytrackPage.fleetModule.click();
        vytrackPage.vehicles.click();
    }

    // Anton's scenario
    @Then("user should be able to click on the Export Grid button")
    public void user_should_be_able_to_click_on_the_export_grid_button() {

        vytrackPage.exportGrid.click();
        WebElement csv = Driver.getDriver().findElement(By.xpath("//a[@title='CSV']"));
        Assert.assertTrue(csv.isDisplayed());
        Driver.closeDriver();
    }

    // Shinkay's scenario
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
        if (xcord >= 0 && ycord >= 0) {
            System.out.println("Export Grid button is on the left side of the page");
        }
    }
    //Sasha's scenario
    @Then("User should see Grid Settings button and click it")
    public void userShouldSeeGridSettingsButtonAndClickIt() {
        wait.until(ExpectedConditions.elementToBeClickable(vytrackPage.settingsButton));
        vytrackPage.settingsButton.click();
    }

    @Then("User should see Grid Settings dropdown menu")
    public void userShouldSeeGridSettingsDropdownMenu() {
        wait.until(ExpectedConditions.visibilityOf(vytrackPage.gridSettingsTableTitle));
        vytrackPage.gridSettingsTableTitle.isDisplayed();
    }

    // Kanan's scenario
    @When("user clik on Vehicle under fleet module")
    public void user_clik_on_vehicle_under_fleet_module() {

        vytrackPage.fleetModule.click();

        BrowserUtils.waitForVisibility(vytrackPage.vehicles, 5);

        vytrackPage.vehicles.click();


    }
    @Then("user should see Grid Settings on the right side of Reset button")
    public void user_should_see_grid_settings_on_the_right_side_of_reset_button() {

        BrowserUtils.waitForVisibility(vytrackPage.GridSettingButton, 5);
        Assert.assertTrue(vytrackPage.GridSettingButton.isDisplayed());

    }
    @Then("Then user should see Refresh button on the left side of Reset button")
    public void then_user_should_see_refresh_button_on_the_left_side_of_reset_button() {
        BrowserUtils.waitForVisibility(vytrackPage.RefreshBtn, 5);
        Assert.assertTrue(vytrackPage.RefreshBtn.isDisplayed());
    }
    //Seyma

    @Then("user should see Grid Setting button on the right of the page")
    public void user_should_see_grid_setting_button_on_the_right_of_the_page() {
        Point point = vytrackPage.gridBtn.getLocation();
        int xxcord = point.getX();
        System.out.println("Position of the webelement from left side is " + xxcord + " pixels");
        int yycord = point.getY();
        System.out.println("Position of the webelement from top side is " + yycord + " pixels");


        Point point1 = vytrackPage.RefreshBtn.getLocation();
        int xxcord1 = point1.getX();
        System.out.println("Position of the webelement from left side is " + xxcord1 + " pixels");
        int yycord1 = point1.getY();
        System.out.println("Position of the webelement from top side is " + yycord1 + " pixels");
        //seyma

        if (xxcord > xxcord1) {
            System.out.println("The grid settings bottom is on the right side of the page");
    }}

    //Ali
    @Then("user should be able to click on the refresh button")
    public void userShouldBeAbleToClickOnTheRefreshButton() {

        boolean clicked = false;
        wait.until(ExpectedConditions.elementToBeClickable(vytrackPage.refreshButton));
        try {
            vytrackPage.refreshButton.click();
            clicked = true;
        } catch (Exception e) {
            throw new NoSuchElementException("element not clicked");
        }
        Assert.assertTrue(clicked);

    }
    // Gokhan
    @When("user checks the reset button if clickable")
    public void user_checks_the_reset_button_if_clickable() {
        System.out.println("vytrackLoginPage.resetBtn.isDisplayed() = " + vytrackPage.resetBtn.isDisplayed());
        System.out.println("vytrackLoginPage.resetBtn.isEnabled() = " + vytrackPage.resetBtn.isEnabled());

    }

    @When("user clicks on the reset button")
    public void user_clicks_on_the_reset_button() {
        actions.click(vytrackPage.resetBtn).perform();
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


