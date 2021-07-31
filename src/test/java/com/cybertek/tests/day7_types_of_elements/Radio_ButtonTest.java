package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio_ButtonTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons

        WebElement blueRadioButton=driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton=driver.findElement(By.id("red"));

        System.out.println("blueRadioButton "+blueRadioButton.isSelected());
        System.out.println("redRadioButton "+redRadioButton.isSelected());

        redRadioButton.click();

        // Verify blue is not selected, red is not selected
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue is selected");
        // Verify that  red is not selected
        Assert.assertTrue(redRadioButton.isSelected(),"Verify that red button is not selected");

        driver.quit();

    }
}
