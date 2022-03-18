package com.vytrack.test;

import com.vytrack.pages.TopMenuNew;

import com.vytrack.utilities.BrowserUtils;

import com.vytrack.utilities.VyTrackUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;


//
public class US_63New extends TestBase{

  TopMenuNew TopMenuNew = new TopMenuNew();

    @Test
    public void testAsSalesManager(){
        VyTrackUtils.loginAsSalesManager();
        VyTrackUtils.waitTillLoaderMaskDisappear();

        //String activitiesTabElementLocator = "//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]";
        WebElement activitiesLink = TopMenuNew.activitiesLink;
        BrowserUtils.hover(activitiesLink);
       
        //calendar Event button

         WebElement calendarEvent = TopMenuNew.activitiesSubCalendar;
        BrowserUtils.sleep(3);
        calendarEvent.click();//
        //Create Calendar Button
       VyTrackUtils.waitTillLoaderMaskDisappear();
        //WebElement createCalendarBtn = getDriver().findElement(By.xpath("//a[@title ='Create Calendar event']"));
        WebElement createCalendarBtn = TopMenuNew.createCalendarBtn;
        createCalendarBtn.click();

        VyTrackUtils.waitTillLoaderMaskDisappear();
        //WebElement repeatBox = getDriver().findElement(By.xpath("(//input[@type ='checkbox'])[2] "));
        WebElement repeatBox =TopMenuNew.repeatBox;
        repeatBox.click();

        BrowserUtils.sleep(2);
        //repeatWindow
        //WebElement RepeatWindow = getDriver().findElement(By.xpath("(//input[@value ='1'])[2]"));
        WebElement repeatWindow =TopMenuNew.repeatWindow;
        repeatWindow.clear();
        BrowserUtils.sleep(2);
        // enter INVALID number ( more than 99)
        repeatWindow.sendKeys("123" + Keys.ENTER);
        BrowserUtils.sleep(2);
        //WebElement warning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be more than 99.'])[2]/span"));
        WebElement warning = TopMenuNew.warning;
        Assert.assertTrue(warning.isDisplayed());

        repeatWindow.clear();
        BrowserUtils.sleep(2);
        //Enter INVALID negative number
        repeatWindow.sendKeys("-54" + Keys.ENTER);
        BrowserUtils.sleep(2);

        //WebElement negativeWarning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be less than 1.'])[2]"));
        WebElement negativeWarning =TopMenuNew.negativeWarning;
        BrowserUtils.sleep(2);

        Assert.assertTrue(negativeWarning.isDisplayed());


    }

}
