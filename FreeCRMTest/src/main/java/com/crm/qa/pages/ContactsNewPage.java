package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsNewPage extends TestBase {

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement Fn;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement Ln;

	@FindBy(xpath = "//div[@name='company']//input[@class='search']")
	WebElement Co;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement Em;

	@FindBy(xpath = "//i[@class='save icon']")
	WebElement Save;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement Contacts;

	// intaiztiing page object

	public ContactsNewPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions

	public void ContactsSave(String Firstname, String LastName, String Com, String Email) {
		Fn.sendKeys(Firstname);
		Ln.sendKeys(LastName);
		Co.sendKeys(Com);
		Em.sendKeys(Email);
		Save.click();

		Contacts.click();
	}

}
