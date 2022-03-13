package com.vytrack.test;

import com.github.javafaker.Faker;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class TestBase {
    Actions actions;
    Faker faker;
    JavascriptExecutor js;

    public static LoginPage LoginPage;
    public static TopMenu TopMenu;
    @BeforeMethod
    public void setUp(){
        System.out.println("Test started!");
        faker = new Faker();
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) Driver.getDriver(); //down casting to JS
        getDriver().get(getProperty("env"));
        LoginPage=new LoginPage();
        TopMenu=new TopMenu();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
