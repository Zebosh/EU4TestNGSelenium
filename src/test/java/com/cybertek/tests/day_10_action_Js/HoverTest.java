package com.cybertek.tests.day_10_action_Js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions=new Actions(driver);

       actions.moveToElement(img1).perform();

       WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(), "Verify username1 is displayed");

    }


    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {

            String xPathImg = "(//img)[" + i + "]";

            WebElement img = driver.findElement(By.xpath(xPathImg));

            System.out.println(xPathImg);
            Thread.sleep(1000);
            Actions actions=new Actions(driver);

            actions.moveToElement(img).perform();

            String xPathtext="//h5[.='name: user"+ i+"']";

            WebElement text = driver.findElement(By.xpath(xPathtext));
            System.out.println(xPathtext);

            Assert.assertTrue(text.isDisplayed(), "Verify username"+i+" is displayed");

        }

//

//

    }
}
