package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "prependedInput")
    public WebElement username;

    @FindBy (id = "prependedInput2")
    public WebElement password;

    @FindBy (id = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetModule;

    @FindBy (xpath = "//a[.='Vehicles']")
    public WebElement vehicles;

    @FindBy (xpath = "//a[@title='Reset']")
    public WebElement resetBtn;

    @FindBy (xpath = "//table")
    public WebElement table;

    public void login(String name,String pass){
        username.sendKeys(name);
        password.sendKeys(pass);
        loginBtn.click();

    }

}
