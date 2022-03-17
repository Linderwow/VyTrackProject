package com.vytrack.test;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class US_56 extends TestBase {

    @Test
    public void verify_page() {

        VytrackUtils.loginAsSalesManager();
        Driver.getDriver().findElement(By.xpath("//i[@title='Get help']")).click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        String currentTitle = "";
        String expectedTitle = "Welcome to Oro Documentation";
        Iterator var4 = windowHandles.iterator();

        while(var4.hasNext()) {
            String each = (String)var4.next();
            Driver.getDriver().switchTo().window(each);
            if (!Driver.getDriver().getCurrentUrl().contains("qa")) {
                currentTitle = Driver.getDriver().getTitle();
                break;
            }
        }

        Assert.assertEquals(currentTitle, expectedTitle);
    }
    //Project started
    //complited with new requested change


}
