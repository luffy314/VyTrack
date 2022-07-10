package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackPage {

    public VytrackPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement inputUsername;

    @FindBy(name = "_password")
    public WebElement inputPassword;

    @FindBy(name = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1'])[1]")
    public WebElement fleetModule;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicles;

    @FindBy(xpath = "//div[@class='pull-left grid-toolbar-mass-actions']")
    public WebElement exportGrid;

    @FindBy(xpath = "//div[@class='column-manager dropdown']")
    public WebElement GridSettingButton;

    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }
}
