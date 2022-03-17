package com.vytrack.test;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.Vehicle;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class US_60_EditCarInfo extends TestBaseUS_60 {


    @DataProvider(name = "US-60_Credentials")
    public Object[][] credentials() {
        return new Object[][]{{"usernameStoreManager4", "password"},
                {"usernameTruckDrivers3", "password"},
                {"usernameSalesManager1", "password"},
        };
    }


    @Test(dataProvider = "US-60_Credentials")
    public void edit_car_info_test(String username, String passwords) {

        VyTrackUtils.login(ConfigurationReader.getProperty(username), ConfigurationReader.getProperty(passwords)); //it's for login to homepage

        actions.moveToElement(TopMenu.fleetLink).perform();

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOf(TopMenu.fleetLink));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        TopMenu.fleetSub_Vehicles.click();

        int num = faker.number().numberBetween(1, vehicle.allOfDots.size());

        //js.executeScript("arguments[0].scrollIntoView(true);", vehicle.allOfDots.get(num));

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOf(vehicle.allOfDots.get(num)));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        actions.moveToElement(vehicle.allOfDots.get(num)).pause(1000).click(vehicle.allOfDots.get(num)).pause(2000).perform();

        VyTrackUtils.waitTillLoaderMaskDisappear();

        String delete = vehicle.deleteButton.getAttribute("title");
        String edit = vehicle.editButton.getAttribute("title");
        String view = vehicle.viewButton.getAttribute("title");

        List<String> expectedIconOptions = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));

        List<String> actualIconOptions = new ArrayList<>();
        actualIconOptions.addAll(Arrays.asList(view, edit, delete));

        assertEquals(actualIconOptions, expectedIconOptions);

    }
}