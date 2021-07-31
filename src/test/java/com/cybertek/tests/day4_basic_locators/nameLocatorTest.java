package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput= driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

       // WebElement email=driver.findElement(By.name("email"));
       // email.sendKeys("znariman_10@gmail.com");

        // lazy way
        driver.findElement(By.name("email")).sendKeys("znariman_10@gmail.com");

       // WebElement signUpButton=driver.findElement(By.name("wooden_spoon"));
       // signUpButton.click();

        //lazy way
       driver.findElement(By.name("wooden_spoon")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
