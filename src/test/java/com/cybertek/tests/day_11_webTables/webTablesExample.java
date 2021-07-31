package com.cybertek.tests.day_11_webTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTablesExample {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();


    }
    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));

    }

    @Test
    public void getAllHeaders(){

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        System.out.println(allRowsWithHeader.size());

        List<WebElement> allRowsWithoutHeader  = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());

    }

    @Test
    public void getRow(){

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        System.out.println(secondRow.getText());

        //get all row information dynamically

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i=1;  i<=numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(i+"-"+row.getText());

        }

        }

        @Test
    public void getAllCellInOneRow(){

            List<WebElement> allCellsinOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

            for (WebElement webElement : allCellsinOneRow) {
                System.out.println(webElement.getText());
            }

        }

    @Test
    public void getSingleCellinRow(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));

        System.out.println(singleCell.getText());

    }

    @Test
    public void printAllCellsbyIndex(){

        int rowNumber=getNumberOfRows();

        int colNumber=getNumberOfColumns();
        System.out.println("rowNumber = " + rowNumber);
        System.out.println("colNumber = " + colNumber);


        for (int i = 1; i <=rowNumber; i++) {

            for (int j = 1; j <=colNumber; j++) {

                String cellxPath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";

                System.out.println(cellxPath);

                WebElement cell=  driver.findElement(By.xpath(cellxPath));
                System.out.print(cell.getText());



            }


        }

    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return columns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows  = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return rows.size();
    }


    @Test
    public void getAllInRelationToAnotherCellInSameRow(){
        String firstName="Jason";

        String Xpath = "//table[@id='table1']/tbody/tr/td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(Xpath));
        System.out.println(email.getText());


    }
}


