package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBt.click();
//
//        driver.findElement(By.id("prependedInput")).sendKeys("User1");
//
//        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
//        driver.findElement(By.name("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBt.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }

}
