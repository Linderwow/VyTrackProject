package com.vytrack.test;

import com.github.javafaker.Faker;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class TestBase {
    Actions actions;
    Faker faker;
    JavascriptExecutor js;
    @BeforeMethod
    public void setUp(){
        System.out.println("Test started!");
        faker = new Faker();
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) Driver.getDriver(); //down casting to JS
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
