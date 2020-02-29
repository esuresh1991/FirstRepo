package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class Loginpagetest extends TestBase{
	LoginPage L;
	HomePage Hp;
	ExtentReports extent;
	ExtentHtmlReporter htmlreport;
	ExtentTest testcase;
	
	public Loginpagetest() {
		super();
	}
			
	@BeforeMethod
	public void setUp()
	{
		extent = new ExtentReports();
		htmlreport = new ExtentHtmlReporter("report.HTML");
		extent.attachReporter(htmlreport);
		initalization();
		L = new LoginPage();
		
	}
	
	
	@Test(priority = 1 )
	public void  loginPageTest()
	{
		String title = L.ValidatePageTitle();
		testcase = extent.createTest("Verify Google login");
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");

	
	}
	
	@Test(priority = 2)
	public void  Logintest()
	{
		testcase = extent.createTest("Verify CRM login");
		Hp  = L.Login(P.getProperty("username"), P.getProperty("password"));

	}
	
	
	@AfterMethod
	public void  tearDown()
	{
		
		driver.quit();		
		extent.flush();
	}
	

}
