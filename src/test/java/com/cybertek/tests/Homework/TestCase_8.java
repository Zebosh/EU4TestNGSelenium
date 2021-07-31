package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_8 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void test8(){
        /*Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Autocomplete”.
        Step 3. Enter “United States of America” into country input box.
        Step 4. Verify that following message is displayed: “You selected: United States of America”

         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.xpath("//*[@onclick='log()']")).click();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed(),"Verify that following message is displayed");


    }

}
