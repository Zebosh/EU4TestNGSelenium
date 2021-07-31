package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy (id="prependedInput")
    public WebElement usernameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(name="_submit")
    public WebElement loginBt;


      public void login(String username,String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBt.click();
}
    public void loginasStoremanager(){
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBt.click();
    }


    public void loginasDriver(){
        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBt.click();
    }

//    public void loginasSalesManager(){
//        String username= ConfigurationReader.get("salesmanager_username");
//        String password= ConfigurationReader.get("salesmanager_password");
//
//        usernameInput.sendKeys(username);
//        passwordInput.sendKeys(password);
//        loginBt.click();
//    }
}

