package com.bitm.SeleniumOnlineProject3.Utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGReporting implements ITestListener{

	private WebDriver driver=null;
	
	public void onStart(ITestContext result)
	{
		System.out.println("Test Execution has been started : " +result.getName());
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test has been started : " +result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test has been successfull : : " +result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test has been failed : " +result.getName());
		
		driver=DriverManager.driver;
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desfile= new File("C:\\Users\\Imran\\Desktop\\Screenshot\\Seleniumscreenshot.png");
		
		try {
			
			FileHandler.copy(srcfile, desfile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Screen Shot of failed page has been taken");
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test has been skipped : " +result.getName());
	}
	public void onFinish(ITestContext result)
	{
		System.out.println("Test Execution has been finished : " +result.getName());
	}
}
