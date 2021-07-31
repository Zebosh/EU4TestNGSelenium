package com.cybertek.tests.Review_week_1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class moreXpath {
    @Test

    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.amazon.com");

       String menuName= "Best Sellers";
       String xPathLocator="//div[@id='nav-xshop']//*[.='Best Sellers']";

        WebElement menu= driver.findElement(By.xpath(xPathLocator));
        menu.click();


    }

}
