package com.vytrack.test;


import com.github.javafaker.Faker;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.TopMenu;
import com.vytrack.pages.Vehicle;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class TestBaseUS_60 {
    public static Actions actions;
    public static Faker faker;
    public static JavascriptExecutor js;
    public static Vehicle vehicle;

    public static com.vytrack.pages.LoginPage LoginPage;
    public static com.vytrack.pages.TopMenu TopMenu;

    @BeforeMethod
    public void setUp(){
        System.out.println("Test started!");
        faker = new Faker();
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) Driver.getDriver(); //down casting to JS
        vehicle = new Vehicle();

        Driver.getDriver().get(getProperty("env2"));
        LoginPage=new LoginPage();
        TopMenu=new TopMenu();
//
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}