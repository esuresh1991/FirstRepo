package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage L;
	HomePage Hp;
	DealsPage Dp;
	ContactsPage C;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initalization();
		L = new LoginPage();
		Dp = new DealsPage();
		C = new ContactsPage();
		Hp = L.Login(P.getProperty("username"), P.getProperty("password"));
		Hp.ClickContacts();

	}

	@Test
	public void VerifyContactsURL() {
		System.out.println(C.ValidatePageUrl());
		Assert.assertEquals(C.ValidatePageUrl(), "https://ui.cogmento.com/contacts");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
