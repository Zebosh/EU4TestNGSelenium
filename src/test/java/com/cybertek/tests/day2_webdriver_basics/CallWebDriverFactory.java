package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {

        WebDriver driver=WebDriverFactory.getDriver("chrome");

        driver.get("https://www.facebook.com");
        
        String title = driver.getTitle();
        System.out.println("title = " + title);
    }
}