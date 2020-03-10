package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties P;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			
			P = new Properties();
			FileInputStream F = new FileInputStream("C:\\Users\\Suresh\\git\\FirstRepo\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			P.load(F);
			System.out.println(P.getProperty("url"));
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	
	}
	
	public static void initalization() {
		String browsername = P.getProperty("browser");
		
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suresh\\Downloads\\chromedriver_win64\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", "D:\\C drive\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(P.getProperty("url"));
		
	}
	
}
