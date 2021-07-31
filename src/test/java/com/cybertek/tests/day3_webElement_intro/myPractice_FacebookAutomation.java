package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myPractice_FacebookAutomation {

    public static void main(String[] args) throws InterruptedException {

        /*My first Test Case
        1. Open browser
        2. open facebook login page: https://cybertekschool.okta.com/
        3.Enter email and password
        4.Verify that email is displayed in the input box
        5.Click login button
        6.Close the browser
        */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://cybertekschool.okta.com/");

        String expectedEmail="znarimanova11@gmail.com";
        WebElement emailInputBox= driver.findElement(By.id("okta-signin-username"));
        emailInputBox.sendKeys(expectedEmail);

        String actualEmail = emailInputBox.getAttribute("value");
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        WebElement passwordInputBox=driver.findElement(By.id("okta-signin-password"));
        passwordInputBox.sendKeys("2115033Muzaffar");

        WebElement loginButton=driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        Thread.sleep(3000);

        driver.quit();



    }
}
