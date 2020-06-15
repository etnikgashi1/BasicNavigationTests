package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class NavigationTests {
    @Test
    public void testFirefox() {
        BrowserFactory.getDriver("firefox").get("https://google.com/");
        String titleGoogle = BrowserFactory.getDriver("firefox").getTitle();
        BrowserFactory.getDriver("firefox").get("https://etsy.com/");
        String titleEtsy = BrowserFactory.getDriver("firefox").getTitle();
        BrowserFactory.getDriver("firefox").navigate().back();
        StringUtility.verifyEquals(titleGoogle,BrowserFactory.getDriver("firefox").getTitle());
        BrowserFactory.getDriver("firefox").navigate().forward();
        StringUtility.verifyEquals(titleEtsy,BrowserFactory.getDriver("firefox").getTitle());
    }
    @Test
    public void testChrome() {
        BrowserFactory.getDriver("chrome").get("https://google.com/");
        String titleGoogle = BrowserFactory.getDriver("chrome").getTitle();
        BrowserFactory.getDriver("chrome").get("https://etsy.com/");
        String titleEtsy = BrowserFactory.getDriver("firefox").getTitle();
        BrowserFactory.getDriver("chrome").navigate().back();
        StringUtility.verifyEquals(titleGoogle,BrowserFactory.getDriver("chrome").getTitle());
        BrowserFactory.getDriver("chrome").navigate().forward();
        StringUtility.verifyEquals(titleEtsy,BrowserFactory.getDriver("chrome").getTitle());
    }
    @Test
    public void testEdge() {
        BrowserFactory.getDriver("edge").get("https://google.com/");
        String titleGoogle = BrowserFactory.getDriver("chrome").getTitle();
        BrowserFactory.getDriver("edge").get("https://etsy.com/");
        String titleEtsy = BrowserFactory.getDriver("edge").getTitle();
        BrowserFactory.getDriver("edge").navigate().back();
        StringUtility.verifyEquals(titleGoogle,BrowserFactory.getDriver("edge").getTitle());
        BrowserFactory.getDriver("edge").navigate().forward();
        StringUtility.verifyEquals(titleEtsy,BrowserFactory.getDriver("edge").getTitle());
    }
    @AfterMethod
    public void tearDown() {
        BrowserFactory.closeDriver();
    }
}
