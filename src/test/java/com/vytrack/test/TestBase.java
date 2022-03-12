package com.vytrack.test;

import com.vytrack.pages.HomePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class TestBase {

    public static LoginPage LoginPage;
    public static HomePage HomePage;
    @BeforeMethod
    public void setUp(){
        getDriver().get(getProperty("env"));
        LoginPage=new LoginPage();
        HomePage=new HomePage();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
