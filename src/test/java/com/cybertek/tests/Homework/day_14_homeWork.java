package com.cybertek.tests.Homework;

import com.aventstack.extentreports.ExtentTest;
import com.cybertek.pages.ContactsInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day_14_homeWork  extends TestBase {

    /*Test Case
      open the chrome
      go to qa1.vytrack
      login as a sales manager
      navigate to customers ->contacts
      click on email mbrackstone9@example.com
      verify that full name is Mariam Brackstone
      verify that email is mbrackstone9@example.com
      verify that phone number is +18982323434

     */

    @Test
    public void verifyContactInfo(){

       extentLogger=report.createTest("Contact info verification");

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("salesmanager_username");
        String password= ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username"+username);
        extentLogger.info("password"+password);
        loginPage.login(username, password);

        extentLogger.info("Navigate to_> Customers-> Contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage=new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click to mbrackstone9@example.com");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();


        ContactsInfoPage contactsInfoPage=new ContactsInfoPage();

        extentLogger.info("Verify full name is:Mariam Brackstone");
        Assert.assertEquals(contactsInfoPage.fullName.getText(),"Mariam Brackstone","Verify the name");

        extentLogger.info("Verify email is :Mmbrackstone9@example.com\"");
        Assert.assertEquals(contactsInfoPage.Email.getText(),"mbrackstone9@example.com","Verify the email");

        extentLogger.info("Verify phone number is:+18982323434");
        Assert.assertEquals(contactsInfoPage.phone.getText(),"+18982323434","Verify the phone");

        extentLogger.pass("PASSED");

    }
}
