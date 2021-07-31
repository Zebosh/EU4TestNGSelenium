package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

       // go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

       // save expected url
        String expectedUrl =  driver.getCurrentUrl();

        //Click on Retrieve password
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actualUrl=driver.getCurrentUrl();

        //verify that url did not change
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    // CLOSE BROWSER
        driver.quit();



    }
}
