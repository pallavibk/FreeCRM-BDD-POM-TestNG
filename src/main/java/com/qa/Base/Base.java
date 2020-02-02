package com.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;



public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public Base()
	
	{
	
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Selenium\\Workspace\\FreeCRM-BDD-POM-TestNG\\src\\main\\java\\com\\qa\\config\\config.properties");
		    prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
 String BrowserName=prop.getProperty("browser");
	
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\All_Downloads_For_Selenium\\chromedriver.exe");
			 driver=new ChromeDriver(); 
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",
					"C:\\Programs\\GekoDriver\\geckodriver-v0.24.0-win64\\GekoDriver.exe");
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	public void failed(String testMethodName) throws IOException
	  {
	File ScrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(ScrFile,new File("C:\\Selenium\\Workspace\\FreeCRM-BDD-POM-TestNG\\Scrrenshots\\"
	+testMethodName+"-"+".jpg"));
}
}
