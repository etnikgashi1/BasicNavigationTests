package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;

public class YearsMonthsDays {
    @Test
    public void CalendarTest() {
        BrowserFactory.getDriver("chrome").get("http://practice.cybertekschool.com/dropdown");
        WebElement days = BrowserFactory.getDriver("chrome").findElement(By.id("day"));
        Select maxDays = new Select(days);
        int currentDays = maxDays.getOptions().size();
        System.out.println("This month has "+currentDays+" days.");

        Random random = new Random();
        WebElement year = BrowserFactory.getDriver("chrome").findElement(By.id("year"));
        Select years = new Select(year);
        years.selectByIndex(random.nextInt(years.getOptions().size()-1));
        int rngYear = Integer.parseInt(years.getFirstSelectedOption().getText());
        System.out.println("The year that we randomly selected is "+years.getFirstSelectedOption().getText());
        boolean leapYear = false;
        if (rngYear % 4 == 0 && ( rngYear % 100 != 0 || rngYear % 400 == 0 ) ) {
            leapYear = true;
            System.out.println("This is a leap year!");
        } else {
            System.out.println("This is not a leap year");
        }
        WebElement month = BrowserFactory.getDriver("chrome").findElement(By.id("month"));
        Select months = new Select(month);

        for(int i = 0; i < months.getOptions().size(); i++) {
            months.selectByIndex(i);
            maxDays = new Select(days);
            int DaysOfThisMonth = maxDays.getOptions().size();
            if(leapYear == true && months.getFirstSelectedOption().getText().equals("February")) {
                System.out.println(months.getFirstSelectedOption().getText()+" has "+DaysOfThisMonth+" days because it's a leap year.");
            }
            if(currentDays == DaysOfThisMonth) {
                System.out.println("PASS: "+months.getFirstSelectedOption().getText()+" has same number of days("+DaysOfThisMonth+") as our current month("+currentDays+").");
            } else {
                System.out.println("FAIL: "+months.getFirstSelectedOption().getText()+" doesn't have same amount of days("+DaysOfThisMonth+") as our current month("+currentDays+").");
            }
        }
    }
}
