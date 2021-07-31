package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropDownElement=driver.findElement(By.id("state"));

        Select stateDropDown=new Select(dropDownElement);
        List<WebElement> options = stateDropDown.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select stateDropDown=new Select(dropDownElement);
        //Verify the first element is 'Select a state'
        String expectedOption="Select a State";
        String actualOption = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify first selection");
        Thread.sleep(3000);

      //1. How to select an option from drop down
        stateDropDown.selectByVisibleText("Virginia");

        expectedOption="Virginia";
        actualOption=stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

    // 2. How to select by index number;

        Thread.sleep(2000);
        stateDropDown.selectByIndex(51);

        actualOption="Wyoming";
        expectedOption=stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify selected option");

        //Select using value;
        stateDropDown.selectByValue("TX");
        Thread.sleep(2000);

        actualOption="Texas";
        expectedOption=stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify selected option");

    }
}
