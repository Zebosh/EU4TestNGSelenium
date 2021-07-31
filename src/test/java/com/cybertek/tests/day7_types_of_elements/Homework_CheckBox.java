package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_CheckBox {

    @Test
    public void test1() throws InterruptedException {
    // : SeleniumEasy Checkbox Verification – Section 1

        /*1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Success – Check box is checked” message is NOT displayed.
        4.Click to checkbox under “Single Checkbox Demo” section
        5.Verify “Success – Check box is checked” message is displayed.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBoxMessage=driver.findElement(By.id("txtAge"));

        Assert.assertFalse( checkBoxMessage.isDisplayed(), "verify that message is not displayed");

        driver.findElement(By.id("isAgeSelected")).click();

        Assert.assertTrue(checkBoxMessage.isDisplayed());

        Thread.sleep(3000);

        driver.quit();
    }


    @Test
    public void test2(){
        /*SeleniumEasy Checkbox Verification –Section 2
        1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Check All” button text is “Check All”
        4.Click to “Check All” button
        5.Verify all check boxes are checked
        6.Verify button text changed to “Uncheck All”
 */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllButton= driver.findElement(By.id("check1"));

        String checkAll= checkAllButton.getAttribute("value");
        //System.out.println(checkAll);
       Assert.assertTrue(checkAll.equals("Check All"));

       checkAllButton.click();

      WebElement checkBox1= driver.findElement(By.xpath("(//div[@class='panel-body'])[3]/div[1]"));
      WebElement checkBox2= driver.findElement(By.xpath("(//div[@class='panel-body'])[3]/div[2]"));
      WebElement checkBox3= driver.findElement(By.xpath("(//div[@class='panel-body'])[3]/div[3]"));
      WebElement checkBox4= driver.findElement(By.xpath("(//div[@class='panel-body'])[3]/div[4]"));

      Assert.assertTrue(checkBox1.isSelected());
      Assert.assertTrue(checkBox2.isSelected());
      Assert.assertTrue(checkBox3.isSelected());
      Assert.assertTrue(checkBox4.isSelected());

      Assert.assertTrue(checkAllButton.getAttribute("value").equals("Unchek All"));

      driver.quit();



    }
}
