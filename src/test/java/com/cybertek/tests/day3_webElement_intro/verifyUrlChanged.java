package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        //Test Case:
        //  Verify URL changed
        // go to http://practice.cybertekschool.com/forgot_password"
        //  enter any email: znarimanova11@cybertek.com
        //  click on retrieve password button
        //  verify that url changed to  http://practice.cybertekschool.com/email_sent


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement emailInputBox= driver.findElement(By.name("email"));
        emailInputBox.sendKeys("znarimanova11@cybertek.com");


       WebElement retrieveButton= driver.findElement(By.id("form_submit"));
       retrieveButton.click();
       String actualUrl = driver.getCurrentUrl();
       String expectedUrl ="http://practice.cybertekschool.com/email_sent";

       if(actualUrl.equals(expectedUrl)){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
        }
       Thread.sleep(5000);
       driver.quit();

       /* Task

        */





    }
}
