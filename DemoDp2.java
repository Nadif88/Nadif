package DataProvider;



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDp2 {
  @Test(dataProvider = "LOginData")
  public void f(String uname, String pass) {
	  System.setProperty("webdriver.chrome.driver","Chromedriver.exe" );
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("file:///C:/Users/ADMIN/AppData/Local/Temp/Rar$EX00.969/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	  driver.findElement(By.id("email")).sendKeys(uname);
	  driver.findElement(By.id("password")).sendKeys(pass);
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

	    Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");


	  
  }

  @DataProvider
  public Object[][] LOginData() throws Exception {
     {
    	 FileInputStream fis = new FileInputStream("nadif.xla");
 		Workbook wb = Workbook.getWorkbook(fis);
 	       Sheet sh	=wb.getSheet("Sheet1");
 			
 	           int row = sh.getRows();
 	           int col	= sh.getColumns();
 	            
 	           System.out.println("row >> "+ row);
 	           System.out.println("colum >> "+ col);
 	      
 	            String[][] arrdata = new String[row][col]; 
 	            
 	               for( int i=0; i<row; i++)
 	                {
 	                	for(int j=0; j<col; j++)
 	    	             {
 	    	              	Cell cel=sh.getCell(j,i); 
 	    		            String data=cel.getContents();
 	    	            	System.out.println(data);
 	    	            	
 	    	            	arrdata [i][j]= data;

                           }
                      }
 	                    return arrdata;
 	                       }
                   }

    
  }

