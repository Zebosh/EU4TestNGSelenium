package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitandClose {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.navigate().to("http://practice.cybertekschool.com");

        Thread.sleep(3000);

        driver.close(); //close the browser

        driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

        driver.close();

        driver.quit();
    }
}
