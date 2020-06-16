package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonHeaders {
    @Test
    public void TestingHeaders() {
        BrowserFactory.getDriver("chrome").get("https://www.amazon.com/gp/site-directory");
        WebElement selectDept = BrowserFactory.getDriver("chrome").findElement(By.xpath("//select"));
        Select departments = new Select(selectDept);

        List<WebElement> options = departments.getOptions();
        List<String> optionsText = new ArrayList<>();

        for (WebElement option : options) {
            optionsText.add(option.getText());
        }
        List<WebElement> headers = BrowserFactory.getDriver("chrome").findElements(By.className("fsdDeptTitle"));

        for (WebElement header : headers) {
            String headerText = header.getText();
            if (optionsText.contains(headerText)) {
                System.out.println("PASS: Found "+headerText+" on categories.");
            } else {
                System.out.println("FAIL: Couldn't find "+headerText+" on categories.");

            }
        }
    }
}
