package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink= driver.findElement(By.className("nav-link"));
        homeLink.click();

        Thread.sleep(3000);

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //to print header
        String h3 = driver.findElement(By.className("h3")).getText();
        System.out.println(h3);


        driver.quit();

    }
}
