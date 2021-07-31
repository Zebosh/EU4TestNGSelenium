package com.cybertek.tests.day_12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class AnotherLoginClass extends TestBase {

    @Test

    public void test1(){
        driver.get("https://google.com");
    }
}
