package com.cybertek.tests.day_12_properties_driver_tests;

public class Singleton {
    //singleton class has private constructor

    private Singleton(){}

    private static String str;

    public static String getInstance(){
        if(str==null){
            System.out.println("str is null. Assigning  a value to it.");
            str="somevalue";
        }else {
            System.out.println("It has a value. Just returning it.");
        }
        return str;
    }

}
