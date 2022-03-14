package com.vytrack.test;

import com.vytrack.pages.CreateCalendar;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class US_64 extends TestBase{
    CreateCalendar createCalendar = new CreateCalendar();



    @Test
    public void createCalendarEventWithDriverCredits(){
        getDriver().get(getProperty("env2"));
        createCalendar.loginAsDriverCredits();
        createCalendar.navigateToCalendarEventsPage();
        createCalendar.writeDescription("Test with Driver options","demo comment for Driver");
        createCalendar.saveAndClose();
        createCalendar.generalInfoValidation();

    }

    @Test
    public void createCalendarEventWithSalesManagerCredits(){
        getDriver().get(getProperty("env2"));
        createCalendar.loginAsSalesManagerCredits();
        createCalendar.navigateToCalendarEventsPage();
        createCalendar.writeDescription("Test with Sales Manager options","demo comment for Sales Manager");
        createCalendar.saveAndClose();
        createCalendar.generalInfoValidation();
    }

    @Test
    public void createCalendarEventWithStoreManagerCredits(){
        getDriver().get(getProperty("env2"));
        createCalendar.loginStoreManagerCredits();
        createCalendar.navigateToCalendarEventsPage();
        createCalendar.writeDescription("Test with Store Manager options","demo comment for Store Manager");
        createCalendar.saveAndClose();
        createCalendar.generalInfoValidation();
    }

}
