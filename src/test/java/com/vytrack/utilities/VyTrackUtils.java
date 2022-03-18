package com.vytrack.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class VyTrackUtils {
    public static void login(String username, String password) {
        //go to website
        getDriver().get(getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(password);
        //click login button
        getDriver().findElement(By.tagName("button")).click();

    }

    public static void loginAsDriver() {
        //go to website
        getDriver().get(getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(getProperty("usernameTruckDrivers1"));
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(getProperty("password"));
        //click login button
        getDriver().findElement(By.tagName("button")).click();
    }
//
    public static void loginAsDriver(int sleectEnv_1_or_2) {
        //go to website
        if (sleectEnv_1_or_2==1){
            getDriver().get(getProperty("env"));
        }else {
            getDriver().get(getProperty("env"+sleectEnv_1_or_2));
        }
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(getProperty("usernameTruckDrivers1"));
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(getProperty("password"));
        //click login button
        getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsStoreManager() {
        //go to website
        getDriver().get(getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(getProperty("usernameStoreManager1"));
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(getProperty("password"));
        //click login button
        getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsStoreManager(int sleectEnv_1_or_2) {
        //go to website
        if (sleectEnv_1_or_2==1){
            getDriver().get(getProperty("env"));
        }else {
            getDriver().get(getProperty("env"+sleectEnv_1_or_2));
        }
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(getProperty("usernameStoreManager1"));
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(getProperty("password"));
        //click login button
        getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsSalesManager() {
        //go to website
        getDriver().get(getProperty("env"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(getProperty("usernameSalesManager1"));
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(getProperty("password"));
        //click login button
        getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsSalesManager(int sleectEnv_1_or_2) {
        //go to website
        if (sleectEnv_1_or_2==1){
            getDriver().get(getProperty("env"));
        }else {
            getDriver().get(getProperty("env"+sleectEnv_1_or_2));
        }
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(getProperty("usernameSalesManager1"));
        //pass password
        getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(getProperty("password"));
        //click login button
        getDriver().findElement(By.tagName("button")).click();
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
