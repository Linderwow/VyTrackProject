package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    public WebDriver driver = Driver.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver,10);
    public Actions actions = new Actions(driver);
    public BasePage(){
        PageFactory.initElements(driver,this);
    }




}
