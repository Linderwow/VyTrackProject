package com.vytrack.test;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class TestBase {
    public static LoginPage LoginPage;
    public static TopMenu TopMenu;
    public static WebDriverWait webDriverWait;
    public static Actions action;

    @BeforeMethod
    public void setUp(){
    getDriver().get(getProperty("env"));

        LoginPage=new LoginPage();
        TopMenu=new TopMenu();
        webDriverWait=new WebDriverWait(getDriver(),10);
        action=new Actions(getDriver());


    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
