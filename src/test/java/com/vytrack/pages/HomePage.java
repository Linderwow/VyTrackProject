package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> homePageModulesDriver;

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> homePageModulesManager;

    @FindBy(xpath = "//i[@title='Get help']")
    public WebElement questionIcon;

    @FindBy(xpath = "//a[.='Learn how to use this space']")
    public WebElement howToUseThisSpaceLink;

    @FindBy(xpath = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]")
    public WebElement fleetModule;

    @FindBy(xpath = "//span[.='Vehicle Contracts']")
    public WebElement vehicleContracts;

    @FindBy(xpath = "//span[.='Vehicles Model']")
    public WebElement vehiclesModel;


    @FindBy(xpath = "//span[normalize-space()='Dashboards' and contains(@class, 'title title-level-1')]")
    public WebElement dashboardsModule;

    @FindBy(xpath = "//span[normalize-space()='Customers' and contains(@class, 'title title-level-1')]")
    public WebElement customersModule;

    @FindBy(xpath = "//span[normalize-space()='Sales' and contains(@class, 'title title-level-1')]")
    public WebElement salesModule;

    @FindBy(xpath = "//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]")
    public WebElement activitiesModule;

    @FindBy(xpath = "//span[normalize-space()='Marketing' and contains(@class, 'title title-level-1')]")
    public WebElement marketingModule;

    @FindBy(xpath = "//span[normalize-space()='Reports & Segments' and contains(@class, 'title title-level-1')]")
    public WebElement reportsAndSegmentsModule;

    @FindBy(xpath = "//span[normalize-space()='System' and contains(@class, 'title title-level-1')]")
    public WebElement systemModule;

    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement performMessageError;

}

