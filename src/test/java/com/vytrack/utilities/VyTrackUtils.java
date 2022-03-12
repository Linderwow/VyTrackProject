package com.vytrack.utilities;

import com.vytrack.pages.LoginPage;
import com.vytrack.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class VyTrackUtils {
    public static LoginPage LoginPage;

    public static void login(String username, String password) {
        LoginPage=new LoginPage();
        // pass username
        LoginPage.inputUsername.sendKeys(username);
        //pass password
       LoginPage.inputPassword.sendKeys(password);
        //click login button
        LoginPage.signInButton.click();
    }

    public static void loginAsDriver() {
        LoginPage=new LoginPage();
        // pass username
        LoginPage.inputUsername.sendKeys(getProperty("usernameTruckDrivers1"));
        //pass password
        LoginPage.inputPassword.sendKeys(getProperty("password"));
        //click login button
        LoginPage.signInButton.click();
    }

    public static void loginAsStoreManager() {
        LoginPage=new LoginPage();
        // pass username
        LoginPage.inputUsername.sendKeys(getProperty("usernameStoreManager1"));
        //pass password
        LoginPage.inputPassword.sendKeys(getProperty("password"));
        //click login button
        LoginPage.signInButton.click();
    }

    public static void loginAsSalesManager() {
        LoginPage=new LoginPage();
        // pass username
        LoginPage.inputUsername.sendKeys(getProperty("usernameSalesManager1"));
        //pass password
        LoginPage.inputPassword.sendKeys(getProperty("password"));
        //click login button
        LoginPage.signInButton.click();
    }

    public static void waitTillLoaderMaskDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            WebElement loaderMask = getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void navigate(String tab,String module){

    }
}
