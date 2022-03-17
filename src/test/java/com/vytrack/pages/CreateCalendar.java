package com.vytrack.pages;

import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.vytrack.utilities.Driver.*;

import java.util.List;

public class CreateCalendar extends BasePage {

    private String titleText;
    private String descriptionText;

    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]")
    public WebElement activitiesLink;

    @FindBy(xpath = "//span[.='Calendar Events']")
    private WebElement calendarEventsOption;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEventLink;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[title]']")
    private WebElement titleInputBox;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement descriptionInputBox;

    @FindBy(xpath = "//iframe[starts-with(@id, 'oro_calendar_event_form_description')]")
    private WebElement iframeDescription;

    @FindBy(xpath = "//div[@class='control-label wrap']/label[@for='recurrence-repeat-view1310']")
    private WebElement repeatCheckBox;

    @FindBy(xpath = "//div[@class='pull-right pinned-dropdown']")
    private WebElement saveAndClose;

    @FindBy(linkText = "General Information")
    private WebElement generalInfoLink;

    @FindBy(xpath = "(//div[@class='responsive-block'])[1]/div/div/div")
    private List<WebElement> generalInfo;

    public void loginAsDriverCredits (){
        VyTrackUtils.loginAsDriver(2);
    }
    public void loginAsSalesManagerCredits (){
        VyTrackUtils.loginAsSalesManager(2);
    }
    public void loginStoreManagerCredits (){
        VyTrackUtils.loginAsStoreManager(2);
    }

    public void navigateToCalendarEventsPage(){
        wait.until(ExpectedConditions.visibilityOf(activitiesLink));
        actions.moveToElement(activitiesLink).perform();
        calendarEventsOption.click();
        wait.until(ExpectedConditions.visibilityOf(createCalendarEventLink));
        createCalendarEventLink.click();
        wait.until(ExpectedConditions.visibilityOf(titleInputBox));
    }
    public void writeDescription(String titleText, String descriptionText){
        this.titleText=titleText;
        this.descriptionText=descriptionText;
        titleInputBox.sendKeys(titleText);
        driver.switchTo().frame(iframeDescription);
        descriptionInputBox.sendKeys(descriptionText);
        driver.switchTo().parentFrame();
    }
    public void saveAndClose(){
        saveAndClose.click();
    }
    public void generalInfoValidation(){
        wait.until(ExpectedConditions.visibilityOf(generalInfoLink));
        Assert.assertTrue(generalInfoLink.isDisplayed());
        for (WebElement each: generalInfo){
            if (each.getText().equals(titleText)){
                Assert.assertEquals(each.getText(),(titleText));
                break;
            }
        }

        for (WebElement each: generalInfo){
            if (each.getText().equals(descriptionText)){
                Assert.assertEquals(each.getText(),(descriptionText));
                break;
            }
        }


    }

}
