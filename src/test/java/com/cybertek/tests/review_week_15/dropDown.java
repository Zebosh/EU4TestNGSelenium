package com.cybertek.tests.review_week_15;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dropDown {

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
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropDownElement = driver.findElement(By.name("Languages"));

        Select language=new Select(dropDownElement);

        language.selectByIndex(1);
        System.out.println("language.getFirstSelectedOption().getText() = " + language.getFirstSelectedOption().getText());

        language.selectByIndex(0);
        language.selectByIndex(3);
        language.selectByIndex(4);
        
     // Get all selected options
        List<WebElement> allSelectedOptions = language.getAllSelectedOptions();

        for (WebElement allSelectedOption : allSelectedOptions) {
            System.out.println(allSelectedOption.getText());
        }
        

    }
}
