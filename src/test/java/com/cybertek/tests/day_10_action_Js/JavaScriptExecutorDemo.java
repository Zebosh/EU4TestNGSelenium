package com.cybertek.tests.day_10_action_Js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {

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
    public void clickwithJS(){

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink=driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()", dropDownLink);
    }

    @Test
    public void typewithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement element = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        String text="Hello Disabled Input";

        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')",element);

    }

    @Test
    public void scrollUpAndDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

    }

    @Test
    public void amazon() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.name("accept")).click();

        WebElement element = driver.findElement(By.xpath("//*[.='GBP - Pounds']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,250)");

      //  jse.executeScript("arguments[0].scrollIntoView(true)",element);

    }

}
