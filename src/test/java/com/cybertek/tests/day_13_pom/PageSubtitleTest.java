package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void test1(){

        LoginPage login=new LoginPage();

        login.loginasDriver();

        String expectedSubTitle="Quick Launchpad";

        DashboardPage dashboardPage=new DashboardPage();

        String actualSubTitle=dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle, expectedSubTitle,"Verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        BrowserUtils.waitFor(2);

//        String expectedSubTitle1="Calendar Events";
//
//        String actualSubTitle1= calendarEventsPage.getPageSubTitle();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "Verify subtitle");

    }
}
