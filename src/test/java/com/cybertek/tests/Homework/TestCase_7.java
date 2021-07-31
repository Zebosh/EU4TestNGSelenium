package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_7 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void test7(){
        /*Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “File Upload".
        Step 3. Upload any file with .txt extension from your computer.Step
        4. Click “Upload” button.
        5. Verify that subject is: “File Uploaded!”
        6. Verify that uploaded file name is displayed.
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.partialLinkText("File Upload")).click();

        WebElement chooseFileButton = driver.findElement(By.name("file"));

        chooseFileButton.sendKeys("/Users/muzaffarruzmetov/Desktop/sample1.txt");

        driver.findElement(By.className("button")).click();

        String expectedText="File Uploaded!";

        String  actualText = driver.findElement(By.cssSelector("#content>div>h3")).getText();

        Assert.assertEquals(actualText, expectedText,"Verify that subject is: “File Uploaded!” ");

         WebElement fileName = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(fileName.isDisplayed(),"Verify that uploaded file name is displayed");


    }
}
