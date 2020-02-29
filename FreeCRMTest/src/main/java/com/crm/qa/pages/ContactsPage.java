package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement NewButton;
	
	
	//intaiztiing page object
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String ValidatePageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public ContactsNewPage ClickContactsNewPage()
	{
		NewButton.click();
		return new ContactsNewPage();
	}
	
	
}
