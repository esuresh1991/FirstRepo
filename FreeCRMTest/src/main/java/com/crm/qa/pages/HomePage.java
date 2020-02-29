package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement Username;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement Contacts;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Deals;
	
	//intaiztiing page object
	
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
	//Actions
		public String ValidatePageTitle()
		{
			return driver.getTitle();
		}
	
		public DealsPage ClickDeals()
		{
			Deals.click();
			return new DealsPage();
		}
		
		public ContactsPage ClickContacts()
		{
			Contacts.click();
			return new ContactsPage();
		}
		
		public boolean VerifyUserName()
		{
			return Username.isDisplayed();
		}
		
		
		

}
