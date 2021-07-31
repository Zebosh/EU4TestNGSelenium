package com.cybertek.tests.day_14_extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //
    ExtentReports report;

    // this class is used to create HTML reports
    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
        // initialize the class
        report=new ExtentReports();

        //create a report path

        String projectPath=System.getProperty("user.dir");

        String path=projectPath+"/test-output/report.html";

        //initialize the html reporter with reporter path
        htmlReporter=new ExtentHtmlReporter(path);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack Smoke Test");

        report.setSystemInfo("Environment", "QA");

        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));

        report.setSystemInfo("OS",System.getProperty("os.name"));


    }

    @Test
    public void test1(){

        extentLogger=report.createTest("TC123 Login as  Driver Test");

        extentLogger.info("Open Chrome browser");

        extentLogger.info("Go this Url");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click login");

        extentLogger.info("Verify logged in");

        extentLogger.pass("TC123 is passed");

    }

    @AfterMethod
    public void  tearDown(){
        //this when the report is actually created
        report.flush();
    }
}
