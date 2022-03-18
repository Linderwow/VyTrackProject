package com.vytrack.test;

import com.vytrack.pages.Accounts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class US_66 extends TB_US_65_66 {
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TB_US_65_66.class,priority = 1)
    public void AC1_OdoCheckStoreManager(String username,String password) {
        loginToAccount(username,password);
        Accounts accounts=new Accounts();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.customersLink));
        action.moveToElement(TopMenu.customersLink).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.customersSubAccounts));
        TopMenu.customersSubAccounts.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(accounts.filters));
        accounts.filters.click();
        List<WebElement>filterBtn=new ArrayList<>(accounts.allFilters);
        List<String> actualBtnTexts=new ArrayList<>();
        List<String>expected=new ArrayList<>(Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone","Owner","Business Unit","Created At","Updated At"));
        actualBtnTexts=filterBtn.stream().map(p->p.getText().substring(0,p.getText().length()-5)).collect(Collectors.toList());
        Assert.assertEquals(actualBtnTexts,expected);
    }
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TB_US_65_66.class,priority = 2)
    public void AC1_OdoCheckSalesManager(String username,String password) {
        loginToAccount(username,password);
        Accounts accounts=new Accounts();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.customersLink));
        action.moveToElement(TopMenu.customersLink).perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(TopMenu.customersSubAccounts));
        TopMenu.customersSubAccounts.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(accounts.filters));
        accounts.filters.click();
        List<WebElement>filterBtn=new ArrayList<>(accounts.allFilters);
        List<String> actualBtnTexts=new ArrayList<>();
        List<String>expected=new ArrayList<>(Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone","Owner","Business Unit","Created At","Updated At"));
        actualBtnTexts=filterBtn.stream().limit(8).map(p->p.getText().substring(0,p.getText().length()-5)).collect(Collectors.toList());
        Assert.assertEquals(actualBtnTexts,expected);
    }
}

