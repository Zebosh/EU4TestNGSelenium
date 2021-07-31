package com.cybertek.tests.day_10_action_Js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass {

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
    public void hoverTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions---> class that contains all user interactions
        //how  to create actions object--> passing a driver to constructor
        Actions action=new Actions(driver);

        Thread.sleep(2000);
        action.moveToElement(img1).perform();

        WebElement viewLink= driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(),"Verify that view link is displayed");

    }

    @Test

    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions action=new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("draggable"));

        driver.findElement(By.xpath("//*[.='Accept and Close']"));

        Thread.sleep(2000);
       action.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }
}
