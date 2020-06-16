package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LinkTest {
    @Test
    public void Links() {
        BrowserFactory.getDriver("chrome").get("https://www.w3schools.com/");
        List<WebElement> links = BrowserFactory.getDriver("chrome").findElements(By.tagName("a"));
        for (WebElement link : links) {
            if (link.isDisplayed()) {
                System.out.println(link.getText()+" with link "+link.getAttribute("href"));
            }
        }
    }
    @Test
    public void valid_links() {
        BrowserFactory.getDriver("chrome").get("https://www.selenium.dev/documentation/en/");
        List<WebElement> links = BrowserFactory.getDriver("chrome").findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            String href = links.get(i).getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                Assert.assertEquals(httpURLConnection.getResponseCode(), 200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
