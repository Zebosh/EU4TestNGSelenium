package com.cybertek.tests.day_14_extentReports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //name of teh test
        extentLogger=report.createTest("Wrong password test");

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBt.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password test is passed");
    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter username:someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter Password:UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginBt.click();

        extentLogger.info("Verify page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Username test is passed");


    }

}
