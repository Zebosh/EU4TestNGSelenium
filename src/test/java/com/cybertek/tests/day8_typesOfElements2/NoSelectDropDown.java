package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

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
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click the dropdown to see the available options
        dropDownElement.click();
        List<WebElement>dropDownOptions=driver.findElements(By.className("dropdown-item"));

        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());

        for (WebElement dropDownOption : dropDownOptions) {
            System.out.println(dropDownOption.getText());
        }

        dropDownOptions.get(2).click();


    }
}
