package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Checkbox {
    @Test
    public void randomChecker() throws InterruptedException {
        BrowserFactory.getDriver("chrome").get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(2000);
        List<WebElement> checkboxes = BrowserFactory.getDriver("chrome").findElements(By.cssSelector("td input"));
        List<WebElement> labels = BrowserFactory.getDriver("chrome").findElements(By.cssSelector("td label"));
        Random random = new Random();
        int counter = 0;
        while(counter != 3) {
            int rng = random.nextInt(checkboxes.size()-1);
            if(checkboxes.get(rng).isEnabled()){
                if(labels.get(rng).getText().equals("Friday")) {
                    counter++;
                }
                checkboxes.get(rng).click();
                System.out.println(labels.get(rng).getText());
                checkboxes.get(rng).click();
            }
        }
        BrowserFactory.closeDriver();
    }
}
