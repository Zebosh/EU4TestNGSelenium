package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class muzaPractice {
    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox= driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        System.out.println("checkBox.isEnabled() = " + checkBox.isEnabled());
        Assert.assertTrue(checkBox.isSelected(),"Verify that checkbox is selected");
        Assert.assertFalse(checkBox.isSelected());


    }
}
