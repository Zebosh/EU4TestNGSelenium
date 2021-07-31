package com.cybertek.tests.day_16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //it accepts 2 arguments
        //Arg1: location of the file
        //Arg2: sheet anme we want to open

        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
       //how many rows
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());
        //how many columns
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }
        System.out.println("dataList.size() = " + dataList.size());
        //get one value from excel sheet
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));

        //get "Harber" from excel sheet

        System.out.println("dataList.get(9).get(\"lastname\") = " + dataList.get(8).get("lastname"));

        String [][]dataArray= qa3short.getDataArray();

        System.out.println(Arrays.deepToString(dataArray));


    }
}
