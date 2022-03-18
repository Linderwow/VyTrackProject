package com.vytrack.test;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import com.vytrack.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_59_ViewColumnsAsManagers extends TestBase{

//
    @Test
    public void verify_columns_as_sales_manager1(){

    //login as sales manager
    VyTrackUtils.loginAsSalesManager();

    //go to Fleet tab
    WebElement fleetTabElement = TopMenu.fleetLink;
    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(fleetTabElement).perform();
    WebElement vehiclesModelElement = TopMenu.fleetSub_VehiclesModels;

    //we are using for waiting until loader mask disappearing
    vehiclesModelElement.click();
    VyTrackUtils.waitTillLoaderMaskDisappear();
    List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
    List<String> expectedheadersFromVehicleModelTable=new ArrayList<>(Arrays.asList(
            "MODEL NAME",
            "MAKE",
            "CAN BE REQUESTED",
            "CVVI",
            "CO2 FEE (/MONTH)",
            "COST (DEPRECIATED)",
            "TOTAL COST (DEPRECIATED)",
            "CO2 EMISSIONS",
            "FUEL TYPE",
            "VENDORS"
    ));

    //verify header columns
        Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);

}

   @Test
   public void verify_columns_as_sales_manager2(){
       //login as sales manager

       VyTrackUtils.login(ConfigurationReader.getProperty("usernameSalesManager2"),ConfigurationReader.getProperty("password"));

       //go to Fleet tab
       WebElement fleetTabElement = TopMenu.fleetLink;
       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(fleetTabElement).perform();
       WebElement vehiclesModelElement = TopMenu.fleetSub_VehiclesModels;

       //we are using for waiting until loader mask disappearing
       vehiclesModelElement.click();
       VyTrackUtils.waitTillLoaderMaskDisappear();
       List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
       List<String> expectedheadersFromVehicleModelTable=new ArrayList<>(Arrays.asList(
               "MODEL NAME",
               "MAKE",
               "CAN BE REQUESTED",
               "CVVI",
               "CO2 FEE (/MONTH)",
               "COST (DEPRECIATED)",
               "TOTAL COST (DEPRECIATED)",
               "CO2 EMISSIONS",
               "FUEL TYPE",
               "VENDORS"
       ));

       //verify header columns
       Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);

   }

   @Test
   public void verify_columns_as_sales_manager3() {
       //login as sales manager

       VyTrackUtils.login(ConfigurationReader.getProperty("usernameSalesManager3"), ConfigurationReader.getProperty("password"));

       //go to Fleet tab
       WebElement fleetTabElement = TopMenu.fleetLink;
       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(fleetTabElement).perform();
       WebElement vehiclesModelElement = TopMenu.fleetSub_VehiclesModels;

       //we are using for waiting until loader mask disappearing
       vehiclesModelElement.click();
       VyTrackUtils.waitTillLoaderMaskDisappear();
       List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
       List<String> expectedheadersFromVehicleModelTable = new ArrayList<>(Arrays.asList(
               "MODEL NAME",
               "MAKE",
               "CAN BE REQUESTED",
               "CVVI",
               "CO2 FEE (/MONTH)",
               "COST (DEPRECIATED)",
               "TOTAL COST (DEPRECIATED)",
               "CO2 EMISSIONS",
               "FUEL TYPE",
               "VENDORS"
       ));

       //verify header columns
       Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);
   }

    @Test
    public void verify_columns_as_store_manager1(){

    //login as sales manager
    VyTrackUtils.loginAsStoreManager();

    //go to Fleet tab
    WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(fleetTabElement).perform();
    WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]"));

    //we are using for waiting until loader mask disappearing
    vehiclesModelElement.click();
    VyTrackUtils.waitTillLoaderMaskDisappear();
    List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
    List<String> expectedheadersFromVehicleModelTable=new ArrayList<>(Arrays.asList(
            "MODEL NAME",
            "MAKE",
            "CAN BE REQUESTED",
            "CVVI",
            "CO2 FEE (/MONTH)",
            "COST (DEPRECIATED)",
            "TOTAL COST (DEPRECIATED)",
            "CO2 EMISSIONS",
            "FUEL TYPE",
            "VENDORS"
    ));

    //verify header columns
    Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);
}

    @Test
    public void verify_columns_as_store_manager2(){

        //login as sales manager
        VyTrackUtils.login(ConfigurationReader.getProperty("usernameStoreManager2"),ConfigurationReader.getProperty("password"));

        //go to Fleet tab
        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]"));

        //we are using for waiting until loader mask disappearing
        vehiclesModelElement.click();
        VyTrackUtils.waitTillLoaderMaskDisappear();
        List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
        List<String> expectedheadersFromVehicleModelTable=new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"
        ));

        //verify header columns
        Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);
    }

    @Test
    public void verify_columns_as_store_manager3(){

        //login as sales manager
        VyTrackUtils.login(ConfigurationReader.getProperty("usernameStoreManager3"),ConfigurationReader.getProperty("password"));

        //go to Fleet tab
        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]"));

        //we are using for waiting until loader mask disappearing
        vehiclesModelElement.click();
        VyTrackUtils.waitTillLoaderMaskDisappear();
        List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
        List<String> expectedheadersFromVehicleModelTable=new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"
        ));

        //verify header columns
        Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);
    }
}
