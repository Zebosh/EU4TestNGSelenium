package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        System.out.println(blueRadioButton.getAttribute("name"));
        System.out.println(blueRadioButton.getAttribute("type"));
        System.out.println(blueRadioButton.getAttribute("checked"));

        // get attribute of the non existent item
        System.out.println(blueRadioButton.getAttribute("href"));
        System.out.println(blueRadioButton.getAttribute("outerHTML"));


        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));
        String outerHTMl= button2.getAttribute("outerHTML");

        Assert.assertTrue(outerHTMl.contains("Button 2"));
        System.out.println(button2.getAttribute("innerHTML"));

        driver.quit();
    }
}
