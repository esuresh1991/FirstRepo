package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "email")
	@CacheLookup
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement Login;

	// intaiztiing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String ValidatePageTitle() {
		return driver.getTitle();
	}

	public HomePage Login(String Un, String Pa) {
		email.sendKeys(Un);
		password.sendKeys(Pa);
		Login.click();

		return new HomePage();
	}

}
