package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class Baseclass 
{
	Filelibrary f=new Filelibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseConnection()
	{
		Reporter.log("database connected", true);
	}
	
	@BeforeClass
	public void launcheedBrowser() throws IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String Link = f.readdatafromProperty("url");
		driver.get(Link);
		Reporter.log("browser launched succesfully",true);
		
	}
	@BeforeMethod
	public void logintoActitime() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		//driver.findElement(By.id("username")).sendKeys("admin");
	//	driver.findElement(By.name("pwd")).sendKeys("manager");
	//	driver.findElement(By.xpath("//div[.='Login'])")).click();
		String UN = f.readdatafromProperty("username");
		lp.getUn().sendKeys(UN);
		String PASS = f.readdatafromProperty("password");
		lp.getPswd().sendKeys(PASS);
		lp.getLogin().click();
		Reporter.log("logged in succesfully",true);
	}
	@AfterMethod
	
		public void loggedoutfromActitime()
		{
			driver.findElement(By.id("logoutLink")).click();
			Reporter.log("logged out succesfully",true);
		}
	@AfterClass
	public void closebrowser()
	{
		driver.close();
		Reporter.log("close browser succesfully",true);
	}

	@AfterSuite
	public void closeddatabaseConnection()
	{
		driver.close();
		Reporter.log("closed database conection succesfully",true);
	}

}
