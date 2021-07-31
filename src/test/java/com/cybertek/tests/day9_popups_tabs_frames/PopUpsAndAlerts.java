package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {
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
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//button[.='No']")).click();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //button 1
        driver.findElement(By.xpath("//button[1]")).click();

        Alert alert=driver.switchTo().alert();

        Thread.sleep(2000);

        alert.accept();
       //button 2
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        // button 3

        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("zebo");
        alert.accept();



    }
}
