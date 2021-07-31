package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {
        /*Test case
open browser
go to http://practice.cybertekschool.com/forgot_password
enter email
verify that email is displayed int the input box
click retrieve password button
verify that confirmation message says "Your e-mail's been sent!"
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedEmail="mike@cybertek.com";
        WebElement emailInputBox= driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);

        String actualEmail = emailInputBox.getAttribute("value");

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

        }

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement actualConfrimationMessage= driver.findElement(By.name("confirmation_message"));
        System.out.println(actualConfrimationMessage.getText());

        String actualMessage=actualConfrimationMessage.getText();

        String expectedMessage="Your e-mail's been sent!";

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }

}
