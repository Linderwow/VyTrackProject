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
    public static void login(String username, String password) {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(password);
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();

    }

    public static void loginAsDriver() {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("usernameTruckDrivers1"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsStoreManager() {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("usernameStoreManager1"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsSalesManager() {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("usernameSalesManager1"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
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
