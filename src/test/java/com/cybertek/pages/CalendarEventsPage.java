package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    // for homework I created this webelement
    @FindBy(xpath = "(//div[@data-toggle='dropdown'])[2]")
    public WebElement optionsButton;

    // for homework I created this webelement
    @FindBy(xpath = "//li/input[@value='1']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[@data-toggle='dropdown']/..")
    public WebElement dropDownElement;

    // for homework I created this webelement
    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> dropDownOptions;

    @FindBy(xpath = "//button/input[@type='checkbox']")
    public WebElement checkbox;

    //for test case 4
    @FindBy(xpath= "//tbody/tr")
    public List<WebElement> rowNums;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement pages;

    @FindBy(xpath = "//ul[@class='icons-holder']/li[3]/a")
    public WebElement nextPageBtn;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement numOfRecords;

    //for test case 6
    @FindBy(css = "a[title='Filters']")
    public WebElement filterButton;

    @FindBy(xpath = "//div[contains(text(),'Title')]")
    public WebElement titleFilter;

    @FindBy(css = "input[name=value]")
    public WebElement titleInputBox;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateButton;

    @FindBy(xpath ="//tbody/tr" )
    public List<WebElement> table;

    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement firstRow;


    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement firstRowTestersMeeting;

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement firsRowtCalendar;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement firstRowStartDate;

    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    public WebElement firstRowEndDate;

    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    public WebElement firstRowRecurrent;

    @FindBy(xpath = "//tbody/tr[1]/td[7]")
    public WebElement firstRowRecurrence;

    @FindBy(xpath = "//tbody/tr[1]/td[8]")
    public WebElement firstRowInStatus;



}
