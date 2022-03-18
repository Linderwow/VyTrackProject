package com.vytrack.test;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;
import static com.vytrack.utilities.VyTrackUtils.waitTillLoaderMaskDisappear;

public class TB_US_65_66 {
    public static com.vytrack.pages.LoginPage LoginPage;
    public static com.vytrack.pages.TopMenu TopMenu;
    public static WebDriverWait webDriverWait;
    public static Actions action;

    @BeforeMethod
    public void setUp(){
        getDriver().get(getProperty("env"));
        LoginPage=new LoginPage();
        TopMenu=new TopMenu();
        webDriverWait=new WebDriverWait(getDriver(),10);
        action=new Actions(getDriver());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @DataProvider(name = "VyTrackCredentials")
    public static Object[][] credentials(Method VY) {
        if (VY.getName().equals("AC1_OdoCheckStoreManager")) {
            return new Object[][]{{"usernameStoreManager1", "password" },
                    {"usernameStoreManager2", "password"},
//                    {"usernameStoreManager3","password" },
//                    {"usernameStoreManager4","password" },
//                    {"usernameStoreManager5","password" },
//                    {"usernameStoreManager6","password" },
            };
        } else if(VY.getName().equals("AC1_OdoCheckSalesManager")){
            return new Object[][]{{"usernameSalesManager1","password" },
                    {"usernameSalesManager2","password" },
//                    {"usernameSalesManager3","password" },
//                    {"usernameSalesManager4","password" },

            };}else
            return new Object[][]{{"usernameTruckDrivers1", "password"},
                    {"usernameTruckDrivers2", "password"},
//                    {"usernameTruckDrivers3", "password"},
//                    {"usernameTruckDrivers4", "password"},
//                    {"usernameTruckDrivers5", "password"},
//                    {"usernameTruckDrivers6", "password"},
//                    {"usernameTruckDrivers7", "password"},
            };
    }
    public static void loginToAccount(String username,String password){
        LoginPage.inputUsername.sendKeys(getProperty(username));
        LoginPage.inputPassword.sendKeys(getProperty(password));
        LoginPage.signInButton.click();
        waitTillLoaderMaskDisappear();
    }
}
