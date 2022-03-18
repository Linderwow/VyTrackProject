package com.vytrack.test;
import com.vytrack.pages.VehicleContacts;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class US_58 extends TestBase implements ScreenShot{
    public static VehicleContacts VehicleContacts;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    @DataProvider(name="userTruckDriversProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {"usernameTruckDrivers1", "password"},
                {"usernameTruckDrivers2", "password"},
                {"usernameTruckDrivers3", "password"},
                {"usernameTruckDrivers4", "password"},
                {"usernameTruckDrivers5", "password"},
                {"usernameTruckDrivers6", "password"},
                {"usernameTruckDrivers7", "password"}
        };
    }
//
    @DataProvider(name="userStoreAndSalesManagerProvider")
    public Object[][] provideData1(){
        return new Object[][]{
                {"usernameStoreManager1","password"},
                {"usernameStoreManager2","password"},
                {"usernameStoreManager3","password"},
                {"usernameStoreManager4","password"},
                {"usernameStoreManager5","password"},
                {"usernameStoreManager6","password"},
                {"usernameSalesManager1", "password"},
                {"usernameSalesManager2", "password"},
                {"usernameSalesManager3", "password"},
                {"usernameSalesManager4", "password"}
        };

    }


    @Test(dataProvider = "userStoreAndSalesManagerProvider",priority = 1)
    public void VyLogin(String name,String password) {
        VehicleContacts = new VehicleContacts();

        LoginPage.inputUsername.sendKeys(getProperty(name));
        LoginPage.inputPassword.sendKeys(getProperty(password));
        VyTrackUtils.waitTillLoaderMaskDisappear();
        LoginPage.signInButton.click();
        TopMenu.fleetLink.click();
        TopMenu.fleetSub_VehiclesContracts.click();
        VyTrackUtils.waitTillLoaderMaskDisappear();
        wait.until(ExpectedConditions.visibilityOfAllElements(TopMenu.allModuleElements));
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        wait.until(ExpectedConditions.visibilityOf(VehicleContacts.tableCell));
        Assert.assertEquals(actualTitle, expectedTitle);
        String expectedUrl = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualUrl = getDriver().getCurrentUrl();
        VyTrackUtils.waitTillLoaderMaskDisappear();
         Assert.assertEquals(actualUrl, expectedUrl);
         System.out.println("Current URL is: " + actualUrl);
         System.out.println("Current title has been verified and is: " + actualTitle);
         screenShot();

    }
    @Test(dataProvider = "userTruckDriversProvider",priority = 2)
    public void VyLogin2(String name,String password) {
        VehicleContacts = new VehicleContacts();

        LoginPage.inputUsername.sendKeys(getProperty(name));
        LoginPage.inputPassword.sendKeys(getProperty(password));
        LoginPage.signInButton.click();
        VyTrackUtils.waitTillLoaderMaskDisappear();
        wait.until(ExpectedConditions.visibilityOf(TopMenu.fleetLink));
        TopMenu.fleetLink.click();
        TopMenu.fleetSub_VehiclesContracts.click();
        VyTrackUtils.waitTillLoaderMaskDisappear();
        WebElement errorText = getDriver().findElement(By.xpath("//*[text()='You do not have permission to perform this action.']"));
        System.out.println(errorText.getText());
        Assert.assertTrue(errorText.isDisplayed());
        screenShot();


    }

}


