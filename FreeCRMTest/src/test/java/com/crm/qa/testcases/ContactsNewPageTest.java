package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsNewPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsNewPageTest extends TestBase {

	LoginPage L;
	HomePage Hp;
	DealsPage  Dp;
	ContactsPage C;
	ContactsNewPage Cn;
	String sheetName = "Contacts";

	public ContactsNewPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initalization();
		L = new LoginPage();
		Dp = new  DealsPage();
		C = new ContactsPage();
		Cn  = new ContactsNewPage();
		Hp = L.Login(P.getProperty("username"), P.getProperty("password"));
		Hp.ClickContacts();
		C.ClickContactsNewPage();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void AddNewContact(String Firstname,String Lastname,String Company,String Email ){
	
			//Cn.ContactsSave(P.getProperty("Fn"), P.getProperty("Ln"), P.getProperty("Co"), P.getProperty("Email"));
		Cn.ContactsSave(Firstname, Lastname, Company, Email);
	}
		
	
	
	@AfterMethod
	public void  tearDown()
	{
		driver.quit();
	}
	
}
