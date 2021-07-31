package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_9_10_11_12 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test(dataProvider = "tests")
    public void test9(String value){

        /*Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “200”.
        Step 4. Verify that following message is displayed:“This page returned a 200 status code”
        Verify that following message is displayed: “This page returned a 301 status code”
        Verify that following message is displayed: “This page returned a 404 status code”
        Verify that following message is displayed: “This page returned a 500 status code”
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Status Codes")).click();

        WebElement stCodes = driver.findElement(By.linkText(value));

        System.out.println(stCodes.getText());

        Assert.assertTrue(stCodes.isDisplayed(),"Verify the message is displayed:");


    }
    @DataProvider(name="tests")
    public Object[][] statusCodes(){
        return new Object[][]{{"200"},{"301"},{"404"},{"500"}};

    }

}
