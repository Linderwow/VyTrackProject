package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.vytrack.utilities.Driver.getDriver;

public class LoginPage {
    //#1- initialize the driver instance and object of the class
    public LoginPage(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(getDriver(), this);
    }

    //#2- use @FindBy annotation to locate web elements

    @FindBy(id = "prependedInput")
    public WebElement inputUsername;

    @FindBy(css = "#prependedInput2")
    public WebElement inputPassword;

    @FindBy(tagName = "button")
    public WebElement signInButton;

    @FindBy(xpath = "//a[.='Forgot your password?']")
     public WebElement forgotPasswordBtn;

    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public WebElement rememberMeBtn;

}
