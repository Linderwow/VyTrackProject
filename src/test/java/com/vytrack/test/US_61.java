package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_61 extends TestBase{
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

    @DataProvider(name="userStoreManagerProvider")
    public Object[][] provideData1(){
        return new Object[][]{
                {"usernameStoreManager1","password"},
                {"usernameStoreManager2","password"},
                {"usernameStoreManager3","password"},
                {"usernameStoreManager4","password"},
                {"usernameStoreManager5","password"},
                {"usernameStoreManager6","password"}
        };

    }

    @DataProvider(name="userSalesManagerProvider")
    public Object[][] provideData2(){
        return new Object[][]{
                {"usernameSalesManager1","password"},
                {"usernameSalesManager2","password"},
                {"usernameSalesManager3","password"},
                {"usernameSalesManager4","password"}
        };
    }
    /*
    User Story:
As a user, I should be to select any vehicle from the Vehicle page(web-table)
     */
    @Test(dataProvider = "userTruckDriversProvider", priority = 1)
    public void truckDriversTest(String username, String password) {
        //AC #1: once the user launched to the Vehicle page, all the checkboxes should be unchecked
        //step1:
        VyTrack_Login.login(Driver.getDriver(), ConfigurationReader.getProperty(username) , ConfigurationReader.getProperty(password));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        //step2:
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step3:
        BrowserUtils.sleep(1);
        WebElement vehiclesElm = Driver.getDriver().findElement(By.xpath("//a//span[text()='Vehicles']"));
        vehiclesElm.click();
        BrowserUtils.sleep(3);

        //AC #2: user check the first checkbox to check all the cars
        //AC #3: users can select any car
        try{
            WebElement firstColumn = Driver.getDriver().findElement(By.xpath(""));
        }catch (NoSuchElementException e){
            System.out.println("There is not first checkbox column in front of License Plate column");
        }


    }

    @Test(dataProvider = "userStoreManagerProvider", priority = 2)
    public void storeManagerTest(String username, String password){
        //AC #1: once the user launched to the Vehicle page, all the checkboxes should be unchecked
        //AC #2: user check the first checkbox to check all the cars
        //AC #3: users can select any car
        //step1:
        VyTrack_Login.login(Driver.getDriver(), ConfigurationReader.getProperty(username) , ConfigurationReader.getProperty(password));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        //step2:
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step3:
        BrowserUtils.sleep(1);
        WebElement vehiclesElm = Driver.getDriver().findElement(By.xpath("//a//span[text()='Vehicles']"));
        vehiclesElm.click();
        BrowserUtils.sleep(3);
        WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
        BrowserUtils.sleep(2);
        Assert.assertFalse(firstCheckBox.isSelected(), "First check box is selected");
        //step4: check on first check box
        BrowserUtils.sleep(1);
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected(), "First check box is not selected");
        //step5: check on first checkbox again to unselect
        BrowserUtils.sleep(2);
        firstCheckBox.click();
        Assert.assertFalse(firstCheckBox.isSelected(), "First check box is selected");
        BrowserUtils.sleep(2);
        //step6: check on any checkbox for car's option



    }

    @Test(dataProvider = "userSalesManagerProvider", priority = 3)
    public void salesManagerTest(String username, String password){
        //AC #1: once the user launched to the Vehicle page, all the checkboxes should be unchecked
        //AC #2: user check the first checkbox to check all the cars
        //AC #3: users can select any car
        //step1:
        VyTrack_Login.login(Driver.getDriver(), ConfigurationReader.getProperty(username) , ConfigurationReader.getProperty(password));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        //step2:
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step3:
        BrowserUtils.sleep(1);
        WebElement vehiclesElm = Driver.getDriver().findElement(By.xpath("//a//span[text()='Vehicles']"));
        vehiclesElm.click();
        BrowserUtils.sleep(3);
        try{
            WebElement firstColumn = Driver.getDriver().findElement(By.xpath(""));
        }catch (NoSuchElementException e){
            System.out.println("There is not first checkbox column in front of License Plate column");
        }


    }

}
