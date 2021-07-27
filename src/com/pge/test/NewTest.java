package com.pge.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	static{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishnu Sampath\\new-workspace\\MyFirstTestNG\\Chromedriver\\chromedriver.exe");
	}
	WebDriver driver=new ChromeDriver();
   @Test(dataProvider = "credentials",groups="test")
  public void test(String name,String password) {
	  
	   driver.findElement(By.xpath("//input[@id='email']")).sendKeys(name);
	   driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	   driver.findElement(By.xpath("//button[@name='login']")).click();
	}
  
 @BeforeSuite
 @Parameters({"browser","url"})
 public void browesrName(@Optional("chrome") String browser,String url) {
	 switch (browser.toLowerCase()) {
	case "chrome":
		
		driver.navigate().to(url);
		break;

	default:
		System.out.println("invalid browser");
		break;
	}
	 
 }
 
 
 @DataProvider(name="credentials")
 public Object[][] getData(){
	 Object[][] data= new Object[2][2];
	 data[0][0]="vishnu";
	 data[0][1]="password";
	 
	 data[1][0]="vishnu1";
	 data[1][1]="password1";
	 
	return data;
 }
 
 @AfterSuite
 public void closeBrowser() {
	driver.close();

}
 
}
