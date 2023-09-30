package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpage
{
    //declaration
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addcust;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcust;
	
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesc;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcust;
	
	@FindBy(xpath="//div[@class='greyButton cancelBtn']")
	private WebElement canclebutton;
	
	
	//initialization
	public Taskpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization

	public WebElement getAddcust() {
		return addcust;
	}


	public WebElement getNewcust() {
		return newcust;
	}


	public WebElement getCustname() {
		return custname;
	}


	public WebElement getCustdesc() {
		return custdesc;
	}


	public WebElement getCreatecust() {
		return createcust;
	}


	public WebElement getCanclebutton() {
		return canclebutton;
	}
	
	
}
