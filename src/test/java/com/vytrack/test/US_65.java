package com.vytrack.test;
import com.vytrack.pages.VehicleOdometer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_65 extends TB_US_65_66 {
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TB_US_65_66.class,priority = 1)
    public void AC1_OdoCheckStoreManager(String username,String password){
        loginToAccount(username,password);
        if (TopMenu.warningCloseBtn.isDisplayed()) TopMenu.warningCloseBtn.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetLink));
        action.moveToElement(TopMenu.fleetLink).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetSub_VehiclesOdometer));
        TopMenu.fleetSub_VehiclesOdometer.click();
        // Validate Store managers should see an error message
        String actualWarning = TopMenu.warningMessage.getText();
        String expectedWarning = "You do not have permission to perform this action.";
        Assert.assertEquals(actualWarning, expectedWarning);
    }
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TB_US_65_66.class,priority = 2)
    public void AC1_OdoCheckSalesManager(String username,String password){
        loginToAccount(username,password);
        if (TopMenu.warningCloseBtn.isDisplayed()) TopMenu.warningCloseBtn.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetLink));
        action.moveToElement(TopMenu.fleetLink).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetSub_VehiclesOdometer));
        TopMenu.fleetSub_VehiclesOdometer.click();
        // Validate Sales managers should see an error message
        String actualWarning = TopMenu.warningMessage.getText();
        String expectedWarning = "You do not have permission to perform this action.";
        Assert.assertEquals(actualWarning, expectedWarning);
    }

    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = TB_US_65_66.class,priority = 3)
    public void AC2_OdoCheckTruckDriver(String username,String password){
        loginToAccount(username,password);
        VehicleOdometer vehicleOdometer = new VehicleOdometer();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetLink));
        action.moveToElement(TopMenu.fleetLink).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetSub_VehiclesOdometer));
        TopMenu.fleetSub_VehiclesOdometer.click();
        // Wait till last cell is loaded
        webDriverWait.until(ExpectedConditions.visibilityOf(vehicleOdometer.lastCell));
        // Validate Drivers should see the default page as 1.
        String actual = vehicleOdometer.pageNumber.getAttribute("value");
        String expected = "1";
        Assert.assertEquals(actual, expected);
    }
    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = TB_US_65_66.class,priority = 4)
    public void AC3_OdoCheckPageTruckDriver(String username,String password){
        loginToAccount(username,password);
        VehicleOdometer vehicleOdometer = new VehicleOdometer();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetLink));
        action.moveToElement(TopMenu.fleetLink).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.fleetSub_VehiclesOdometer));
        TopMenu.fleetSub_VehiclesOdometer.click();
        // Wait till last cell is loaded
        webDriverWait.until(ExpectedConditions.visibilityOf(vehicleOdometer.lastCell));
        // Validate Drivers should see the default page as 1.
        String actual = vehicleOdometer.viewPerPage.getText();
        String expected="25";
        Assert.assertEquals(actual, expected);
    }
}
