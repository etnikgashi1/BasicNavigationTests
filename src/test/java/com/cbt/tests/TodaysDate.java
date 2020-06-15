package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    @Test
    public void dateTest() {
        BrowserFactory.getDriver("chrome").get("http://practice.cybertekschool.com/dropdown");
        WebElement year = BrowserFactory.getDriver("chrome").findElement(By.id("year"));
        Select years = new Select(year);
        WebElement month = BrowserFactory.getDriver("chrome").findElement(By.id("month"));
        Select months = new Select(month);
        WebElement day = BrowserFactory.getDriver("chrome").findElement(By.id("day"));
        Select days = new Select(day);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MMMM/dd");
        LocalDateTime now = LocalDateTime.now();
        StringUtility.verifyEquals(dtf.format(now), years.getFirstSelectedOption().getText()+"/"+months.getFirstSelectedOption().getText()+"/"+days.getFirstSelectedOption().getText());
    }
}
