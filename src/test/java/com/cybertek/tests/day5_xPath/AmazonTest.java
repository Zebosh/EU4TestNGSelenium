package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/gp/aws/cart/add.html?");

         WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
         searchBox.sendKeys("Java");

          driver.findElement(By.xpath("//input[@value='Go']")).click();

          WebElement results=driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
          String resultText= results.getText();

          System.out.println("resultText= "+resultText);
          String expectedResult="1-16 of over 30,000 results for";

          if(expectedResult.equals(resultText)){
              System.out.println("PASS");
          }else{
              System.out.println("FAIL");
          }

          driver.quit();








    }

}
