package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.Filelibrary;
import com.Actitime.pom.Homepage;
import com.Actitime.pom.Taskpage;


@Listeners(Listenerimplementation.class)
public class createcust extends Baseclass 
{
@Test
public void addcust() throws EncryptedDocumentException, IOException
{
	Homepage hp=new Homepage(driver);
	hp.getTasktab().click();
	
	Taskpage tp=new Taskpage(driver);
	tp.getAddcust().click();
	tp.getNewcust().click();
	Filelibrary f=new Filelibrary();
	//String name = f.readdatafromExcel("Sheet1",1,1);
	String name = f.readdatafromExcel("Sheet1", 1, 1);
	tp.getCustname().sendKeys(name);
	//String desp = f.readdatafromExcel("Sheet1",1,2);
	String desp = f.readdatafromExcel("Sheet1", 1, 2);
	tp.getCustdesc().sendKeys(desp);
	tp.getCreatecust().click();
	tp.getCanclebutton().click();
	
	//Filelibrary f=new Filelibrary();
	//String name = f.readdatafromExcel("Sheet1", 1, 1);
	//tp.getCustname().sendKeys(name);
	//String desp = f.readdatafromExcel("Sheet1", 1, 2);
	//tp.getCustdesc().sendKeys(desp);
	//tp.getCreatecust().click();
	
	
	String expectedresult = name;
	String actualresult = driver.findElement(By.xpath("//div[.='"+name+"']")).getText();
	SoftAssert s=new SoftAssert();
	s.assertEquals(expectedresult,actualresult);
	s.assertAll();
	
}
}
