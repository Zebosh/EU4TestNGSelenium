package com.cybertek.tests.day_10_fileUpload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test

    public void test1(){

        //Project location folder
        String projectPath = System.getProperty("user.dir");

        //File loaction
        String filePath="/src/test/resources/textfile.txt";

        String fullPath= projectPath+filePath;
        System.out.println(fullPath);



    }


}
