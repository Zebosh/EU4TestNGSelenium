package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){

    }
    @Test
    public void test1(){

        System.out.println("Open Browser");
        System.out.println("1st assertion");
        Assert.assertEquals("title", "Title");

        System.out.println("2nd assertion");
         Assert.assertEquals("url", "url");

    }
    @Test
    public void test2(){
        System.out.println("3rd assertion");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test3(){
        String expected="Cyb";
        String actual="Cybertek";

        Assert.assertTrue(actual.startsWith(expected),"Verify title starts with Cyb");
    }


    @Test
    public void test4(){
        //verify email contains @ sign

        String email="mike@smith.com";

        Assert.assertTrue(email.contains("@"),"Verify email contains @ sign");
    }

    @Test
    public void test5(){
       Assert.assertFalse(0>1,"Verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");
    }
}
