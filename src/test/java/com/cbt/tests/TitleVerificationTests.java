package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
            "http://practice.cybertekschool.com/dropdown",
            "http://practice.cybertekschool.com/login");

    @Test
    public void titleVerification() {
        String expectedUrl = "http://practice.cybertekschool.com/";
        String expectedTitle = "";
        for(int i = 0; i < urls.size(); i++) {
            BrowserFactory.getDriver("chrome").get(urls.get(i));
            System.out.println("Verifying that page \""+BrowserFactory.getDriver("chrome").getCurrentUrl()+"\" starts with \""+expectedUrl+"\"");
            StringUtility.verifyStartsWith(expectedUrl, BrowserFactory.getDriver("chrome").getCurrentUrl());
            if(i == 0) {
                expectedTitle = BrowserFactory.getDriver("chrome").getTitle();
            }
            System.out.println("Verifying that title \""+BrowserFactory.getDriver("chrome").getTitle()+"\" is equal to \""+expectedTitle+"\"");
            StringUtility.verifyEquals(expectedTitle, BrowserFactory.getDriver("chrome").getTitle());
        }
    }
}
