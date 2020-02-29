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

public class HomePageTest extends TestBase {

	LoginPage L;
	HomePage Hp;
	DealsPage  Dp;
	ContactsPage C;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initalization();
		L = new LoginPage();
		Dp = new  DealsPage();
		C = new ContactsPage();
		Hp = L.Login(P.getProperty("username"), P.getProperty("password"));
	}

	
	@Test(priority= 3)
	public void  loginPageTitleTest()
	{
		String Hptitle = Hp.ValidatePageTitle();
		System.out.println(Hptitle);
		Assert.assertEquals(Hptitle, "Cogmento CRM", "Home  page title is not matched");
	}
	
	@Test(priority= 2)
	public void VerifyUserNameTest()
	{
		Assert.assertTrue(Hp.VerifyUserName());
	}
	
	@Test(priority= 1)
	public void ClickDealstest()
	{
		Dp = Hp.ClickDeals();
		C = Hp.ClickContacts();
	}
	
	@AfterMethod
	public void  tearDown()
	{
		driver.quit();
	}
	
}