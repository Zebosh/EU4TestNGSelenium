package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        // to maximize the window
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement inputFullName= driver.findElement(By.tagName("input"));
        inputFullName.sendKeys("Mike Smith with Tag name");

        WebElement email=driver.findElement(By.name("email"));
         email.sendKeys("znariman_10@gmail.com");


        WebElement signUp=driver.findElement(By.tagName("button"));
        signUp.click();

        Thread.sleep(5000);

        driver.quit();
    }

}
