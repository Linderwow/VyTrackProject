package com.vytrack.test;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.vytrack.utilities.Driver.getDriver;

public class US_63 extends TestBase {

//
          @Test
        public void testAsSalesManager(){
        VyTrackUtils.loginAsSalesManager();

              String activitiesTabElementLocator = "//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]";

              WebElement activitiesTabElement = Driver.getDriver().findElement(By.xpath(activitiesTabElementLocator));
              Actions actions = new Actions(Driver.getDriver());
              //activities Btn
              actions.moveToElement(activitiesTabElement).perform();
              BrowserUtils.sleep(3);
              //calendar Event button

              WebElement calendarEventBTN = Driver.getDriver().findElement(By.xpath("//span[text()='Calendar Events']"));

              BrowserUtils.sleep(3);
              calendarEventBTN.click();
              //Create Calendar Button
              BrowserUtils.sleep(4);
              WebElement createCalendarBtn = getDriver().findElement(By.xpath("//a[@title ='Create Calendar event']"));
              createCalendarBtn.click();

              BrowserUtils.sleep(4);
              WebElement repeatBox = getDriver().findElement(By.xpath("(//input[@type ='checkbox'])[2] "));
              repeatBox.click();

              BrowserUtils.sleep(2);
              // WebElement repeatEvery = getDriver().findElement(By.xpath("(//input[@type ='radio'])[1]"));
              //repeatEvery.click();

              BrowserUtils.sleep(2);
              WebElement RepeatWindow = getDriver().findElement(By.xpath("(//input[@value ='1'])[2]"));
              // enter INVALID number (negative or more than 99)

              RepeatWindow.clear();
              BrowserUtils.sleep(2);
              RepeatWindow.sendKeys("123" + Keys.ENTER);
              BrowserUtils.sleep(2);
              WebElement warning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be more than 99.'])[2]/span"));
              Assert.assertTrue(warning.isDisplayed());

              RepeatWindow.clear();
              BrowserUtils.sleep(2);

              RepeatWindow.sendKeys("-54" + Keys.ENTER);
              BrowserUtils.sleep(2);

              WebElement negativeWarning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be less than 1.'])[2]"));
              BrowserUtils.sleep(2);

              Assert.assertTrue(negativeWarning.isDisplayed());


          }


    @Test
    public void testAsDriver(){
        VyTrackUtils.loginAsDriver();
        String activitiesTabElementLocator = "//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]";

        WebElement activitiesTabElement = Driver.getDriver().findElement(By.xpath(activitiesTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        //activities Btn
        actions.moveToElement(activitiesTabElement).perform();
        BrowserUtils.sleep(3);
        //calendar Event button

        WebElement calendarEventBTN = Driver.getDriver().findElement(By.xpath("//span[text()='Calendar Events']"));

        BrowserUtils.sleep(3);
        calendarEventBTN.click();
        //Create Calendar Button
        BrowserUtils.sleep(2);
        WebElement createCalendarBtn = getDriver().findElement(By.xpath("//a[@title ='Create Calendar event']"));
        createCalendarBtn.click();

        BrowserUtils.sleep(2);
        WebElement repeatBox = getDriver().findElement(By.xpath("(//input[@type ='checkbox'])[2] "));
        repeatBox.click();

        BrowserUtils.sleep(2);
        // WebElement repeatEvery = getDriver().findElement(By.xpath("(//input[@type ='radio'])[1]"));
        //repeatEvery.click();

        BrowserUtils.sleep(2);
        WebElement RepeatWindow = getDriver().findElement(By.xpath("(//input[@value ='1'])[2]"));
        // enter INVALID number (negative or more than 99)

        RepeatWindow.clear();
        BrowserUtils.sleep(2);
        RepeatWindow.sendKeys("123" + Keys.ENTER);
        BrowserUtils.sleep(2);
        WebElement warning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be more than 99.'])[2]/span"));
        Assert.assertTrue(warning.isDisplayed());

        RepeatWindow.clear();
        BrowserUtils.sleep(2);

        RepeatWindow.sendKeys("-54" + Keys.ENTER);
        BrowserUtils.sleep(2);

        WebElement negativeWarning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be less than 1.'])[2]"));
        BrowserUtils.sleep(2);

        Assert.assertTrue(negativeWarning.isDisplayed());


    }


    @Test
    public void testAsStoreManager(){
        VyTrackUtils.loginAsStoreManager();
        String activitiesTabElementLocator = "//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]";

        WebElement activitiesTabElement = Driver.getDriver().findElement(By.xpath(activitiesTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        //activities Btn
        actions.moveToElement(activitiesTabElement).perform();
        BrowserUtils.sleep(3);
        //calendar Event button

        WebElement calendarEventBTN = Driver.getDriver().findElement(By.xpath("//span[text()='Calendar Events']"));

        BrowserUtils.sleep(3);
        calendarEventBTN.click();
        //Create Calendar Button
        BrowserUtils.sleep(2);
        WebElement createCalendarBtn = getDriver().findElement(By.xpath("//a[@title ='Create Calendar event']"));
        createCalendarBtn.click();

        BrowserUtils.sleep(2);
        WebElement repeatBox = getDriver().findElement(By.xpath("(//input[@type ='checkbox'])[2] "));
        repeatBox.click();

        BrowserUtils.sleep(2);
        // WebElement repeatEvery = getDriver().findElement(By.xpath("(//input[@type ='radio'])[1]"));
        //repeatEvery.click();

        BrowserUtils.sleep(2);
        WebElement RepeatWindow = getDriver().findElement(By.xpath("(//input[@value ='1'])[2]"));
        // enter INVALID number (negative or more than 99)

        RepeatWindow.clear();
        BrowserUtils.sleep(2);
        RepeatWindow.sendKeys("123" + Keys.ENTER);
        BrowserUtils.sleep(2);
        WebElement warning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be more than 99.'])[2]/span"));
        Assert.assertTrue(warning.isDisplayed());

        RepeatWindow.clear();
        BrowserUtils.sleep(2);

        RepeatWindow.sendKeys("-54" + Keys.ENTER);
        BrowserUtils.sleep(2);

        WebElement negativeWarning = getDriver().findElement(By.xpath("(//span[* ='The value have not to be less than 1.'])[2]"));
        BrowserUtils.sleep(2);

        Assert.assertTrue(negativeWarning.isDisplayed());


    }


}