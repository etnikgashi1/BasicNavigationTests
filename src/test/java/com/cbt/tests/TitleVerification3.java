package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    List<String> urls = Arrays.asList("https://luluandgeorgia.com",
            "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");
    @Test
    public void titleTest() {
        for (int i = 0; i < urls.size(); i++) {
            BrowserFactory.getDriver("chrome").get(urls.get(i));
            String ExpectedTitle = BrowserFactory.getDriver("chrome").getTitle();
            String ActualUrl = BrowserFactory.getDriver("chrome").getCurrentUrl();
            System.out.println("Verifying that \"" + ActualUrl + "\" contains \"" + ExpectedTitle + "\"");
            StringUtility.verifyContainsUrl(ExpectedTitle, ActualUrl);
            BrowserFactory.closeDriver();
        }
    }
}
