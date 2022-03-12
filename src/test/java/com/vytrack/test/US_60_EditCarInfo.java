package com.vytrack.test;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;
import static org.testng.Assert.assertEquals;

public class US_60_EditCarInfo extends TestBase {

    @DataProvider(name = "US-60_Credentials")
    public Object[][] credentials() {
        return new Object[][]{{"usernameStoreManager1", "password"},
                {"usernameTruckDrivers3", "password"},
                {"usernameSalesManager1", "password"},
        };}


    @Test(dataProvider = "US-60_Credentials")
    public void edit_car_info_test(String username, String passwords) {

        VytrackUtils.login(ConfigurationReader.getProperty(username), ConfigurationReader.getProperty(passwords)); //it's for login to homepage
        //BrowserUtils.sleep(2);
        //1. Find a Fleet tab and hover on it

        WebElement fleetTabs = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOf(fleetTabs));
        }catch(TimeoutException e){
            e.printStackTrace();
        }
        actions.moveToElement(fleetTabs).perform();
        //BrowserUtils.sleep(2);

        WebElement vehicles = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"));
        vehicles.click();
        BrowserUtils.sleep(2);

        List<WebElement> dots = Driver.getDriver().findElements(By.xpath("//a[.='...']"));

        int num = faker.number().numberBetween(1, dots.size());

        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOf(dots.get(num)));
        }catch(TimeoutException e){
            e.printStackTrace();
        }
        actions.moveToElement(dots.get(num)).pause(1000).click(dots.get(num)).pause(2000).perform();


        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[3]//a"));
        WebElement editBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[2]//a"));
        WebElement viewBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[1]//a"));

        String delete = deleteBtn.getAttribute("title");
        String edit = editBtn.getAttribute("title");
        String view = viewBtn.getAttribute("title");

        String expectedDelete = "Delete";
        String expectedEdit = "Edit";
        String expectedView = "View";

        Assert.assertEquals(delete, expectedDelete);
        Assert.assertEquals(edit, expectedEdit);
        Assert.assertEquals(view, expectedView);

    }
}