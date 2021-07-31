package com.cybertek.tests.Homework;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Vytrack_HW1 extends TestBase {


    /*1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Verify that page subtitle "Options" is displayed

     */
    @Test
    public void test1(){
        LoginPage loginPage= new LoginPage();
        loginPage.loginasStoremanager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        BrowserUtils.waitFor(3);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        String actualResult = calendarEventsPage.optionsButton.getText();

        Assert.assertEquals(actualResult, "Options","Verify page subtitle");

    }

   @Test
    public void test2(){
       /*1.Go to “https://qa1.vytrack.com/"
       2.Login as a store manager
       3.Navigate to “Activities -> Calendar Events”
       4.Verify that page number is equals to "1"

        */
       LoginPage loginPage= new LoginPage();

       loginPage.loginasStoremanager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        BrowserUtils.waitFor(3);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        String actualPageNum = calendarEventsPage.pageNumber.getAttribute("value");

        System.out.println(actualPageNum);

      Assert.assertEquals(actualPageNum, "1", "Verify page number is equal to 1");
   }


   @Test
   //not sure about this test case
    public void test3(){

        LoginPage loginPage=new LoginPage();
        loginPage.loginasStoremanager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

       for (WebElement option :  calendarEventsPage.dropDownOptions) {
           if(option.equals("25")){

               Assert.assertTrue( option.isSelected());
           }
       }

   }
   @Test
public void test4(){
        /*
        Go to “https://qa1.vytrack.com/"
        2.Login as a store manager
        3.Navigate to “Activities -> Calendar Events”
        4.Verify that number of calendar events (rows in the table) is equals to number of records
         */
       LoginPage loginPage=new LoginPage();

       loginPage.loginasStoremanager();
       BrowserUtils.waitFor(3);

       DashboardPage dashboardPage=new DashboardPage();

       dashboardPage.navigateToModule("Activities","Calendar Events");

       dashboardPage.waitUntilLoaderScreenDisappear();

       CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

       BrowserUtils.waitForClickablility(calendarEventsPage.dropDownElement,15);

       calendarEventsPage.dropDownElement.click();

       BrowserUtils.waitForPageToLoad(5);

       calendarEventsPage.dropDownOptions.get(3).click();
     //  System.out.println(calendarEventsPage.dropDownOptions.size());

      calendarEventsPage.waitUntilLoaderScreenDisappear();

     System.out.println(calendarEventsPage.rowNums.size());
       int numOfPages = Integer.parseInt(calendarEventsPage.pages.getText().split(" ")[1]);

       int actualNumOfRecords=0;

       for (int i = 1; i <= numOfPages; i++) {
           BrowserUtils.waitFor(1);
           calendarEventsPage.waitUntilLoaderScreenDisappear();

           BrowserUtils.waitForClickablility(calendarEventsPage.nextPageBtn,10);

           actualNumOfRecords+= calendarEventsPage.rowNums.size();

           calendarEventsPage.nextPageBtn.click();
       }
       System.out.println(actualNumOfRecords);

       int expectedNumOfRecords=Integer.parseInt(calendarEventsPage.numOfRecords.getText().split(" ")[2]);

       Assert.assertEquals(actualNumOfRecords, expectedNumOfRecords,"verify correct number of records in the table");



   }

    @Test
    public void test5(){
        /*

       Go to “https://qa1.vytrack.com/"
       2.Login as a store manager
       3.Navigate to “Activities -> Calendar Events”
       4.Click on the top checkbox to select all
       5.Verify that all calendar events were selected
         */
        LoginPage loginPage=new LoginPage();

        loginPage.loginasStoremanager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.checkbox.click();

        Assert.assertTrue(calendarEventsPage.checkbox.isSelected());


    }
    @Test
    public void test6() throws InterruptedException {

        /*
         Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Select “Testers meeting”
5. Verify that following data is displayed:
         */
        LoginPage loginPage=new LoginPage();

        loginPage.loginasStoremanager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        calendarEventsPage.filterButton.click();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.titleFilter.click();

        calendarEventsPage.titleInputBox.sendKeys("Testers Meeting");

        calendarEventsPage.updateButton.click();

        BrowserUtils.waitFor(5);

        BrowserUtils.waitForVisibility(calendarEventsPage.table.get(0),10);


        System.out.println(calendarEventsPage.table.get(0).getText());


        Assert.assertEquals(calendarEventsPage.firstRowTestersMeeting.getText(),"Testers meeting");
        Assert.assertEquals(calendarEventsPage.firsRowtCalendar.getText(),"Stephan Haley", "Verify first row");
        Assert.assertEquals(calendarEventsPage.firstRowStartDate.getText(),"Jun 19, 2020, 2:38 AM", "Verify first row");
        Assert.assertEquals(calendarEventsPage.firstRowEndDate.getText(),"Jun 19, 2020, 3:38 AM", "Verify first row");
        Assert.assertEquals(calendarEventsPage.firstRowRecurrence.getText(),"N/A", "Verify first row");
        Assert.assertEquals(calendarEventsPage.firstRowRecurrent.getText(),"No", "Verify first row");
        Assert.assertEquals(calendarEventsPage.firstRowInStatus.getText(),"Not responded", "Verify first row");


    }
}
