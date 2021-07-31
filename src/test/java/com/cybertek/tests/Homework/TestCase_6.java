package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_6 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test6(){
        driver.get("https://www.tempmailaddress.com/");

        String email = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.partialLinkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Mike Smith");

        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.xpath("//*[.='Sign Up']")).click();

        WebElement subheader = driver.findElement(By.className("subheader"));

        Assert.assertTrue(subheader.isDisplayed(),"Verify the message is displayed");
    }
}
