package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_57 extends TestBase {


    @DataProvider(name = "userTruckDriversProvider")
    public Object[][] provideData() {
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameTruckDrivers1"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameTruckDrivers2"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameTruckDrivers3"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameTruckDrivers4"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameTruckDrivers5"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameTruckDrivers6"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameTruckDrivers7"), ConfigurationReader.getProperty("password")}
        };
    }

    @DataProvider(name="userStoreManagerProvider")
    public Object[][] provideData1(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameStoreManager1"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameStoreManager2"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameStoreManager3"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameStoreManager4"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameStoreManager5"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameStoreManager6"), ConfigurationReader.getProperty("password")}
        };

    }


    @DataProvider(name="userSalesManagerProvider")
    public Object[][] provideData2(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameSalesManager1"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameSalesManager2"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameSalesManager3"), ConfigurationReader.getProperty("password")},
//                {ConfigurationReader.getProperty("usernameSalesManager4"), ConfigurationReader.getProperty("password")}

        };
    }


@Test(dataProvider = "userTruckDriversProvider")
    public void truckDriverTest (String username,String password){
      /*  AC1:when users click click the “Learn how to use this space”
    link on the homepage, users should see:
    “How To Use Pinbar” and
    “Use pin icon on the right top corner of the page to create fast
    access link in the pinbar.”*/
    VyTrack_Login.login(Driver.getDriver(),username,password);
    BrowserUtils.sleep(5);
    WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
    text.click();
    BrowserUtils.sleep(5);
    WebElement textAfterClick1 = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
    WebElement textAfterClick2 = Driver.getDriver().findElement(By.xpath("//p[1]"));
   // System.out.println(textAfterClick1.getText());
   // System.out.println(textAfterClick2.getText());
    Assert.assertEquals(textAfterClick1.getText(),"How To Use Pinbar");
    Assert.assertEquals(textAfterClick2.getText(),
            "Use pin icon on the right top corner of page to create fast access link in the pinbar.");

}




























}