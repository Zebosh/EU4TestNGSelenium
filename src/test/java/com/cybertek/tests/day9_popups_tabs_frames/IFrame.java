package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrame {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1. Switch using by name or Id attribute
        driver.switchTo().frame("mce_0_ifr");

        // clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        //goes back to main html
        // goes back to first html, useful when we have multiple frames
        driver.switchTo().defaultContent();


        // 2- way is Switching with index
        Thread.sleep(1000);
        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith WITH INDEX");

        // Switch to parent
        driver.switchTo().parentFrame();


        //3.USING WEBLEMENT

        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith WITH WEBELEMENT");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switch to top frame
        driver.switchTo().frame("frame-top");

        //top frame has 3 frames---> switch to middle one

        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());


        //switch back to top frame
        driver.switchTo().parentFrame();

        //switch to right frame
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

       //go to main html
        driver.switchTo().defaultContent();

        //switch to left frame
      driver.switchTo().frame(1);
      System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
