package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonDepartments {
    @Test
    public void departmentsTest() {
        BrowserFactory.getDriver("chrome").get("https://www.amazon.com/");
        WebElement selectDept = BrowserFactory.getDriver("chrome").findElement(By.xpath("//select"));
        Select departments = new Select(selectDept);

        List<WebElement> options = departments.getOptions();

        for (int i = 1; i < options.size()-1; i++) {
            String current = options.get(i).getText();
            String next = options.get(i+1).getText();
            System.out.println("Comparing: " + current + " " + next);
            if(current.compareTo(next) < 0) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        }
    }
}
