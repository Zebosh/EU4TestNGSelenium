package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class day_10_TestScripts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
       driver.get( "https://practice-cybertekschool.herokuapp.com");
       driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        WebElement inputBox=driver.findElement(By.name("birthday"));
        inputBox.sendKeys("wrong_dob");

        WebElement notValid=driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));


        Assert.assertTrue(notValid.isDisplayed(),"Verify that warning message is displayed");


    }

    @Test
    public void test2(){

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        WebElement checkBox1=driver.findElement(By.xpath("//label[.='C++']"));
        WebElement checkBox2=driver.findElement(By.xpath("//label[.='Java']"));
        WebElement checkBox3=driver.findElement(By.xpath("//label[.='JavaScript']"));

        Assert.assertTrue(checkBox1.isDisplayed());
        Assert.assertTrue(checkBox2.isDisplayed());
        Assert.assertTrue(checkBox3.isDisplayed());

    }


    @Test
    public void test3 (){

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("firstname")).sendKeys("A");

        WebElement warningMessage= driver.findElement(By.xpath("(//small[contains(text(),'more than 2')])[1]"));
        System.out.println(warningMessage.getText());

        Assert.assertTrue(warningMessage.isDisplayed(),"Verify that warning message is displayed");

    }

    @Test
    public void test4 () {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("lastname")).sendKeys("B");

        WebElement warningMessage= driver.findElement(By.xpath("(//small[contains(text(),'more than 2')])[2]"));

        Assert.assertTrue(warningMessage.isDisplayed(),"Verify that warning message is displayed");

    }
    @Test
    public void test5 () {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
         //Firstname
        driver.findElement(By.name("firstname")).sendKeys("Mark");

        //Lastname
        driver.findElement(By.name("lastname")).sendKeys("Twain");

        //Username
        driver.findElement(By.name("username")).sendKeys("writer");

        //Email
        driver.findElement(By.name("email")).sendKeys("markt@gmail.com");

        //Password
        driver.findElement(By.name("password")).sendKeys("123456789");

        //Phone number
        driver.findElement(By.name("phone")).sendKeys("444-111-2222");

        //Gender
        driver.findElement(By.cssSelector("[value='male']")).click();

        //Birthday
        driver.findElement(By.name("birthday")).sendKeys("12/12/1912");


        // Department
        WebElement dropDownElement=driver.findElement(By.name("department"));

        Select departmentDropDown=new Select(dropDownElement);

        List<WebElement> options=departmentDropDown.getOptions();
        System.out.println("options.size() = " + options.size());

       options.get(2).click();


       //Job Title
        WebElement dDownElement=driver.findElement(By.name("job_title"));
        Select jobDropDown=new Select(dropDownElement);

        List<WebElement> choice=departmentDropDown.getOptions();
        System.out.println("choice.size() = " + choice.size());

       choice.get(5).click();


       //Language CheckBox

        WebElement languageCheckBox=driver.findElement(By.xpath("//label[.='Java']"));
        languageCheckBox.click();

        // SignUp
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify
        WebElement element = driver.findElement(By.cssSelector("#content>div>div>p"));

        Assert.assertTrue(element.isDisplayed(),"You've successfully completed registration!");






    }

}
